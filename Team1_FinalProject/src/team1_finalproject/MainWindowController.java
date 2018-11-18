/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


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
        treeView();
    }    
   
    
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
