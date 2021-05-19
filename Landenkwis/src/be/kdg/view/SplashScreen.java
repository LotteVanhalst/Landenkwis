package be.kdg.view;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Laura Van den Brande
 * @version 1.0 07/03/2019 20:56
 */
public class SplashScreen extends Preloader {
    ImageView splash;
    Stage stage;

    private Scene createPreloaderScene() {
        splash = new ImageView(new Image("/afbeeldingen/splash.png"));
        splash.setFitWidth(800);
        splash.setPreserveRatio(true);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(splash);
        return new Scene(borderPane);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Probleem met het laden.");
            alert.showAndWait();
        }
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

}
