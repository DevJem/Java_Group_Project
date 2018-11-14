/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Jay
 */
public class CreateAccountController implements Initializable {

    @FXML
    private Label lblCreateAccount;
    @FXML
    private Button btnUserCreateAccount;
    @FXML
    private Font x1;
    @FXML
    private Button btnUserCancel;
    @FXML
    private TextField tfNewUserEmail;
    @FXML
    private PasswordField tfNewUserPassword;
    @FXML
    private PasswordField tfNewUserPassword2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Method: btnUserCreateAccount
     *         take input from email, password, and password2
     *         If passwords match & account doesnt exist, create account
     *         If false, issue text alert
     */
    
    
    /**
     * Method: btnUserCancel
     *         returns user to login screen
     */
    
}
