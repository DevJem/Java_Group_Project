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
    //TODO: clean up unused variables and imports
    @FXML
    private Label lblPasswordGenerator;
    @FXML
    private Label lblPasswordLength;
    @FXML
    private TextField tfPasswordLength;
    @FXML
    private Label lblCharacterSet;
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
    private TextArea taGeneratedPassword;
    @FXML
    private Font x2;
    @FXML
    private Font x3;
    @FXML
    private Insets x4;
    @FXML
    private Font x1;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblGeneratedPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //select all true by default
        cbSelectAll.setSelected(true);
    }

    //Handle Button Click: closes popup window
    @FXML
    public void Cancel(ActionEvent event) throws Exception {
        Stage passwordGen = (Stage) ((Node) event.getSource()).getScene().getWindow();
        passwordGen.close();
    }

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
    
    public String generatePW() {
        taGeneratedPassword.clear();
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
            taGeneratedPassword.appendText(sGeneratedPasswords[i] + "\n");
        }
        
        return sGeneratedPasswords[0];
    }
    
    //TODO interface pwgen here
    
    
}
