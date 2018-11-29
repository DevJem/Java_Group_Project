/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SignInController implements Initializable {

    //Variables
    @FXML
    private TextField tfUserEmail;
    @FXML
    private Text txtSignInErrorMsg;
    @FXML
    private PasswordField tfUserPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtSignInErrorMsg.setVisible(false);
    }    
    
    //user sign in--check for user credentials in database & access main window OR display error
    public void CheckCredentials(ActionEvent event) throws Exception {
        if (tfUserEmail.getText().matches("^\\D+$") && tfUserPassword.getText().matches("^\\D+$")) {
            
            // send tfUserEmail to DBinterface
            team1_finalproject.supporting_classes.DBinterface.setName(tfUserEmail.getText());
            team1_finalproject.supporting_classes.DBinterface.setPassword(tfUserPassword.getText());
            
            //Changes scene to Main Program
            Parent rootBP = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Scene sceneBP = new Scene(rootBP);
            
            Stage wMain = (Stage)((Node)event.getSource()).getScene().getWindow();
            wMain.setScene(sceneBP);
            wMain.show();
        } else {
            //display error message
            txtSignInErrorMsg.setVisible(true);
        }
    }


    @FXML
    public void LoadNewAccountScene(ActionEvent event) throws Exception{
        //Changes scene to create account
        Parent rootBP = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);
        
        Stage wCreateAccount = (Stage)((Node)event.getSource()).getScene().getWindow();
        wCreateAccount.setScene(sceneBP);
        wCreateAccount.show();
    }
}
