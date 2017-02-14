import org.codejargon.feather.Feather;
import service.SongWatcher;

public class Main {
    public static void main(String[] args) {
        Feather feather = Feather.with();
        SongWatcher sw = feather.instance(SongWatcher.class);
        sw.startSongWatcher(feather);
    }
}
