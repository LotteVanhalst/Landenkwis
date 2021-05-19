package be.kdg.view.login;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import be.kdg.view.ViewConstants;


/**
 * @author Laura Van den Brande
 * @version 1.0 28/02/2019 19:26
 */
public class LoginView extends GridPane {

    // Variabelen declareren
    private Label lblGebruikersNaam;
    private TextField tfGebruikersNaam;
    private Label lblWachtwoord;
    private PasswordField pfWachtwoord;
    private Button btnLogin;
    private Button btnTerug;
    private Label lblError;

    // Constructor
    public LoginView() {
        initialiseNodes();
        layoutNodes();
    }

    TextField getTfGebruikersNaam() {
        return tfGebruikersNaam;
    }

    PasswordField getPfWachtwoord() {
        return pfWachtwoord;
    }

    Button getBtnLogin() {
        return btnLogin;
    }

    Button getBtnTerug() {
        return btnTerug;
    }

    Label getLblError() {
        return lblError;
    }

    // Methoden
    private void initialiseNodes() {
        lblGebruikersNaam = new Label("Gebruikersnaam:");
        tfGebruikersNaam = new TextField();
        lblWachtwoord = new Label("Wachtwoord:");
        pfWachtwoord = new PasswordField();

        btnLogin = new Button("Login");
        lblError = new Label("Hier komt de foutboodschap indien nodig");
        btnTerug = new Button("Terug");
    }

    private void layoutNodes() {
        tfGebruikersNaam.setMaxWidth(ViewConstants.TEXTFIELD_WIDTH);
        pfWachtwoord.setMaxWidth(ViewConstants.TEXTFIELD_WIDTH);
        btnTerug.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnLogin.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        lblError.setPrefSize(375, 20);

        this.setHgap(ViewConstants.GRID_HGAP);
        this.setVgap(ViewConstants.GRID_VGAP);
        this.setPadding(ViewConstants.GRID_PADDING_LARGE);

        this.add(lblGebruikersNaam,0,0);
        this.add(tfGebruikersNaam,1,0);
        this.add(lblWachtwoord,0,1);
        this.add(pfWachtwoord,1,1);
        this.add(lblError,0,4,2,1);
        this.add(btnLogin,0,5,2,1);
        this.add(btnTerug,0,6,2,1);

        this.setHalignment(btnLogin, HPos.CENTER);
        this.setHalignment(btnTerug, HPos.CENTER);
    }
}
