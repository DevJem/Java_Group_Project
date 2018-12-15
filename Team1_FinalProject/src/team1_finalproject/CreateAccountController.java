package team1_finalproject;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author: Jenney Chang & Jeremy Dehay
 * @Assignment Name: Team1_FinalProject
 * @Date: Dec 2, 2018
 * @Subclass CreateAccount Controller Description: Adds functionality for
 * elements
 */
//Imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.*;

public class CreateAccountController implements Initializable {

    //Variables
    @FXML
    private TextField tfNewUserEmail;
    @FXML
    private PasswordField tfNewUserPassword;
    @FXML
    private PasswordField tfNewUserPassword2;
    @FXML
    private Text txtErrorMsg;

    /**
     * Method: Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initailize Error Message to Invisible
        txtErrorMsg.setVisible(false);
    }

    /**
     * Method: Creates account & validates input
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void CreateAccount(ActionEvent event) throws Exception {
        // Connect to the database
        DBInterface db = new DBInterface();

        //#1 Check if text fields are empty
        if (tfNewUserEmail.getText().equals("") || tfNewUserPassword.getText().equals("")
                || tfNewUserPassword2.getText().equals("")) {
            errorMessage("Invalid text entry: one or more fields are empty");
            return;
        }

        //#2 Check if email is valid & password length
        if (Validation.validEmail(tfNewUserEmail)
                && Validation.validPasswords(tfNewUserPassword, tfNewUserPassword2, txtErrorMsg)) {
            // send tfUserEmail to DBInterface
            DBInterface.setName(tfNewUserEmail.getText());
            DBInterface.setPassword(tfNewUserPassword.getText());
            if (!db.createDB()) {
                errorMessage("Email address unavailable.");
                return;
            }

            // Change scene after successful account creation
            Parent rootBP = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            Scene sceneBP = new Scene(rootBP);

            Stage wSignIn = (Stage) ((Node) event.getSource()).getScene().getWindow();
            wSignIn.setScene(sceneBP);
            wSignIn.show();
        } else {
            errorMessage("Invalid Email: Please try again.");
        }
    }

    /**
     * Method: Error Message
     *
     * @param error
     */
    @FXML
    private void errorMessage(String error) {
        txtErrorMsg.setText(error);
        txtErrorMsg.setVisible(true);
    }

    /**
     * Method: Exit Create Account window
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void CancelAccountCreation(ActionEvent event) throws Exception {
        Parent rootBP = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene sceneBP = new Scene(rootBP);

        Stage wSignIn = (Stage) ((Node) event.getSource()).getScene().getWindow();
        wSignIn.setScene(sceneBP);
        wSignIn.show();
    }
}
