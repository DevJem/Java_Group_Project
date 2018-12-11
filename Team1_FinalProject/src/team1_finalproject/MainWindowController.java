package team1_finalproject;

/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: Controller adds functionality for Main Window Program
 */
//Imports
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.stage.Modality;
import javafx.stage.Stage;
import team1_finalproject.supporting_classes.DBQueries;

public class MainWindowController implements Initializable {

    //Variables
    @FXML
    private TableView<Main_TableAccounts> tableView;
    @FXML
    private TableColumn<Main_TableAccounts, String> columnAccount;
    @FXML
    private TableColumn<Main_TableAccounts, String> columnUserID;
    @FXML
    private TableColumn<Main_TableAccounts, String> columnPassword;
    @FXML
    private TableColumn<Main_TableAccounts, Timestamp> columnCreated;
    @FXML
    private TableColumn<Main_TableAccounts, Timestamp> columnModified;
    @FXML
    private TableColumn<Main_TableAccounts, String> columnNotes;

    /**
     * Method: Initializes
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Set up columns for table view
        columnAccount.setCellValueFactory(new PropertyValueFactory<>("account"));
        columnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        columnCreated.setCellValueFactory(new PropertyValueFactory<>("Created"));
        columnModified.setCellValueFactory(new PropertyValueFactory<>("Modified"));
        columnNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

        populateTable();

        //TODO: Change password column to password field unless userid = currentuser
        //if (DBQueries.validateCurrentUser()) {};  //working on this
    }

    /**
     * Method: Populates table view 
     */
    public void populateTable() {
        tableView.setItems(DBQueries.buildTableView());
    }
    
    //TODO open button
    @FXML
    public void openButton(ActionEvent event) throws Exception {
        
    }
    
    //TODO save button
    @FXML
    public void saveButton(ActionEvent event) throws Exception {
        
    }
    
    /**
     * Method: Add Account pop-up
     *
     * @param event
     * @throws Exception
     */
    public void addButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
 
        populateTable();
    }

    /**
     * Method: Edit Account pop-up
     *
     * @param event
     * @throws Exception
     */
    public void editButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        populateTable();
    }

    /**
     * Method: Delete Account pop-up
     *
     * @param event
     * @throws Exception
     */
    public void deleteButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("DeleteAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        populateTable();
    }
    
    /**
     * Method: Settings pop-up
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void Settings(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        populateTable();
    }
    
    /**
     * Method: Exits program
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void ExitProgram(ActionEvent event) throws Exception {
        Platform.exit();
    }

    //MENU ITEMS LEFT
    //method cut
    public void cut() {
        
    }
    
    //method copy
    public void copy() {
        
    }
    
    //method paste
    public void paste() {
        
    }
    
    //method about
    public void about() {
        
    }

    //TODO menu item save
    //TODO menu item save as
}
