package team1_finalproject;

/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: Settings Controller adds functionality for settings 
 */
//Imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

public class SettingsController implements Initializable {

    //Variables
    String choice;
    @FXML
    private TextField tfUserStatus;
    @FXML
    private ChoiceBox<String> choicebNotifyEmail = new ChoiceBox<>();

    /**
     * Method: Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Add items to Choice box
        choicebNotifyEmail.getItems().clear();
        choicebNotifyEmail.getItems().addAll("Yes", "No");
        
        String sAdmin = DBQueries.bIsAdmin() ? "Administrator" : "Local User";
        tfUserStatus.setText(sAdmin);
    }

    //TODO: Save Setting config to database
    @FXML
    public void saveButton(ActionEvent event) throws Exception {
        
    }
    
    @FXML
    public void getChoice(ChoiceBox<String> cb) {
        choice = choicebNotifyEmail.getValue();
        
        //TODO: ?? can choose to return the bool return value
//        if(choice.equals("Yes")){
//            return true;
//        } else {
//            return false;
//        }
    }

    /**
     * Method: Closes Settings window
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void cancel(ActionEvent event) throws Exception {
        Stage settings = (Stage) ((Node) event.getSource()).getScene().getWindow();
        settings.close();
    }
}
