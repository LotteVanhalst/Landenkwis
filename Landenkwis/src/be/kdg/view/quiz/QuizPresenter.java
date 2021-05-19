package be.kdg.view.quiz;

import be.kdg.view.ViewConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import be.kdg.model.*;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import be.kdg.view.topscoreQuiz.TopscoreQuizPresenter;
import be.kdg.view.topscoreQuiz.TopscoreQuizView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.InputStream;

import static be.kdg.model.Type.HOOFDSTEDEN;
import static be.kdg.model.Type.LANDEN;
import static be.kdg.model.Type.VLAGGEN;
import static be.kdg.view.start.StartPresenter.*;


/**
 * @author Laura Van den Brande
 * @version 1.0 16/02/2019 11:19
 */
public class QuizPresenter {

    // Variabelen declareren

    private QuizView view;
    private Quiz model;
    private int teller;
    private StopwatchTransition trans;
    private Stopwatch tijd = new Stopwatch();
    private static int score;
    private Werelddeel wdlQuiz;
    private Type type;


    // Constructor

    public QuizPresenter(Quiz model, QuizView view) {
        this.model = model;
        this.view = view;
        this.setReady();
        this.addEventHandlers();
    }


    // Getters en Setters

    public static int getScore() {
        return score;
    }

    private void setReady(){
        score = 0;
        String continent = getGekozenWerelddeel().getWerelddeel();
        wdlQuiz = new Werelddeel(model.bepaalWerelddeel(model.getWerelddeel().toString()));
        view.getImgKaart().setImage(new Image("/afbeeldingen/kaarten/" + continent + ".png"));
        type = getGekozenType();
        trans = new StopwatchTransition(view);

        view.getLblLand().setVisible(false);
        view.getTfAntwoord().setVisible(false);
        view.getBtnVolgende().setVisible(false);
        view.getTfAntwoord().requestFocus();

        try {
            wdlQuiz.addLanden("/bestanden/" + continent +".txt");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Het bestand kan niet geopend worden.");
            alert.showAndWait();
        }
        wdlQuiz.schudLanden();
        for (Land land: wdlQuiz.getLanden()){
        }
    }


    // Methoden

    private void verhoogTeller() {
        this.teller++;
    }

    private void verhoogScore (int punten){
        score += punten;
    }

    private void addEventHandlers() {

        trans.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getLblJuistAntwoord().setText(model.toonOplossing(wdlQuiz, type, teller));
                view.getBtnVolgende().setDisable(false);
                view.getTfAntwoord().setStyle(ViewConstants.WRONG_ANSWER);
                view.getTfAntwoord().setEditable(false);
            }
        });

        this.view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getBtnStart().setVisible(false);
                view.getLblUitleg().setVisible(false);
                if (type.equals(HOOFDSTEDEN)){
                    view.getLblLand().setVisible(true);
                }
                view.getTfAntwoord().setVisible(true);
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
                } else if (type.equals(VLAGGEN)) {
                    view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getVlag()));
                    view.getImgKaart().setFitWidth(400);
                }
                tijd.start();
                trans.play();
                view.getScene().getWindow().sizeToScene();
            }
        });


        this.view.getTfAntwoord().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    view.getBtnVolgende().setDisable(false);
                    Land land = wdlQuiz.getLanden().get(teller);
                    tijd.stop();
                    trans.stop();
                    if ((type.equals(LANDEN) || (type.equals(VLAGGEN)))) {
                        if (view.getTfAntwoord().getText().toUpperCase().equals(land.getNaam())) {
                            view.getLblJuistAntwoord().setText("Correct!");
                            view.getTfAntwoord().setStyle(ViewConstants.CORRECT_ANSWER);
                            view.getTfAntwoord().setEditable(false);
                            int punten = (10 - (int) tijd.getElapsedTimeSecs());
                            verhoogScore(punten);
                            view.getLblScore().setText("Score: " + getScore());
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
                            int punten = (10 - (int) tijd.getElapsedTimeSecs());
                            verhoogScore(punten);
                            view.getLblScore().setText("Score: " + getScore());
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
                view.getTfAntwoord().setEditable(true);
                view.getTfAntwoord().setStyle(null);
                verhoogTeller();
                if (teller < 20) {
                    /*Land land = wdlQuiz.getLanden().get(teller);*/
                    tijd.start();
                    updateView();
                } else if (teller == 20){
                    try {
                        InputStream scores = getClass().getResourceAsStream("/bestanden/"+ type +".txt");
                        model.registreerHighscore(scores, getNaamSpeler(), getScore(), "/bestanden/" + type +".txt");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Het bestand kan niet geopend worden.");
                        alert.showAndWait();
                    }
                    TopscoreQuizView topscoreQuizView = new TopscoreQuizView();
                    Quiz quizModel = new Quiz();
                    TopscoreQuizPresenter topscoreQuizPresenter = new TopscoreQuizPresenter(quizModel, topscoreQuizView);
                    view.getScene().setRoot(topscoreQuizView);
                    topscoreQuizView.getScene().getWindow().sizeToScene();
                }
            };
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
        view.getTfAntwoord().requestFocus();
        view.getLblJuistAntwoord().setText(null);
        view.getIndicatorTijd().setProgress(0);
        trans.play();
        if ((type.equals(LANDEN) || (type.equals(HOOFDSTEDEN)))) {
            view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getKaart()));
            view.getLblLand().setText(wdlQuiz.getLanden().get(teller).getNaam());
        } else if (type.equals(VLAGGEN)){
            view.getImgKaart().setImage(new Image(wdlQuiz.getLanden().get(teller).getVlag()));
        }
        view.getScene().getWindow().sizeToScene();
    }

}
