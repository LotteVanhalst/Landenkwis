package be.kdg.view.start;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import be.kdg.model.Type;
import be.kdg.model.Werelddelen;
import be.kdg.view.ViewConstants;

/**
 * @author Laura Van den Brande
 * @version 1.0 15/02/2019 21:34
 */
public class StartView extends VBox {

    // Variabelen declareren
    private Label lblGeefNaam;
    private TextField tfNaam;
    private ComboBox cbKiesContinent;
    private ComboBox cbKiesType;
    RadioButton rbKiesQuiz;
    RadioButton rbKiesOefenen;
    private Button btnStart;
    private Button btnHelp;
    private Button btnAdmin;
    private ToggleGroup kiesSpel;
    private ComboBox cbKiesTopscore;


    // Constructor
    public StartView() {
        initialiseNodes();
        layoutNodes();
    }


    // Getters en Setters
    public Button getBtnStart() { return btnStart; }

    public ComboBox getCbKiesContinent() { return cbKiesContinent; }

    public ComboBox getCbKiesType() { return cbKiesType; }

    public RadioButton getRbKiesQuiz() { return rbKiesQuiz; }

    public RadioButton getRbKiesOefenen() { return rbKiesOefenen; }

    public TextField getTfNaam() { return tfNaam; }

    public Label getLblGeefNaam() { return lblGeefNaam; }

    public Button getBtnHelp() { return btnHelp; }

    public Button getBtnAdmin() { return btnAdmin; }

    public ComboBox getCbKiesTopscore() {
        return cbKiesTopscore;
    }

    // Methoden

    private void initialiseNodes(){
        lblGeefNaam = new Label("Geef je naam in:");
        tfNaam = new TextField("Naam");

        cbKiesContinent = new ComboBox();
        cbKiesContinent.getItems().setAll(Werelddelen.values());
        cbKiesContinent.setPromptText("Kies werelddeel");

        cbKiesTopscore = new ComboBox();
        cbKiesTopscore.getItems().setAll(Type.values());
        cbKiesTopscore.setPromptText("Topscores");

        cbKiesType =  new ComboBox();
        cbKiesType.getItems().setAll(Type.values());
        cbKiesType.setPromptText("Kies spel");

        kiesSpel = new ToggleGroup();
        rbKiesQuiz = new RadioButton("Quiz");
        rbKiesQuiz.setToggleGroup(kiesSpel);
        rbKiesQuiz.setSelected(true);
        rbKiesOefenen = new RadioButton("Oefenen");
        rbKiesOefenen.setToggleGroup(kiesSpel);

        btnStart = new Button("Start");


        btnHelp = new Button("Spelregels");
        btnAdmin = new Button("Admin");
    }

    private void layoutNodes(){
        this.tfNaam.setPrefWidth(ViewConstants.TEXTFIELD_WIDTH);
        this.cbKiesContinent.setPrefWidth(ViewConstants.COMBOBOX_WIDTH_LARGE);
        this.cbKiesTopscore.setPrefWidth(ViewConstants.COMBOBOX_WIDTH_MEDIUM);
        this.cbKiesType.setPrefWidth(ViewConstants.COMBOBOX_WIDTH_LARGE);
        this.btnStart.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        this.cbKiesTopscore.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        this.btnHelp.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        this.btnAdmin.setPrefWidth(ViewConstants.BUTTON_WIDTH);

        final VBox naam = new VBox();
        naam.setSpacing(ViewConstants.SPACING_SMALL);
        naam.setPadding(ViewConstants.INSETS_SUBGROUP);
        naam.getChildren().addAll(lblGeefNaam, tfNaam);

        final VBox radioButtons = new VBox();
        radioButtons.setSpacing(ViewConstants.SPACING_SMALL);
        radioButtons.setPadding(ViewConstants.INSETS_SUBGROUP);
        radioButtons.getChildren().addAll(rbKiesQuiz,rbKiesOefenen);
        radioButtons.setMaxWidth(ViewConstants.BUTTON_WIDTH);

        final VBox startButton = new VBox();
        startButton.setPadding(ViewConstants.INSETS_SUBGROUP);
        startButton.getChildren().addAll(btnStart);
        startButton.setAlignment(Pos.CENTER);

        this.setSpacing(ViewConstants.SPACING_REGULAR);
        this.setPadding(ViewConstants.INSETS_REGULAR);
        this.getChildren().addAll(naam, cbKiesContinent, cbKiesType, radioButtons, startButton, cbKiesTopscore, btnHelp, btnAdmin);

        this.setAlignment(Pos.CENTER);
    }

}
