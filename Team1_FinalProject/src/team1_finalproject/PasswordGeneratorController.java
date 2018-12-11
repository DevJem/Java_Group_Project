package team1_finalproject;

/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: PasswordGenerator Controller adds functionality for Main Window Program
 */
//Imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.PWGenerator;

public class PasswordGeneratorController implements Initializable {

    //Variables
 
    @FXML
    private TextField tfPasswordLength;
    @FXML
    private CheckBox cbUpperCase;
    @FXML
    private CheckBox cbLowerCase;
    @FXML
    private CheckBox cbSpecialCharas;
    @FXML
    private CheckBox cbNumbers;
    @FXML
    private CheckBox cbSelectAll;
    @FXML
    private ListView<String> listView;

    /**
     * Method: Initializer
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //select all true by default
        cbSelectAll.setSelected(true);
    }

    /**
     * Method: Close pop-up
     * @param event
     * @throws Exception 
     */
    @FXML
    public void Close(ActionEvent event) throws Exception {
        Stage passwordGen = (Stage) ((Node) event.getSource()).getScene().getWindow();
        passwordGen.close();
    }

    /**
     * Method: Handle Check box selection
     * @return 
     */
    public boolean CheckBox() {
        boolean checkboxesGood = false;
        if (cbSelectAll.isSelected()) {
            cbUpperCase.setSelected(true);
            cbLowerCase.setSelected(true);
            cbSpecialCharas.setSelected(true);
            cbNumbers.setSelected(true);
            checkboxesGood = true;
        }
        // TODO: handle the rest of the checkboxes
        return checkboxesGood;
    }
    
    /**
     * Method: generates password
     * @return 
     */
    @FXML
    public String generatePW() {
        //taGeneratedPassword.clear();
        //TODO: validate integers for password length textfield
        if (!CheckBox()) {
            System.out.println("Invalid checkbox selection");
            //TODO: Alert users to pick correct checkboxes.
            return "";
        }
        
        final int PW_RUNS = 10;  // Number of passwords generated
        String sGeneratedPasswords[] = new String[PW_RUNS];
        int iLength = Integer.valueOf(tfPasswordLength.getText());
        boolean bUpcase = cbUpperCase.isSelected();
        boolean bLowcase = cbLowerCase.isSelected();
        boolean bSpecial = cbSpecialCharas.isSelected();
        boolean bNums = cbNumbers.isSelected();
        
        PWGenerator pwGenerate = new PWGenerator(iLength, bUpcase, bLowcase, bSpecial, bNums);
        
        for (int i = 0; i < PW_RUNS; i++) {
            sGeneratedPasswords[i] = pwGenerate.generate();
            listView.getItems().add(sGeneratedPasswords[i]);
            //taGeneratedPassword.appendText(sGeneratedPasswords[i] + "\n");
        }
        
        return sGeneratedPasswords[0];  //Return first password as string
    }
    
    //TODO interface pwgen here
    
    /**
     * Method: Save selected password from list view 
     */
    @FXML
    public void savePassword() {
        ObservableList<String> passwordList;
        passwordList = listView.getSelectionModel().getSelectedItems();
        
        for(String pl: passwordList) {
            
        }
    }
    
}
