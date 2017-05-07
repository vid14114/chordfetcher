import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.codejargon.feather.Feather;
import service.SongWatcher;

public class Main extends Application {
    private static WebView webView;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Feather feather = Feather.with();
        webView = new WebView();
        webView.getEngine().setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
        webView.getEngine().load("https://github.com/vid14114/chordfetcher");
        primaryStage.setScene(new Scene(webView));
        primaryStage.show();
        new Thread(new SongWatcher(feather, webView)).start();
    }
}
