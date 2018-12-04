/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBUtil;

/**
 * FXML Controller class
 *
 * @author jay
 */
public class AddAccountController implements Initializable {

    //Variables 
    @FXML
    private TextField tfAccountName;
    @FXML
    private TextField tfAccountUserID;
    @FXML
    private PasswordField tfAccountPassword;
    @FXML
    private ChoiceBox<?> AccountType;
    @FXML
    private TextArea taAccountNotes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize Choice Box
    }

    public void PasswordGeneratorButton() {

    }

    public void AddAccountButton(ActionEvent even) throws SQLException {
        addAccountQuery(tfAccountName.getText(), tfAccountUserID.getText(), 
                tfAccountPassword.getText(), taAccountNotes.getText());
    }

    //Helper method for Add Account Button
    //need to resolve password field and time stamp parameters
    private static void addAccountQuery(String account, String userID, String password, String notes)
            throws SQLException {
        String sqlStatement = "INSERT INTO account(account_name, username, password, time_created, "
                + "time_modified, notes, account_type) values('" + account + "', '" + userID + "',"
                + "'" + password + "', '" + notes + "')";
        try {
            DBUtil.dbExecuteQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println("Error occured while inserting data: " + e);
        }
    }

    //Cancel Button closes pop up
    public void CancelButton(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }
}
