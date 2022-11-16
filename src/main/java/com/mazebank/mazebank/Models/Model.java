package com.mazebank.mazebank.Models;

import com.mazebank.mazebank.Views.AccountType;
import com.mazebank.mazebank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;


    // Admin Data Section
    private boolean adminLoginSuccesFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","", null,null,null);
        // Admin Data section
        this.adminLoginSuccesFlag = false;
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}

    /*
    * Client Method Section
    * */
    public boolean getClientLoginSuccessFlag() {return this.clientLoginSuccessFlag;}
    public void setClientLoginSuccessFlag(boolean flag) {this.clientLoginSuccessFlag = false;}

    public Client getClient() {
        return client;
    }

    public void evaluateClientCred(String pAddress, String password) {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    * Admin Method Section
    */

    public boolean getAdminLoginSuccesFlag() {return this.adminLoginSuccesFlag;}

    public void setAdminLoginSuccesFlag(boolean adminLoginSuccesFlag) {
        this.adminLoginSuccesFlag = adminLoginSuccesFlag;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = getDatabaseDriver().getAdminData(username, password);
        try {
            if(resultSet.isBeforeFirst()) {
                this.adminLoginSuccesFlag = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

