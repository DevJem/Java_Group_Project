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
        choicebNotifyEmail.setValue("Yes");
        
        String sAdmin = DBQueries.bIsAdmin() ? "Administrator" : "Local User";
        tfUserStatus.setText(sAdmin);
    }

    //TODO: Save Setting config to database
    @FXML
    public void saveButton(ActionEvent event) throws Exception {
        DBQueries.setRecieveEmails(getChoice(choicebNotifyEmail));
    }
    
    @FXML
    public String getChoice(ChoiceBox<String> cb) {
        return choicebNotifyEmail.getValue();
//        System.out.println(choice);
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
