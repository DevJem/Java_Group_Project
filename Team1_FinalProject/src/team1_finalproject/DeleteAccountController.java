package team1_finalproject;

/** 
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Date: December 3, 2018
 */

//Imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class DeleteAccountController implements Initializable {

    //Variables
    @FXML
    private Button btnCancel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Cancel(ActionEvent event) throws Exception {
        Stage deleteAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        deleteAccount.close();
    }
}
