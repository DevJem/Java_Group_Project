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

    /**
     * Method: Initializer
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void UpdateAccount(ActionEvent event) throws Exception {
        if (DBQueries.editAccount(tfEditAccountName.getText(), tfEditAccountID.getText(),
                tfEditAccountPassword.getText(), taEditAccountNotes.getText())) {
            //TODO: Inform success
        } else {
            //TODO: Inform the user that the Edit account failed.
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
