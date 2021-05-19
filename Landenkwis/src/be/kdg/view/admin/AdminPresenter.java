package be.kdg.view.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import be.kdg.model.*;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.scene.control.Alert;

import java.io.File;


/**
 * @author Lotte Vanhalst
 * @version 1.0 23/02/2019 23:48
 */
public class AdminPresenter {
    private AdminView view;
    private Admin model;
    private Werelddelen wdl;
    private Werelddeel wdlAdmin;
    private Land nieuwLand;
    private String continent;

    public AdminPresenter(Admin model, AdminView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
    }

    private void bepaalLanden(){
        try {
            continent = view.getCbWerelddeel().getValue().toString();
            wdlAdmin = new Werelddeel(model.bepaalWerelddeel(view.getCbWerelddeel().getValue().toString()));
            wdlAdmin.addLanden("/bestanden/" + continent + ".txt");
        }catch (Exception exc) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Het bestand kan niet geopend worden.");
            alert.showAndWait();
        }
    }

    private void addEventHandlers() {
        this.view.getBtnBrowseKaart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File selectedFile = view.getFcKaart().showOpenDialog(view.getScene().getWindow());
                String bestand = selectedFile.getPath();
                view.getTfKaart().setText(bestand);
            }
        });

        this.view.getBtnBrowseVlag().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File selectedFile = view.getFcKaart().showOpenDialog(view.getScene().getWindow());
                String bestand = selectedFile.getPath();
                view.getTfVlag().setText(bestand);
            }
        });

        this.view.getBtnVoegLandToe().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(view.getCbWerelddeel().getSelectionModel().isEmpty() || view.getTfNaam().getText().equals("") || view.getTfHoofdstad().getText().equals("")
                || view.getTfVlag().getText().equals("") || view.getTfKaart().getText().equals("")){
                    view.getLblError().setText("Gelieve alle velden in te vullen.");
                } else {
                    bepaalLanden();
                    nieuwLand = new Land(view.getTfNaam().getText().toUpperCase(), view.getCbWerelddeel().getValue().toString(), view.getTfHoofdstad().getText().toUpperCase(), view.getTfVlag().getText(), view.getTfKaart().getText());
                    try {
                        model.voegLandToe(wdlAdmin.getLanden(), nieuwLand, "/bestanden/" + continent + ".txt");
                        updateView();
                    } catch (RuntimeException exc){
                        view.getLblError().setText(exc.getMessage());
                    } catch (Exception exc) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Het bestand kan niet geopend worden.");
                        alert.showAndWait();
                    }
                }
            }
        });

        this.view.getBtnWijzigLand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Land nieuwLand = null;
                if(view.getCbWerelddeel().getSelectionModel().isEmpty() || view.getTfNaam().getText().equals("") || view.getTfHoofdstad().getText().equals("")
                        || view.getTfVlag().getText().equals("") || view.getTfKaart().getText().equals("")){
                    view.getLblError().setText("Gelieve alle velden in te vullen.");
                } else {
                    bepaalLanden();
                    Land oudLand = null;
                    try {
                        for (Land land : wdlAdmin.getLanden()) {
                            if (land.getNaam().equals(view.getTfNaam().getText().toUpperCase())) {
                                oudLand = land;
                            }
                        }
                        nieuwLand = new Land(view.getTfNaam().getText().toUpperCase(), view.getCbWerelddeel().getValue().toString(), view.getTfHoofdstad().getText().toUpperCase(), view.getTfVlag().getText(), view.getTfKaart().getText());
                        model.pasWerelddeelAan(wdlAdmin.getLanden(), nieuwLand, oudLand, "/bestanden/" + continent + ".txt");
                        updateView();
                    } catch (LandenAanpassenException exc){
                        view.getLblError().setText(exc.getMessage());
                    } catch (Exception exc) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Het bestand kan niet geopend worden.");
                        alert.showAndWait();
                    }
                }
            }
        });

        this.view.getBtnVerwijderLand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getCbWerelddeel().getSelectionModel().isEmpty() || view.getTfNaam().getText().equals("")) {
                    view.getLblError().setText("Gelieve de naam van het land in te vullen.");
                } else {
                    bepaalLanden();
                    Land oudLand = null;
                    try {

                        for (Land land : wdlAdmin.getLanden()) {
                            if (land.getNaam().equals(view.getTfNaam().getText().toUpperCase())) {
                                oudLand = land;
                            }
                        }
                        model.verwijderLand(wdlAdmin.getLanden(), view.getTfNaam().getText().toUpperCase(), "/bestanden/" + continent + ".txt");
                        updateView();
                    } catch (LandenAanpassenException exc){
                        view.getLblError().setText(exc.getMessage());
                    } catch (Exception exc) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Het bestand kan niet geopend worden.");
                        alert.showAndWait();
                    }
                }
            }
        });

        this.view.getBtnAnnuleer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getTfNaam().clear();
                view.getTfHoofdstad().clear();
                view.getTfKaart().clear();
                view.getTfVlag().clear();
            }
        });

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


    private void updateView() {
        view.getLblError().setText("De wijzigingen werden doorgevoerd.");
    }

}
