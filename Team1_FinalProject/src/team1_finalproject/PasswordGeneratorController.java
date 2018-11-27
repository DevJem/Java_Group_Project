/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1_finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PasswordGeneratorController implements Initializable {

    //Variables
    @FXML
    private Label lblPasswordGenerator;
    @FXML
    private Label lblPasswordLength;
    @FXML
    private Font x2;
    @FXML
    private TextField tfPasswordLength;
    @FXML
    private Label lblCharacterSet;
    @FXML
    private CheckBox cbUpperCase;
    @FXML
    private Font x3;
    @FXML
    private Insets x4;
    @FXML
    private CheckBox cbLowerCase;
    @FXML
    private CheckBox cbSpecialCharas;
    @FXML
    private CheckBox cbNumbers;
    @FXML
    private CheckBox cbSelectAll;
    @FXML
    private Font x1;
    @FXML
    private Label lblGeneratedPassword;
    @FXML
    private ListView<?> lvGeneratedPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //select all true by default
        cbSelectAll.setSelected(true);
    }

    public void Cancel(ActionEvent event) throws Exception {
        Stage addAccount = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addAccount.close();
    }

    public void CheckBox() {

    }
}
