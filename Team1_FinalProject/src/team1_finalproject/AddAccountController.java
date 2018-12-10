package team1_finalproject;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author: Jenney Chang
 * @Assignment Name: Team1_FinalProject
 * @Date: Dec 2, 2018
 * @Subclass AddAccount Controller Description: Adds functionality for elements
 */

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

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
    private TextArea taAccountNotes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void PasswordGeneratorButton() {

    }
    //Add Account: calls method to send data to database
    @FXML
    public void AddAccountButton(ActionEvent event) throws SQLException {
        if (DBQueries.addAccount(tfAccountName.getText(), tfAccountUserID.getText(),
                tfAccountPassword.getText(),taAccountNotes.getText())){
            System.out.println("Added account");
        } else {
            System.out.println("Failed on add account");
        }
    }

    //Cancel Button closes pop up
    public void CancelButton(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }
}
