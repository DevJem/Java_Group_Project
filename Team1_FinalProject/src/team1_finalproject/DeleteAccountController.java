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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

public class DeleteAccountController implements Initializable {

    //Variables
    @FXML
    private TextField tfDeleteAccountName;
    @FXML
    private Text txtDeleteNotice;

    /**
     * Method: Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDeleteNotice.setVisible(false);
    }

    /**
     * Method: Deletes user account from db
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    public void deleteAccount(ActionEvent event) throws SQLException {
        String sName = tfDeleteAccountName.getText();

        if (tfDeleteAccountName.getText().equals("")) {
            txtDeleteNotice.setText("Error: text field cannot be empty");
            txtDeleteNotice.setVisible(true);
            return;
        }

        if (DBQueries.deleteAccount(sName)) {
            txtDeleteNotice.setText(sName + " Account deleted");
            txtDeleteNotice.setVisible(true);
        } else {
            //Inform the user that the delete account failed.
            txtDeleteNotice.setText(sName + " does not exist;");
            txtDeleteNotice.setVisible(true);
        }
        tfDeleteAccountName.clear();
    }

    /**
     * Method: Close delete account pop-up
     *
     * @param event
     * @throws Exception
     */
    public void Close(ActionEvent event) throws Exception {
        Stage deleteAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        deleteAccount.close();
    }

}
