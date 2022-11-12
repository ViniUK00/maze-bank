package com.mazebank.mazebank.Controllers.Admin;

import com.mazebank.mazebank.Models.Model;
import com.mazebank.mazebank.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposint_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();
    }

    private void addListener() {
        create_client_btn.setOnAction(event -> onCreateClient());
        clients_btn.setOnAction(event -> onClients());
    }


    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }
}
