package be.kdg.view.admin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import be.kdg.model.Werelddelen;
import be.kdg.view.ViewConstants;

/**
 * @author Laura Van den Brande
 * @version 1.0 23/02/2019 19:52
 */
public class AdminView extends VBox {
    // Variabelen declareren
    private Label lblWerelddeel;
    private ComboBox cbWerelddeel;
    private Label lblNaam;
    private TextField tfNaam;
    private Label lblKaart;
    private TextField tfKaart;
    private Button btnBrowseKaart;
    private Label lblVlag;
    private TextField tfVlag;
    private Button btnBrowseVlag;
    private Label lblHoofdstad;
    private TextField tfHoofdstad;

    private Label lblError;
    private Button btnWijzigLand;
    private Button btnVerwijderLand;
    private Button btnVoegLandToe;

    private Button btnAnnuleer;
    private Button btnMenu;

    private FileChooser fcKaart;
    private FileChooser fcVlag;

    // Constructor
    public AdminView() {
        initialiseNodes();
        layoutNodes();
    }

    TextField getTfNaam() {
        return tfNaam;
    }

    ComboBox getCbWerelddeel() { return cbWerelddeel; }

    TextField getTfKaart() {
        return tfKaart;
    }

    Button getBtnBrowseKaart() { return btnBrowseKaart; }

    TextField getTfVlag() {
        return tfVlag;
    }

    Button getBtnBrowseVlag() {
        return btnBrowseVlag;
    }

    TextField getTfHoofdstad() {
        return tfHoofdstad;
    }

    Button getBtnAnnuleer() {
        return btnAnnuleer;
    }

    Button getBtnWijzigLand() {
        return btnWijzigLand;
    }

    Button getBtnVerwijderLand() {
        return btnVerwijderLand;
    }

    Button getBtnVoegLandToe() {
        return btnVoegLandToe;
    }

    Button getBtnMenu() {
        return btnMenu;
    }

    Label getLblError() {
        return lblError;
    }

    FileChooser getFcKaart() {
        return fcKaart;
    }

    FileChooser getFcVlag() {
        return fcVlag;
    }

    // Methoden

    private void initialiseNodes(){
        lblWerelddeel = new Label("Werelddeel:");
        cbWerelddeel = new ComboBox();
        cbWerelddeel.getItems().setAll(Werelddelen.values());
        cbWerelddeel.setPromptText("Kies werelddeel");
        lblNaam = new Label("Naam:");
        tfNaam = new TextField();
        lblKaart = new Label("Kaart:");
        tfKaart = new TextField();
        btnBrowseKaart = new Button("Bladeren");
        fcKaart = new FileChooser();
        fcKaart.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        lblVlag = new Label("Vlag:");
        tfVlag = new TextField();
        btnBrowseVlag = new Button("Bladeren");
        fcVlag = new FileChooser();
        fcVlag.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        lblHoofdstad = new Label("Hoofdstad:");
        tfHoofdstad = new TextField();

        btnWijzigLand = new Button("Wijzig land");
        btnVerwijderLand = new Button("Verwijder land");
        btnVoegLandToe = new Button("Voeg land toe");
        btnAnnuleer = new Button("Annuleer");
        lblError = new Label("");
        btnMenu = new Button("Menu");
    }

    private void layoutNodes(){
        lblWerelddeel.setPrefWidth(ViewConstants.LABEL_WIDTH);
        lblNaam.setPrefWidth(ViewConstants.LABEL_WIDTH);
        lblKaart.setPrefWidth(ViewConstants.LABEL_WIDTH);
        lblVlag.setPrefWidth(ViewConstants.LABEL_WIDTH);
        lblHoofdstad.setPrefWidth(ViewConstants.LABEL_WIDTH);

        cbWerelddeel.setPrefWidth(ViewConstants.COMBOBOX_WIDTH_LARGE);
        tfNaam.setPrefWidth(ViewConstants.TEXTFIELD_WIDTH);
        tfKaart.setPrefWidth(ViewConstants.TEXTFIELD_WIDTH);
        tfVlag.setPrefWidth(ViewConstants.TEXTFIELD_WIDTH);
        tfHoofdstad.setPrefWidth(ViewConstants.TEXTFIELD_WIDTH);
        btnBrowseKaart.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnBrowseVlag.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnWijzigLand.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnVerwijderLand.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnVoegLandToe.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnAnnuleer.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnMenu.setPrefWidth(ViewConstants.BUTTON_WIDTH);

        final GridPane gridInputs = new GridPane();         // in aparte klasse?
        gridInputs.setHgap(ViewConstants.GRID_HGAP);
        gridInputs.setVgap(ViewConstants.GRID_VGAP);
        gridInputs.setPadding(ViewConstants.GRID_PADDING);

        gridInputs.add(lblWerelddeel,0,0);
        gridInputs.add(cbWerelddeel,1,0);
        gridInputs.add(lblNaam,0,1);
        gridInputs.add(tfNaam,1,1);
        gridInputs.add(lblKaart,0,2);
        gridInputs.add(tfKaart,1,2);
        gridInputs.add(btnBrowseKaart,2,2);
        gridInputs.add(lblVlag,0,3);
        gridInputs.add(tfVlag,1,3);
        gridInputs.add(btnBrowseVlag,2,3);
        gridInputs.add(lblHoofdstad,0,4);
        gridInputs.add(tfHoofdstad,1,4);

        final HBox editButtons = new HBox();
        editButtons.setSpacing(ViewConstants.SPACING_REGULAR);
        editButtons.setPadding(ViewConstants.INSETS_BOTTOM_BUTTONS);
        editButtons.getChildren().addAll(btnVoegLandToe, btnWijzigLand, btnVerwijderLand, btnAnnuleer);
        editButtons.setAlignment(Pos.CENTER);

        this.setSpacing(ViewConstants.SPACING_REGULAR);
        this.setPadding(ViewConstants.INSETS_REGULAR);
        this.getChildren().addAll(gridInputs,editButtons,lblError, btnMenu);
        this.setAlignment(Pos.CENTER);
    }
}
