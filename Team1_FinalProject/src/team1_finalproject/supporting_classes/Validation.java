package team1_finalproject.supporting_classes;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject.supporting_classes
 * @Date: Dec 13, 2018
 * @Subclass Validation Description:
 */
//Imports
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

//Begin Subclass Validation
public class Validation {

    public boolean validEmail(TextField email, Text errorMsg) {
        if (email.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            return true;
        }
        errorMsg.setText("Invalid Email. Please try again.");
        return false;
    }
    
    public boolean validPassword(TextField pw) {
        //if()
    }
} //End Subclass Validation
