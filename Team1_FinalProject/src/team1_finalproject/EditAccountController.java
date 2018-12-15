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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

public class EditAccountController implements Initializable {

    //Variables
    @FXML
    private TextField tfEditAccountName;
    @FXML
    private TextField tfEditAccountID;
    @FXML
    private PasswordField tfEditAccountPassword;
    @FXML
    private TextArea taEditAccountNotes;
    @FXML
    private Text errorMsg;

    /**
     * Method: Initializer
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errorMsg.setVisible(false);
    }

    @FXML
    public void UpdateAccount(ActionEvent event) throws Exception {
        if (tfEditAccountName.getText().equals("")) {
            errorMsg.setText("Error: Account Name cannnot be empty");
            errorMsg.setVisible(true);
            return;
        }
        if (DBQueries.editAccount(tfEditAccountName.getText(), tfEditAccountID.getText(),
                tfEditAccountPassword.getText(), taEditAccountNotes.getText())) {
            //TODO: Inform success
            errorMsg.setVisible(false);
        } else {
            //TODO: Inform the user that the Edit account failed.
            errorMsg.setText("Error while editing account");
            errorMsg.setVisible(true);
        }
    }

    /**
     * Method: Opens password generator
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void PasswordGeneratorButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("PasswordGenerator.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        //set generated password string
        String pw = Clipboard.getSystemClipboard().getString();
        tfEditAccountPassword.setText(pw);
    }

    /**
     * Method: closes pop-up
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void Close(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }
}
