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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SettingsController implements Initializable {

    @FXML
    private Label lblSettings;
    @FXML
    private Button btnSaveSettings;
    @FXML
    private Font x1;
    @FXML
    private Button btnCancelSettings;
    @FXML
    private Label lblUserStatus;
    @FXML
    private TextField tfUserStatus;
    @FXML
    private Insets x4;
    @FXML
    private Insets x2;
    @FXML
    private Label lblUserPrivileges;
    @FXML
    private Font x3;
    @FXML
    private ChoiceBox<?> choicebUserPrivileges;
    @FXML
    private Label lblNotifyByEmail;
    @FXML
    private Insets x5;
    @FXML
    private ChoiceBox<?> choicebNotifyEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Handle Button Click: Exists out of Settings popup
    @FXML
    public void cancel(ActionEvent event ) throws Exception {
        Stage settings = (Stage) ((Node) event.getSource()).getScene().getWindow();
        settings.close();
    }
}
