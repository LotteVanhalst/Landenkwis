package be.kdg.view.login;

import be.kdg.model.Quiz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import be.kdg.model.Admin;
import be.kdg.model.Administrator;
import be.kdg.view.admin.AdminPresenter;
import be.kdg.view.admin.AdminView;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.scene.control.Alert;

import java.io.IOException;

/**
 * @author Lotte Vanhalst
 * @version 1.0 1/03/2019 10:08
 */
public class LoginPresenter {
    private LoginView view;
    private Admin model;

    public LoginPresenter(Admin model, LoginView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        this.view.getBtnLogin().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateView();
                try {
                    Admin lijst = new Admin();
                    lijst.getAdministrators().addAll(model.leesWachtwoorden("/bestanden/admin.txt"));
                    for (Administrator administrator : lijst.getAdministrators()) {
                        if (!((administrator.getNaam().equals(view.getTfGebruikersNaam().getText())) &&
                                (administrator.getWachtwoord().equals(view.getPfWachtwoord().getText())))) {
                            view.getLblError().setText("De combinatie van naam en wachtwoord is niet correct.");
                        } else {
                            AdminView adminView = new AdminView();
                            Admin adminModel = new Admin();
                            AdminPresenter adminPresenter = new AdminPresenter(adminModel, adminView);
                            view.getScene().setRoot(adminView);
                            adminView.getScene().getWindow().sizeToScene();
                        }
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Het bestand kan niet geopend worden.");
                    alert.showAndWait();
                }
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
        view.getLblError().setText("");
    }
}
