package com.mazebank.mazebank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Label savings_acc_num;
    public Label savings_bal;
    public Label income_lbl;
    public Label expenses_lbl;

    public ListView transcations_listview;
    public TextField payee_fld;
    public TextField amount_fld;
    public TextArea message_fld;
    public Button sent_money_btn;
    public Label cheching_bal;
    public Label checking_acc_num;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
