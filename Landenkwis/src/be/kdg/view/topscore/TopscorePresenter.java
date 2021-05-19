package be.kdg.view.topscore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import be.kdg.model.Highscore;
import be.kdg.model.Quiz;
import be.kdg.model.Type;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.scene.control.Alert;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static be.kdg.view.start.StartPresenter.getGekozenTopscore;

/**
 * @author Lotte Vanhalst
 * @version 1.0 23/02/2019 23:54
 */
public class TopscorePresenter {
    private Quiz model;
    private TopscoreView view;
    private List<Highscore> topscores;
    private Type type;

    public TopscorePresenter(Quiz model, TopscoreView view) {
        this.model = model;
        this.view = view;
        topscores = new ArrayList<>();
        this.addEventHandlers();
        this.updateView();
    }

    private void leesBestand(){
        String bestand = null;
        type = getGekozenTopscore();
        switch (type){
            case LANDEN: bestand = "/bestanden/LANDEN.txt"; break;
            case HOOFDSTEDEN: bestand = "/bestanden/HOOFDSTEDEN.txt"; break;
            case VLAGGEN: bestand = "/bestanden/VLAGGEN.txt"; break;
        }
        InputStream score = getClass().getResourceAsStream(bestand);
        try {
            topscores.addAll(model.leesHighscores(score));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Het bestand kan niet geopend worden.");
            alert.showAndWait();
        }
    }

    private void addEventHandlers() {
        this.view.getBtnMenu().setOnAction(new EventHandler<ActionEvent>() {
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

    private void updateView(){
        this.leesBestand();
        view.getLblTypeScore().setText("Topscores voor: " + type);
        view.getLblSpeler1().setText(topscores.get(0).getNaamSpeler());
        view.getLblSpeler2().setText(topscores.get(1).getNaamSpeler());
        view.getLblSpeler3().setText(topscores.get(2).getNaamSpeler());
        view.getLblSpeler4().setText(topscores.get(3).getNaamSpeler());
        view.getLblSpeler5().setText(topscores.get(4).getNaamSpeler());
        view.getLblSpeler6().setText(topscores.get(5).getNaamSpeler());
        view.getLblSpeler7().setText(topscores.get(6).getNaamSpeler());
        view.getLblSpeler8().setText(topscores.get(7).getNaamSpeler());
        view.getLblSpeler9().setText(topscores.get(8).getNaamSpeler());
        view.getLblSpeler10().setText(topscores.get(9).getNaamSpeler());
        view.getLblDatum1().setText(topscores.get(0).getDatum().toString());
        view.getLblDatum2().setText(topscores.get(1).getDatum().toString());
        view.getLblDatum3().setText(topscores.get(2).getDatum().toString());
        view.getLblDatum4().setText(topscores.get(3).getDatum().toString());
        view.getLblDatum5().setText(topscores.get(4).getDatum().toString());
        view.getLblDatum6().setText(topscores.get(5).getDatum().toString());
        view.getLblDatum7().setText(topscores.get(6).getDatum().toString());
        view.getLblDatum8().setText(topscores.get(7).getDatum().toString());
        view.getLblDatum9().setText(topscores.get(8).getDatum().toString());
        view.getLblDatum10().setText(topscores.get(9).getDatum().toString());
        view.getLblScore1().setText(String.valueOf(topscores.get(0).getScore()));
        view.getLblScore2().setText(String.valueOf(topscores.get(1).getScore()));
        view.getLblScore3().setText(String.valueOf(topscores.get(2).getScore()));
        view.getLblScore4().setText(String.valueOf(topscores.get(3).getScore()));
        view.getLblScore5().setText(String.valueOf(topscores.get(4).getScore()));
        view.getLblScore6().setText(String.valueOf(topscores.get(5).getScore()));
        view.getLblScore7().setText(String.valueOf(topscores.get(6).getScore()));
        view.getLblScore8().setText(String.valueOf(topscores.get(7).getScore()));
        view.getLblScore9().setText(String.valueOf(topscores.get(8).getScore()));
        view.getLblScore10().setText(String.valueOf(topscores.get(9).getScore()));
    }
}
