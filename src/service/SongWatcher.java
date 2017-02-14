package service;

import org.codejargon.feather.Feather;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

@Singleton
public class SongWatcher {

    public void startSongWatcher(Feather feather) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", "amip");
            WatchKey key = dir.register(watcher, ENTRY_MODIFY);
            int i = 0;

            for(;;) {
                WatchKey wk = watcher.take();
                for(WatchEvent<?> event : wk.pollEvents()) {
                    Path changed = (Path) event.context();
                    //Each song change creates two events, processing the first is enough
                    if(changed.endsWith("foobar-playing.txt") && (i = (i+1) % 2) == 1) {
                        SongExtractor songExtractor = feather.instance(SongExtractor.class);
                        ChordFetcher chordFetcher = feather.instance(ChordFetcher.class);
                        chordFetcher.fetchChords(songExtractor.getCurrentSong(Paths.get(dir.toString(), changed.toString())));
                    }

                    boolean valid = wk.reset();
                    if(!valid) {
                        //Key has been unregistered
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
