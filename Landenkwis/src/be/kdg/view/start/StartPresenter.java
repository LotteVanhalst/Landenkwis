package be.kdg.view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import be.kdg.view.login.LoginPresenter;
import be.kdg.view.login.LoginView;
import be.kdg.view.oefening.OefeningPresenter;
import be.kdg.view.oefening.OefeningView;
import be.kdg.view.quiz.QuizPresenter;
import be.kdg.view.quiz.QuizView;
import be.kdg.model.*;
import be.kdg.view.spelregels.SpelregelsPresenter;
import be.kdg.view.spelregels.SpelregelsView;
import be.kdg.view.topscore.TopscorePresenter;
import be.kdg.view.topscore.TopscoreView;
import be.kdg.model.*;


/**
 * Deze klasse is de eerste waarop je komt als je het spel start. Hier kies je wat je wil doen: quizen, oefenen, de spelregels lezen, de topscores bekijken
 * of als admin de landen aanpassen (toevoegen, aanpassen of verwijderen).
 * Als je wil quizen of oefenen is het ook hier dat je het continent kiest evenals welk type spel je wil spelen (landen, hoofdsteden of vlaggen).
 * De volgende variabelen worden aangemaakt en kunnen in elke presenter aangeroepen worden: het gekozen continent (dit is een enum), het gekozen spel,
 * welk type van spel (dit is een enum), de naam van de speler en welke topscores de persoon wil bekijken.
 * In deze view worden de variabalen opgeslagen en wordt er doorgegaan naar een volgende view. Er wordt van het model gebruik gemaakt om het continent
 * en het type spel te bepalen. Er wordt gelinkt met de klasse Quiz omdat de klasse Spel abstract is en hier dus geen object van aagemaakt kan worden.
 *
 * @author Laura Van den Brande en Lotte Vanhalst
 * @version 1.0 15/02/2019 21:34
 */
public class StartPresenter {

    private StartView view;
    private Quiz model;

    private static Werelddeel gekozenWerelddeel;
    private static String gekozenSpel;
    private static boolean gekozenQuiz;
    private static boolean gekozenOefening;
    private static Type gekozenType;
    private static Type gekozenTopscore;
    private static String naamSpeler;

    /**
     * Dit is de constructor van de klasse. De view en het model worden aangemaakt, de waardes worden uitgewist zodat gegevens van een vorig
     * spel niet overgenomen worden enen de eventhandlers worden geïnitieerd.
     *
     * @param view
     */
    public StartPresenter(Quiz model, StartView view) {
        this.model = model;
        this.view = view;
        this.clearValues();
        this.addEventHandlers();
    }


    /**
     * De volgende methodes maken de getters aan van de variabelen zodat deze aangesproken kunnen worden door de andere presenters van het spel.
     * Zo kunnen de gekozen variabelen doorgegeven worden.
     *
     * @return de variabelen
     */
    public static Werelddeel getGekozenWerelddeel() { return gekozenWerelddeel; }
    public static String getGekozenSpel() { return gekozenSpel; }
    public static boolean isGekozenQuiz() { return gekozenQuiz; }
    public static boolean isGekozenOefening() { return gekozenOefening; }
    public static String getNaamSpeler() {
        return naamSpeler;
    }
    public static Type getGekozenType() {
        return gekozenType;
    }
    public static Type getGekozenTopscore() {
        return gekozenTopscore;
    }


    /**
     * De volgende methode zorgt ervoor dat de waardes van de comboboxen Werelddeel en Type Spel terug uitgewist worden en de naam van de speler
     * terug op "Naam" staat. Dit zorgt ervoor dat, als er één van deze zaken niet ingevuld zijn door de speler, de error getoond wordt en het
     * spel niet verder gaat met de waardes van een vorige selectie.
     */

    public void clearValues() {
        gekozenWerelddeel = null;
        naamSpeler = view.getTfNaam().getText();
        gekozenType = null;
    }


    /**
     * De volgende methode behandelt de acties die moeten gebeuren wanneer er op Start, Kies Topscore, Admin of Help gedrukt wordt.
     */
    private void addEventHandlers() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getCbKiesContinent().getSelectionModel().isEmpty() || view.getCbKiesType().getSelectionModel().isEmpty() ||
                view.getTfNaam().getText().equals("Naam") || view.getTfNaam().getText().equals("") || view.getTfNaam().getText().equals(" ")){
                    event.consume();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Gelieve alle velden in te vullen of te selecteren.");
                    alert.showAndWait();
                } else {
                    gekozenWerelddeel = new Werelddeel(model.bepaalWerelddeel(view.getCbKiesContinent().getValue().toString()));
                    gekozenSpel = view.getCbKiesType().getValue().toString();
                    gekozenQuiz = view.rbKiesQuiz.isSelected();
                    gekozenOefening = view.rbKiesOefenen.isSelected();
                    gekozenType = model.bepaalType(view.getCbKiesType().getValue().toString());
                    naamSpeler = view.getTfNaam().getText();
                }

                    if (gekozenQuiz) {
                        QuizView quizView = new QuizView();
                        Quiz quizModel = new Quiz(gekozenWerelddeel, gekozenType, view.getTfNaam().getText());
                        QuizPresenter quizPresenter = new QuizPresenter(quizModel, quizView);
                        view.getScene().setRoot(quizView);
                        quizView.getScene().getWindow().sizeToScene();
                    } else if (gekozenOefening) {
                        OefeningView oefeningView = new OefeningView();
                        Oefening oefeningModel = new Oefening(gekozenWerelddeel, gekozenType);
                        OefeningPresenter quizPresenter = new OefeningPresenter(oefeningModel, oefeningView);
                        view.getScene().setRoot(oefeningView);
                        oefeningView.getScene().getWindow().sizeToScene();
                    }
                }
        });

        this.view.getCbKiesTopscore().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gekozenTopscore = model.bepaalType(view.getCbKiesTopscore().getValue().toString());
                TopscoreView topscoreView = new TopscoreView();
                Quiz quizModel = new Quiz();
                TopscorePresenter topscorePresenter = new TopscorePresenter(quizModel, topscoreView);
                view.getScene().setRoot(topscoreView);
                topscoreView.getScene().getWindow().sizeToScene();

            }
        });

        this.view.getBtnAdmin().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView loginView = new LoginView();
                Admin adminModel = new Admin();
                LoginPresenter loginPresenter = new LoginPresenter(adminModel, loginView);
                view.getScene().setRoot(loginView);
                loginView.getScene().getWindow().sizeToScene();
            }
        });


        this.view.getBtnHelp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelregelsView spelregelsView = new SpelregelsView();
                Spelregels spelregelsModel = new Spelregels();
                SpelregelsPresenter spelregelsPresenter = new SpelregelsPresenter(spelregelsModel, spelregelsView);
                Stage spelregelsStage = new Stage();
                spelregelsStage.initOwner(view.getScene().getWindow());
                spelregelsStage.initModality(Modality.APPLICATION_MODAL);
                spelregelsStage.setScene(new Scene(spelregelsView));
                spelregelsStage.setX(view.getScene().getWindow().getX() + 100);
                spelregelsStage.setY(view.getScene().getWindow().getY() + 100);
                spelregelsStage.showAndWait();
            }
        });
    }

    /**
     * Deze methode zorgt ervoor dat er een alert getoond wordt als de gebruiker het venster probeert te sluiten. De gebruiker moet dan aangeven
     * of hij zeker is dat hij het spel wil stoppen.
     */
    public void addWindowEventHandlers(){
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Hierdoor stopt het spel!");
                    alert.setContentText("Ben je zeker dat je wilt aflsuiten?");
                    alert.setTitle("Opgelet!");
                    alert.getButtonTypes().clear();
                    ButtonType neen = new ButtonType("Neen");
                    ButtonType ja = new ButtonType("Ja");
                    alert.getButtonTypes().addAll(neen, ja);
                    alert.showAndWait();
                    if (alert.getResult() == null || alert.getResult().equals(neen)) {
                        event.consume();
                    }
            }
        });
    }

}
