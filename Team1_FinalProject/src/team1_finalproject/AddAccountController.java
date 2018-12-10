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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Font;
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
    @FXML
    private Button btnPasswordGenerator;
    @FXML
    private Button btnAddAccount;
    
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
        DBQueries.addAccount(tfAccountName.getText(), tfAccountUserID.getText(),
                tfAccountPassword.getText(), taAccountNotes.getText());
    }

    /**
     * Method: Cancel button click exits pop-up
     */
    @FXML
    public void CancelButton(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }
}
