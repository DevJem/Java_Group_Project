/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateAccountController implements Initializable {

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
 
    //create account
    public void CreateAccount() {
        //
    }
    
    //cancel button
    public void CancelAccountCreation(ActionEvent event) throws Exception{
        Parent rootBP = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene sceneBP = new Scene(rootBP);
        
        Stage wSignIn = (Stage)((Node)event.getSource()).getScene().getWindow();
        wSignIn.setScene(sceneBP);
        wSignIn.show();
    }
    
}
