package be.kdg.view.spelregels;


import be.kdg.model.Spelregels;
import javafx.scene.control.Alert;


/**
 * @author Lotte Vanhalst
 * @version 1.0 1/03/2019 10:08
 */
public class SpelregelsPresenter {
    private SpelregelsView view;
    private Spelregels model;

    public SpelregelsPresenter(Spelregels model, SpelregelsView view) {
        this.model = model;
        this.view = view;
        this.updateView();
    }


    private void updateView() {
        try {
            view.getLblSpelregels().setText(model.toonSpelregels());
        } catch (Exception exc){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Het bestand kan niet geopend worden.");
            alert.showAndWait();
        }
    };
}
