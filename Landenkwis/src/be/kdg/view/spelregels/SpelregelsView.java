package be.kdg.view.spelregels;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author Laura Van den Brande
 * @version 1.0 28/02/2019 21:32
 */
public class SpelregelsView extends VBox {

    // Variabelen declareren
    private Label lblSpelregels;

    Label getLblSpelregels() {
        return lblSpelregels;
    }

    // Constructor
    public SpelregelsView() {
        initialiseNodes();
        layoutNodes();
    }

    // Methoden
    private void initialiseNodes(){
        lblSpelregels = new Label("");
    }

    private void layoutNodes(){
        this.getChildren().addAll(lblSpelregels);
    }
}
