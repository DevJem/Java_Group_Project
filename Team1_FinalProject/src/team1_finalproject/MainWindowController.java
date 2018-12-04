/*
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Description: Controller adds functionality for Main Window Program
 */
package team1_finalproject;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

    //Variables
    @FXML   private TableView<Main_TableAccounts> tableView;
    @FXML   private TableColumn<Main_TableAccounts, String> columnAccount;
    @FXML   private TableColumn<Main_TableAccounts, String> columnUserID;
    @FXML   private TableColumn<Main_TableAccounts, String> columnPassword;
    @FXML   private TableColumn<Main_TableAccounts, LocalDate> columnCreated;
    @FXML   private TableColumn<Main_TableAccounts, LocalDate> columnModified;    
    @FXML   private TableColumn<Main_TableAccounts, String> columnNotes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //sets up tree view 
        tableView();
        
    }

    //Handles Button Click: opens up add account window as popup
    public void addButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    //Handles Button Click: opens up edit account window as popup
    public void editButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    //Handles Button Click: opens up delete account window as popup
    public void deleteButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("DeleteAccount.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    //Handles Button Click: opens up password gen window as popup
    public void passwordGenerator(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("PasswordGenerator.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    //Menu Item Settings: opens up settings window as popup
    @FXML
    public void Settings(ActionEvent event) throws Exception {
        Stage stage;
        Parent rootBP = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene sceneBP = new Scene(rootBP);

        stage = new Stage();
        stage.setScene(sceneBP);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    
    @FXML
    //Menu Item Exit: Exits program 
    public void ExitProgram(ActionEvent event) throws Exception {
        Platform.exit();
    }
    
    //Create table column defaults
    private void tableView() {
        columnAccount.setCellValueFactory(new PropertyValueFactory<>("account"));
        columnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        columnCreated.setCellValueFactory(new PropertyValueFactory<>("Created"));
        columnModified.setCellValueFactory(new PropertyValueFactory<>("Modified"));
        columnNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        
        //Load data from database
    }
}
