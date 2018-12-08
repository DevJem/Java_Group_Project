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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.*;

public class CreateAccountController implements Initializable {

    @FXML
    private TextField tfNewUserEmail;
    @FXML
    private PasswordField tfNewUserPassword;
    @FXML
    private PasswordField tfNewUserPassword2;
    @FXML
    private Text txtErrorMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initailize Error Message to Invisible
        txtErrorMsg.setVisible(false);
    }

    //create account
    @FXML
    public void CreateAccount(ActionEvent event) throws Exception {

        //Check if text fields are empty
        if (tfNewUserEmail.getText().equals("") || tfNewUserPassword.getText().equals("")
                || tfNewUserPassword2.getText().equals("")) {
            errorMessage("Invalid text entry: one or more fields are empty");
        }
        //Check if passwords match
        if (!tfNewUserPassword.getText().equals(tfNewUserPassword2.getText())) {
            System.out.println("Passwords don't match");
            //Display Error message
           errorMessage("Invalid Password: passwords don't match.");
        }

        if (tfNewUserEmail.getText().matches("^\\D+$") && tfNewUserPassword.getText().matches("^\\D+$")) {

            // Connect to the database
            DBInterface db = new DBInterface();

            // send tfUserEmail to DBInterface
            DBInterface.setName(tfNewUserEmail.getText());
            DBInterface.setPassword(tfNewUserPassword.getText());
            db.createDB();
            
            // Change scene after successful account creation
            Parent rootBP = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            Scene sceneBP = new Scene(rootBP);

            Stage wSignIn = (Stage) ((Node) event.getSource()).getScene().getWindow();
            wSignIn.setScene(sceneBP);
            wSignIn.show();
        }

    }
    
    //Validation method: notifies user of related error
    @FXML
    public void errorMessage(String error) {
        txtErrorMsg.setText(error);
        txtErrorMsg.setVisible(true);
    }
    
    //cancel button
    @FXML
    public void CancelAccountCreation(ActionEvent event) throws Exception {
        Parent rootBP = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene sceneBP = new Scene(rootBP);

        Stage wSignIn = (Stage) ((Node) event.getSource()).getScene().getWindow();
        wSignIn.setScene(sceneBP);
        wSignIn.show();
    }
}
