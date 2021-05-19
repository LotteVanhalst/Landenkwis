package be.kdg.view.quiz;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import be.kdg.view.ViewConstants;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


/**
 * @author Laura Van den Brande
 * @version 1.0 16/02/2019 11:18
 */
public class QuizView extends GridPane {

    // Variabelen declareren

    private Label lblScore;
    private ProgressIndicator indicatorTijd;
    private ImageView imgKaart;
    private StackPane imgStack;
    private Label lblLand;
    private Label lblJuistAntwoord;
    private TextField tfAntwoord;
    private Label lblUitleg;
    private Button btnStart;
    private Button btnVolgende;
    private Button btnTerug;


    // Constructor

    public QuizView() {
        initialiseNodes();
        layoutNodes();
    }

    // Getters en Setters

    Label getLblScore() { return lblScore; }

    ProgressIndicator getIndicatorTijd() { return indicatorTijd; }

    ImageView getImgKaart() {
        return imgKaart;
    }

    Label getLblLand() { return lblLand; }

    Label getLblJuistAntwoord() { return lblJuistAntwoord; }

    TextField getTfAntwoord() {
        return tfAntwoord;
    }

    Label getLblUitleg() { return lblUitleg; }

    Button getBtnStart() { return btnStart; }

    Button getBtnVolgende() { return btnVolgende; }

    Button getBtnTerug() { return btnTerug; }


    // Methoden

    private void initialiseNodes() {
        lblScore = new Label("Score");
        lblScore.setFont(Font.font(25));
        indicatorTijd = new ProgressIndicator(0.0);
        imgKaart = new ImageView("/afbeeldingen/kaarten/EUROPA.png");
        imgKaart.setFitWidth(800);
        imgKaart.setPreserveRatio(true);
        imgStack = new StackPane();
        imgStack.getChildren().add(imgKaart);
        imgStack.setStyle(ViewConstants.IMG_SHADOW);
        lblLand = new Label("Land");
        lblLand.setFont(ViewConstants.LABEL_LARGE);
        lblLand.getStyleClass().add("label-land");
        lblJuistAntwoord = new Label();
        tfAntwoord = new TextField();
        tfAntwoord.setMaxWidth(200);
        lblUitleg = new Label("Typ het juiste antwoord en druk op ENTER.");
        btnStart = new Button("Start");
        btnStart.setPrefWidth(100);
        btnVolgende= new Button("Volgende");
        btnVolgende.setPrefWidth(100);
        btnTerug= new Button("Menu");
        btnTerug.setPrefWidth(100);
    }

    private void layoutNodes() {
        this.setHgap(ViewConstants.GRID_HGAP);
        this.setVgap(ViewConstants.GRID_VGAP);
        this.setPadding(ViewConstants.GRID_PADDING);

        this.add(lblScore, 0,0);
        this.add(indicatorTijd, 4, 0);
        this.add(imgStack,0,1,5,1);
        this.add(lblLand,0,2,5,1);
        this.add(lblJuistAntwoord,1,3,2,1);
        this.add(tfAntwoord,1,4,2,1);
        this.add(lblUitleg,1,4,2,1);
        this.add(btnStart, 1, 5,2,1);
        this.add(btnVolgende, 1,5,2,1);
        this.add(btnTerug, 1, 6,2,1);
        setHalignment(lblLand, HPos.CENTER);
        setValignment(lblLand, VPos.BASELINE);
        setHalignment(lblJuistAntwoord, HPos.CENTER);
        setHalignment(tfAntwoord, HPos.CENTER);
        setHalignment(lblUitleg, HPos.CENTER);
        setHalignment(btnTerug, HPos.CENTER);
        setHalignment(btnStart, HPos.CENTER);
        setHalignment(btnVolgende, HPos.CENTER);
        setHalignment(indicatorTijd, HPos.LEFT);
        setHalignment(imgKaart, HPos.CENTER);

        ColumnConstraints column0 = new ColumnConstraints(120);
        ColumnConstraints column1 = new ColumnConstraints((imgKaart.getFitWidth() - 200) / 2);
        ColumnConstraints column2 = new ColumnConstraints((imgKaart.getFitWidth() - 200) / 2);
        ColumnConstraints column3 = new ColumnConstraints(55);
        ColumnConstraints column4 = new ColumnConstraints(55);
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(400);
        this.getColumnConstraints().addAll(column0,column1,column2,column3,column4);
        this.getRowConstraints().addAll(row0,row1);
    }


}
