package team1_finalproject;

/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: Controller adds functionality for Sign in
 */
//Imports
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
import team1_finalproject.supporting_classes.*;

public class SignInController implements Initializable {

    //Variables
    @FXML
    private TextField tfUserEmail;
    @FXML
    private Text txtSignInErrorMsg;
    @FXML
    private PasswordField tfUserPassword;

    /**
     * Method: Initialize
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set error message to not visible
        txtSignInErrorMsg.setVisible(false);
    }

    /**
     * Method: Sign in event
     * @param event
     * @throws Exception 
     */
    public void CheckCredentials(ActionEvent event) throws Exception {

        if (tfUserEmail.getText().matches("^\\D+$") && tfUserPassword.getText().matches("^\\D+$")) {
            txtSignInErrorMsg.setText("");
            
            // Connect to the database
            DBInterface db = new DBInterface();
            
            // send tfUserEmail to DBInterface
            DBInterface.setName(tfUserEmail.getText());
            DBInterface.setPassword(tfUserPassword.getText());
            if (!db.connect()) {
                System.out.println("Database does not exist.");
                txtSignInErrorMsg.setText("Database does not exist.");
                txtSignInErrorMsg.setVisible(true); 
                DBInterface.disconnect();
                return;
            }

            // Verify password
            if (!DBQueries.checkPW(tfUserPassword.getText())) {
                System.out.println("Password incorrect");
                DBInterface.disconnect();
                txtSignInErrorMsg.setText("Password Fail.");
                txtSignInErrorMsg.setVisible(true); 
                DBInterface.disconnect();
                tfUserPassword.clear();
                return;
            }

            //Changes scene to Main Program
            Parent rootBP = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Scene sceneBP = new Scene(rootBP);

            Stage wMain = (Stage) ((Node) event.getSource()).getScene().getWindow();
            wMain.setScene(sceneBP);
            wMain.show();
        } else {
            //display error message
            if(txtSignInErrorMsg.getText().equals("")) {
                txtSignInErrorMsg.setText("Email or Password is incorrect.");
                txtSignInErrorMsg.setVisible(true);
            }
        }
    }

    /**
     * Method: Loads Create Account window
     * @param event
     * @throws Exception 
     */
    @FXML
    public void LoadNewAccountScene(ActionEvent event) throws Exception {
        //Changes scene to create account
        Parent rootBP = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        Stage wCreateAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        wCreateAccount.setScene(sceneBP);
        wCreateAccount.show();
    }
}
