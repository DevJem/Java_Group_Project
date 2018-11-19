/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainWindowController implements Initializable {

    //Variables
    @FXML
    private TreeView<String> treeView;
    @FXML
    private TableView<String> tableView;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initializes tree view
        treeView();
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
    
    //Creates tree view and default elements
    private void treeView() {
        
        TreeItem<String> myPasswords = new TreeItem<>("My Passwords");       
        TreeItem<String> social = new TreeItem<>("Social Media");
        TreeItem<String> email = new TreeItem<>("Email");
        TreeItem<String> work = new TreeItem<>("Work");
        TreeItem<String> other = new TreeItem<>("Other");
        myPasswords.getChildren().addAll(social, email, work, other);
        
        TreeItem<String> creditCards = new TreeItem("Credit Cards");
        TreeItem<String> personal = new TreeItem<>("Personal");
        TreeItem<String> business = new TreeItem<>("Business");
        creditCards.getChildren().addAll(personal, business);
        
        TreeItem<String> root = new TreeItem<>();
        root.getChildren().addAll(myPasswords, creditCards);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }
}
