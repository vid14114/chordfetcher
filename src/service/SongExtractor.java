package service;

import model.ImmutableSong;
import model.Song;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Singleton
public class SongExtractor {

    public Song getCurrentSong(Path filePath) {
        try {
            Optional<String> optionalSong = Files.lines(filePath, Charset.forName("Cp1252")).findFirst();
            if(optionalSong.isPresent()) {
                String[] stringSong = optionalSong.get().split("-");
                Song s = ImmutableSong.builder().artist(stringSong[0]).title(stringSong[1]).build();
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }
}
