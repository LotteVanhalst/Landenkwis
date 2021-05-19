package be.kdg.view.topscore;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import be.kdg.view.ViewConstants;

/**
 * @author Laura Van den Brande
 * @version 1.0 23/02/2019 21:40
 */
public class TopscoreView extends GridPane {

    //Variabelen declareren

    private Label lblTypeScore;

    private Label lblPos1;
    private Label lblPos2;
    private Label lblPos3;
    private Label lblPos4;
    private Label lblPos5;
    private Label lblPos6;
    private Label lblPos7;
    private Label lblPos8;
    private Label lblPos9;
    private Label lblPos10;

    private Label lblSpeler1;
    private Label lblSpeler2;
    private Label lblSpeler3;
    private Label lblSpeler4;
    private Label lblSpeler5;
    private Label lblSpeler6;
    private Label lblSpeler7;
    private Label lblSpeler8;
    private Label lblSpeler9;
    private Label lblSpeler10;

    private Label lblScore1;
    private Label lblScore2;
    private Label lblScore3;
    private Label lblScore4;
    private Label lblScore5;
    private Label lblScore6;
    private Label lblScore7;
    private Label lblScore8;
    private Label lblScore9;
    private Label lblScore10;

    private Label lblDatum1;
    private Label lblDatum2;
    private Label lblDatum3;
    private Label lblDatum4;
    private Label lblDatum5;
    private Label lblDatum6;
    private Label lblDatum7;
    private Label lblDatum8;
    private Label lblDatum9;
    private Label lblDatum10;

    private Button btnMenu;


    // Constructor

    public TopscoreView() {
        initialiseNodes();
        layoutNodes();
    }


    Label getLblTypeScore() { return lblTypeScore; }

    Label getLblSpeler1() { return lblSpeler1; }

    Label getLblSpeler2() { return lblSpeler2; }

    Label getLblSpeler3() { return lblSpeler3; }

    Label getLblSpeler4() { return lblSpeler4; }

    Label getLblSpeler5() { return lblSpeler5; }

    Label getLblSpeler6() { return lblSpeler6; }

    Label getLblSpeler7() { return lblSpeler7; }

    Label getLblSpeler8() { return lblSpeler8; }

    Label getLblSpeler9() { return lblSpeler9; }

    Label getLblSpeler10() { return lblSpeler10; }

    Label getLblScore1() { return lblScore1; }

    Label getLblScore2() { return lblScore2; }

    Label getLblScore3() { return lblScore3; }

    Label getLblScore4() { return lblScore4; }

    Label getLblScore5() { return lblScore5; }

    Label getLblScore6() { return lblScore6; }

    Label getLblScore7() { return lblScore7; }

    Label getLblScore8() { return lblScore8; }

    Label getLblScore9() { return lblScore9; }

    Label getLblScore10() { return lblScore10; }

    Label getLblDatum1() { return lblDatum1; }

    Label getLblDatum2() { return lblDatum2; }

    Label getLblDatum3() { return lblDatum3; }

    Label getLblDatum4() { return lblDatum4; }

    Label getLblDatum5() { return lblDatum5; }

    Label getLblDatum6() { return lblDatum6; }

    Label getLblDatum7() { return lblDatum7; }

    Label getLblDatum8() { return lblDatum8; }

    Label getLblDatum9() { return lblDatum9; }

    Label getLblDatum10() { return lblDatum10; }

    Button getBtnMenu() { return btnMenu; }


    // Methodes

    private void initialiseNodes(){
        lblTypeScore = new Label("");

        lblPos1 = new Label("1");
        lblPos2 = new Label("2");
        lblPos3 = new Label("3");
        lblPos4 = new Label("4");
        lblPos5 = new Label("5");
        lblPos6 = new Label("6");
        lblPos7 = new Label("7");
        lblPos8 = new Label("8");
        lblPos9 = new Label("9");
        lblPos10 = new Label("10");

        lblSpeler1 = new Label("");
        lblSpeler1.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler2 = new Label("");
        lblSpeler2.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler3 = new Label("");
        lblSpeler3.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler4 = new Label("");
        lblSpeler4.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler5 = new Label("");
        lblSpeler5.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler6 = new Label("");
        lblSpeler6.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler7 = new Label("");
        lblSpeler7.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler8 = new Label("");
        lblSpeler8.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler9 = new Label("");
        lblSpeler9.setFont(ViewConstants.LABEL_LARGE);
        lblSpeler10 = new Label("");
        lblSpeler10.setFont(ViewConstants.LABEL_LARGE);

        lblDatum1 = new Label("");
        lblDatum1.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum2 = new Label("");
        lblDatum2.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum3 = new Label("");
        lblDatum3.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum4 = new Label("");
        lblDatum4.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum5 = new Label("");
        lblDatum5.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum6 = new Label("");
        lblDatum6.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum7 = new Label("");
        lblDatum7.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum8 = new Label("");
        lblDatum8.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum9 = new Label("");
        lblDatum9.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);
        lblDatum10 = new Label("");
        lblDatum10.setStyle(ViewConstants.LABEL_LESS_IMPORTANT);

        lblScore1 = new Label("");
        lblScore1.setFont(ViewConstants.LABEL_LARGE);
        lblScore2 = new Label("");
        lblScore2.setFont(ViewConstants.LABEL_LARGE);
        lblScore3 = new Label("");
        lblScore3.setFont(ViewConstants.LABEL_LARGE);
        lblScore4 = new Label("");
        lblScore4.setFont(ViewConstants.LABEL_LARGE);
        lblScore5 = new Label("");
        lblScore5.setFont(ViewConstants.LABEL_LARGE);
        lblScore6 = new Label("");
        lblScore6.setFont(ViewConstants.LABEL_LARGE);
        lblScore7 = new Label("");
        lblScore7.setFont(ViewConstants.LABEL_LARGE);
        lblScore8 = new Label("");
        lblScore8.setFont(ViewConstants.LABEL_LARGE);
        lblScore9 = new Label("");
        lblScore9.setFont(ViewConstants.LABEL_LARGE);
        lblScore10 = new Label("");
        lblScore10.setFont(ViewConstants.LABEL_LARGE);

        btnMenu = new Button("Menu");
    }

    private void layoutNodes() {
        btnMenu.setPrefWidth(ViewConstants.BUTTON_WIDTH);

        this.setHgap(ViewConstants.GRID_HGAP);
        this.setVgap(ViewConstants.GRID_VGAP);
        this.setPadding(ViewConstants.GRID_PADDING_LARGE);

        this.add(lblTypeScore,0,0,4,1);
        setHalignment(lblTypeScore, HPos.LEFT);


        this.add(lblPos1,0,2);
        this.add(lblSpeler1,1,2);
        this.add(lblDatum1,2,2);
        this.add(lblScore1,3,2);
        this.add(lblPos2,0,3);
        this.add(lblSpeler2,1,3);
        this.add(lblDatum2,2,3);
        this.add(lblScore2,3,3);
        this.add(lblPos3,0,4);
        this.add(lblSpeler3,1,4);
        this.add(lblDatum3,2,4);
        this.add(lblScore3,3,4);
        this.add(lblPos4,0,5);
        this.add(lblSpeler4,1,5);
        this.add(lblDatum4,2,5);
        this.add(lblScore4,3,5);
        this.add(lblPos5,0,6);
        this.add(lblSpeler5,1,6);
        this.add(lblDatum5,2,6);
        this.add(lblScore5,3,6);
        this.add(lblPos6,0,7);
        this.add(lblSpeler6,1,7);
        this.add(lblDatum6,2,7);
        this.add(lblScore6,3,7);
        this.add(lblPos7,0,8);
        this.add(lblSpeler7,1,8);
        this.add(lblDatum7,2,8);
        this.add(lblScore7,3,8);
        this.add(lblPos8,0,9);
        this.add(lblSpeler8,1,9);
        this.add(lblDatum8,2,9);
        this.add(lblScore8,3,9);
        this.add(lblPos9,0,10);
        this.add(lblSpeler9,1,10);
        this.add(lblDatum9,2,10);
        this.add(lblScore9,3,10);
        this.add(lblPos10,0,11);
        this.add(lblSpeler10,1,11);
        this.add(lblDatum10,2,11);
        this.add(lblScore10,3,11);

        this.add(btnMenu,1,12,2,1);
        this.setHalignment(btnMenu, HPos.CENTER);

        ColumnConstraints column0 = new ColumnConstraints(60);
        ColumnConstraints column1 = new ColumnConstraints(240);
        ColumnConstraints column2 = new ColumnConstraints(100);
        ColumnConstraints column3 = new ColumnConstraints(80);
        this.getColumnConstraints().addAll(column0,column1,column2,column3);
    }
}
