package team1_finalproject;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author: Jenney Chang
 * @Assignment Name: Team1_FinalProject
 * @Date: Dec 2, 2018
 * @Subclass AddAccount Controller Description: Adds functionality for elements
 */
//Imports
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.stage.Modality;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

public class AddAccountController implements Initializable {

    //Variables
    //PasswordGeneratorController pgc = new PasswordGeneratorController();
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
    
    
    /**
     * Method: Opens password generator
     *
     * @param event
     * @throws Exception
     */
    public void PasswordGeneratorButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("PasswordGenerator.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        //set tfAccountPassword to generated password string
        String pw = Clipboard.getSystemClipboard().getString();
        tfAccountPassword.setText(pw);
        
    }

    /**
     * Method: Adds Account to db
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    public void AddAccountButton(ActionEvent event) throws SQLException {
        
        if (DBQueries.addAccount(tfAccountName.getText(), tfAccountUserID.getText(),
                tfAccountPassword.getText(), taAccountNotes.getText())) {
            //TODO: print success
            
        } else {
            //TODO: Inform the user that the add account failed.
        }
    }

    /**
     * Method: Closes Add Account pop-up
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void CloseButton(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }
}
