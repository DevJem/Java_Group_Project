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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

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
    private Text errorMsg;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg.setVisible(false);
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

        //set generated password string
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
        
        //Error: if Account Name is blank 
        if(tfAccountName.getText().equals("")){
            errorMsg.setText("Error: Account Name cannnot be empty");
            errorMsg.setVisible(true);
            return;
        }
        if (DBQueries.addAccount(tfAccountName.getText(), tfAccountUserID.getText(),
                tfAccountPassword.getText(), taAccountNotes.getText())) {
            errorMsg.setVisible(false);
            
        } else {
            errorMsg.setText("Error while adding account");
            errorMsg.setVisible(true);
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
