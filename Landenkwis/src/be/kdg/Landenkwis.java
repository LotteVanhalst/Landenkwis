import be.kdg.model.Quiz;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import be.kdg.view.SplashScreen;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;

/**
 * Dit is de klasse met de main methode. Van hieruit wordt er naar de StartView gegaan waar de applicatie start en waar de uitvoering gekozen kan worden.
 *
 * @author Laura Van den Brande en Lotte Vanhalst
 * @version 1.0 15/02/2019 21:33
 */
public class Landenkwis extends Application {

    @Override
    /**
     * Dit is de constructor van de klasse. Met deze constructor wordt er naar de StartView gegaan die op de stage geplaatst wordt.
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        StartView view = new StartView();
        Quiz model = new Quiz();
        StartPresenter presenter = new StartPresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("css/landenkwis.css");
        primaryStage.setScene(scene);
        presenter.addWindowEventHandlers();
        primaryStage.setTitle("Landenkwis");
        primaryStage.show();
    }

    /**
     * Met deze methode wordt het spel gestart. Er wordt eerst een splash screen getoond.
     *
     * @param args
     */

    public static void main(String[] args) {
        // Application.launch(args);
        LauncherImpl.launchApplication(Landenkwis.class, SplashScreen.class, args);
    }
}


