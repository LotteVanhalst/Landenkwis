package be.kdg.view.oefening;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import be.kdg.view.ViewConstants;


/**
 * @author Laura Van den Brande
 * @version 1.0 16/02/2019 10:24
 */
public class OefeningView extends GridPane {

    // Variabelen declareren

    private ImageView imgKaart;
    private StackPane imgStack;
    private Label lblLand;
    private Label lblTip;
    private TextField tfAntwoord;
    private Label lblUitleg;
    private Button btnTip;
    private Button btnStart;
    private Button btnVolgende;
    private Label lblJuistAntwoord;
    private Button btnTerug;


    // Constructor

    public OefeningView() {
        initialiseNodes();
        layoutNodes();
    }

    Button getBtnStart() { return btnStart; }

    ImageView getImgKaart() {
        return imgKaart;
    }

    Label getLblLand() { return lblLand; }

    Label getLblTip() {
        return lblTip;
    }

    TextField getTfAntwoord() {
        return tfAntwoord;
    }

    Label getLblUitleg() { return lblUitleg; }

    Button getBtnTip() {
        return btnTip;
    }

    Button getBtnVolgende() {
        return btnVolgende;
    }

    Label getLblJuistAntwoord() { return lblJuistAntwoord; }

    Button getBtnTerug() {
        return btnTerug;
    }

    // Methoden

    private void initialiseNodes() {
        imgKaart = new ImageView("/afbeeldingen/kaarten/EUROPA.png");
        imgKaart.setFitWidth(800);
        imgKaart.setPreserveRatio(true);
        imgStack = new StackPane();
        imgStack.getChildren().add(imgKaart);
        imgStack.setStyle(ViewConstants.IMG_SHADOW);
        lblLand = new Label("Land");
        lblLand.setFont(ViewConstants.LABEL_LARGE);
        lblLand.getStyleClass().add("label-land");
        lblJuistAntwoord = new Label("");
        lblTip = new Label("");
        tfAntwoord = new TextField();
        tfAntwoord.setMaxWidth(ViewConstants.TEXTFIELD_WIDTH);
        lblUitleg = new Label("Typ het juiste antwoord en druk op ENTER.");
        btnTip = new Button("Tip");
        btnTip.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnStart = new Button("Start");
        btnStart.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnVolgende= new Button("Volgende");
        btnVolgende.setPrefWidth(ViewConstants.BUTTON_WIDTH);
        btnTerug= new Button("Menu");
        btnTerug.setPrefWidth(ViewConstants.BUTTON_WIDTH);
    }

    private void layoutNodes() {

        this.setHgap(ViewConstants.GRID_HGAP);
        this.setVgap(ViewConstants.GRID_VGAP);
        this.setPadding(ViewConstants.GRID_PADDING);

        this.add(imgStack, 0, 0, 4,1);
        this.add(lblLand, 0, 1, 4,1);
        this.add(lblJuistAntwoord,1,2,2,1);
        this.add(tfAntwoord, 1,3,2,1);
        this.add(lblUitleg, 1,3,2,1);
        this.add(lblTip, 1,4,2,1);
        this.add(btnStart, 1, 5,2,1);
        this.add(btnTip,1,5);
        this.add(btnVolgende,2,5);
        this.add(btnTerug,1,6,2,1);
        setHalignment(lblLand, HPos.CENTER);
        setValignment(lblLand, VPos.TOP);
        setHalignment(lblTip, HPos.CENTER);
        setHalignment(lblJuistAntwoord, HPos.CENTER);
        setHalignment(tfAntwoord, HPos.CENTER);
        setHalignment(lblUitleg, HPos.CENTER);
        setHalignment(btnTip, HPos.RIGHT);
        setHalignment(imgKaart, HPos.CENTER);
        setHalignment(btnStart, HPos.CENTER);
        setHalignment(btnTerug, HPos.CENTER);

        ColumnConstraints column0 = new ColumnConstraints(100);
        ColumnConstraints column1 = new ColumnConstraints((imgKaart.getFitWidth() - 200) / 2);
        ColumnConstraints column2 = new ColumnConstraints((imgKaart.getFitWidth() - 200) / 2);
        ColumnConstraints column3 = new ColumnConstraints(100);
        RowConstraints row0 = new RowConstraints();
        row0.setMinHeight(400);
        this.getColumnConstraints().addAll(column0,column1,column2,column3);
        this.getRowConstraints().addAll(row0);

    }
}
