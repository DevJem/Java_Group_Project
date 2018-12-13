package team1_finalproject;

/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: PasswordGenerator Controller adds functionality for Main Window Program
 */
//Imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
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
    private ListView<String> listView = new ListView<>();;
    ObservableList<String> passwordList;
    private String selectedPassword;

    /**
     * Method: Initializer
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbSelectAll.setSelected(true);
    }

    /**
     * Method: Close pop-up
     *
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
     *
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
     *
     * @return
     */
    @FXML
    public void generatePW() {
        //list view properties 
//        listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //TODO: validate integers for password length textfield
        if (!CheckBox()) {
            System.out.println("Invalid checkbox selection");
            //TODO: Alert users to pick correct checkboxes.
            return;
        }

        final int PW_RUNS = 10;  // Number of passwords generated
        ArrayList<String> alGeneratedPasswords = new ArrayList<>();
        int iLength = Integer.valueOf(tfPasswordLength.getText());
        boolean bUpcase = cbUpperCase.isSelected();
        boolean bLowcase = cbLowerCase.isSelected();
        boolean bSpecial = cbSpecialCharas.isSelected();
        boolean bNums = cbNumbers.isSelected();

        PWGenerator pwGenerate = new PWGenerator(iLength, bUpcase, bLowcase, bSpecial, bNums);

        for (int i = 0; i < PW_RUNS; i++) {
            alGeneratedPasswords.add(pwGenerate.generate());
//            passwordList.add(sGeneratedPasswords[i]);
        }
        passwordList = FXCollections.observableArrayList(alGeneratedPasswords);
        listView.setItems(passwordList);
    }

    //TODO interface pwgen here
    /**
     * Method: Saves selected password
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void savePassword(ActionEvent event) throws Exception {
        passwordList = listView.getSelectionModel().getSelectedItems();

        //iterate to find chosen password
        for (String pl : passwordList) {
            selectedPassword = pl;
        }

    }

    //get password string
    public String getSelectedPassword() {
        return selectedPassword;
    }
}
