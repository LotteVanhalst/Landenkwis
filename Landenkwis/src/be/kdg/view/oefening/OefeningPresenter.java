package be.kdg.view.oefening;

import be.kdg.view.ViewConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import be.kdg.model.*;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static be.kdg.model.Type.HOOFDSTEDEN;
import static be.kdg.model.Type.LANDEN;
import static be.kdg.model.Type.VLAGGEN;
import static be.kdg.view.start.StartPresenter.getGekozenType;
import static be.kdg.view.start.StartPresenter.getGekozenWerelddeel;

/**
 * @author Laura Van den Brande
 * @version 1.0 16/02/2019 10:24
 */
public class OefeningPresenter {

    // Variabelen declareren

    private OefeningView view;
    private Oefening model;
    private int teller;
    private int tellerTip;
    private Werelddeel wdlQuiz;
    private Type type;


    // Constructor

    public OefeningPresenter(Oefening model, OefeningView view) {
        this.model = model;
        this.view = view;
        this.setReady();
        this.addEventHandlers();
    }


    // Methoden

    private void setReady(){
        String continent = getGekozenWerelddeel().getWerelddeel();
        wdlQuiz = new Werelddeel(model.bepaalWerelddeel(model.getWerelddeel().toString()));
        view.getImgKaart().setImage(new Image("/afbeeldingen/kaarten/" + continent + ".png"));
        type = getGekozenType();
        view.getLblLand().setVisible(false);
        view.getTfAntwoord().setVisible(false);
        view.getBtnTip().setVisible(false);
        view.getBtnVolgende().setVisible(false);
        try {
            wdlQuiz.addLanden("/bestanden/" + continent +".txt");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Het bestand kan niet geopend worden.");
            alert.showAndWait();
        }
        wdlQuiz.schudLanden();
    }

    private void verhoogTeller() {
        this.teller++;
    }

    private void verhoogTellerTip() {
        this.tellerTip++;
    }

    private void addEventHandlers() {
        this.view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getBtnStart().setVisible(false);
                view.getLblUitleg().setVisible(false);
                if (type.equals(HOOFDSTEDEN)){
                    view.getLblLand().setVisible(true);
                }
                view.getTfAntwoord().setVisible(true);
                view.getBtnTip().setVisible(true);
                view.getBtnVolgende().setVisible(true);
                view.getBtnVolgende().setDisable(true);
                view.getTfAntwoord().requestFocus();
                if ((type.equals(LANDEN) || (type.equals(HOOFDSTEDEN)))) {
                    view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getKaart()));
                    view.getLblLand().setText(wdlQuiz.getLanden().get(teller).getNaam());
                    String werelddeel = getGekozenWerelddeel().getWerelddeel();
                    switch (werelddeel) {
                        case "AFRIKA":
                            view.getImgKaart().setFitWidth(500);
                        case "AMERIKA":
                            view.getImgKaart().setFitWidth(400);
                            break;
                        case "AZIE":
                        case "EUROPA":
                        case "OCEANIE":
                            view.getImgKaart().setFitWidth(600);
                            break;
                    }
                } else if (type.equals(VLAGGEN)){
                    view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getVlag()));
                    view.getImgKaart().setFitWidth(400);
                }
                view.getScene().getWindow().sizeToScene();
            }
        });

        this.view.getTfAntwoord().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    view.getBtnVolgende().setDisable(false);
                    Land land = wdlQuiz.getLanden().get(teller);
                    if ((type.equals(LANDEN) || (type.equals(VLAGGEN)))) {
                        if (view.getTfAntwoord().getText().toUpperCase().equals(land.getNaam())) {
                            view.getLblJuistAntwoord().setText("Correct");
                            view.getTfAntwoord().setStyle(ViewConstants.CORRECT_ANSWER);
                            view.getTfAntwoord().setEditable(false);
                        } else {
                            wdlQuiz.getLanden().add(land);
                            view.getLblJuistAntwoord().setText(model.toonOplossing(wdlQuiz, type, teller));
                            view.getTfAntwoord().setStyle(ViewConstants.WRONG_ANSWER);
                            view.getTfAntwoord().setEditable(false);
                        }
                    } else if ((type.equals(HOOFDSTEDEN))) {
                        if (view.getTfAntwoord().getText().toUpperCase().equals(land.getHoofdstad())) {
                            view.getLblJuistAntwoord().setText("Correct");
                            view.getTfAntwoord().setStyle(ViewConstants.CORRECT_ANSWER);
                            view.getTfAntwoord().setEditable(false);
                        } else {
                            wdlQuiz.getLanden().add(land);
                            view.getLblJuistAntwoord().setText(model.toonOplossing(wdlQuiz, type, teller));
                            view.getTfAntwoord().setStyle(ViewConstants.WRONG_ANSWER);
                            view.getTfAntwoord().setEditable(false);
                        }
                    }
                }
            }
        });


        this.view.getBtnVolgende().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getBtnVolgende().setDisable(true);
                view.getTfAntwoord().requestFocus();
                view.getTfAntwoord().setStyle(null);
                verhoogTeller();
                tellerTip = 0;
                if (teller < wdlQuiz.getLanden().size()) {
                    updateView();
                } else if (teller == wdlQuiz.getLanden().size()){
                    view.getLblJuistAntwoord().setText("De oefening is gedaan.");
                }
            };
        });

        this.view.getBtnTip().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verhoogTellerTip();
                String tipLand = null;
                if ((type.equals(LANDEN) || (type.equals(VLAGGEN)))) {
                    tipLand =  model.toonTipLand(wdlQuiz.getLanden().get(teller), tellerTip);
                } else if ((type.equals(HOOFDSTEDEN))){
                        tipLand =  model.toonTipHoofdstad(wdlQuiz.getLanden().get(teller).getHoofdstad(), tellerTip);
                }
                view.getLblTip().setText(tipLand);
            }
        });

        this.view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView startView = new StartView();
                Quiz startModel = new Quiz();
                StartPresenter startPresenter = new StartPresenter(startModel, startView);
                view.getScene().setRoot(startView);
                startView.getScene().getWindow().sizeToScene();
            }
        });

    }

    private void updateView() {
        type = getGekozenType();
        view.getTfAntwoord().clear();
        view.getTfAntwoord().setEditable(true);
        view.getLblTip().setText(null);
        view.getLblJuistAntwoord().setText(null);
        if ((type.equals(LANDEN) || (type.equals(HOOFDSTEDEN)))) {
            view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getKaart()));
            view.getLblLand().setText(wdlQuiz.getLanden().get(teller).getNaam());
        } else if (type.equals(VLAGGEN)){
            view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getVlag()));
        }
        view.getScene().getWindow().sizeToScene();
    }
}
