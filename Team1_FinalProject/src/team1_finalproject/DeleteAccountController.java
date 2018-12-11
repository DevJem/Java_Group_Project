package team1_finalproject;

/** 
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Date: December 3, 2018
 */

//Imports
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;


public class DeleteAccountController implements Initializable {

    //Variables
    @FXML
    private Button btnCancel;
    @FXML
    private TextField tfDeleteAccountName;
    @FXML
    private Text txtDeleteNotice;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtDeleteNotice.setVisible(false);
    }
    
     //delete Account: calls method to send data to database
    @FXML
    public void deleteAccount(ActionEvent event) throws SQLException {
        String sName = tfDeleteAccountName.getText();
        if (DBQueries.deleteAccount(sName)) {
            txtDeleteNotice.setText(sName + " Account deleted");
            txtDeleteNotice.setVisible(true);
        } else {
            //Inform the user that the delete account failed.
            txtDeleteNotice.setText(sName + " does not exist;");
            txtDeleteNotice.setVisible(true);
        }
        //TODO: This acknowledges deletions if zero rows are affected. Which means
        //  that the user isn't calling the right account name
    }

    public void Cancel(ActionEvent event) throws Exception {
        //TODO this doesn't close the window
        Stage deleteAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        deleteAccount.close();
    }
    
}
