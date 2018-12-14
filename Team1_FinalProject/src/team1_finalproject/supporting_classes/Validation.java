package team1_finalproject.supporting_classes;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject.supporting_classes
 * @Date: Dec 13, 2018
 * @Subclass Validation Description:
 */
//Imports
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

//Begin Subclass Validation
public class Validation {

    /**
     * Method: Checks if email is valid 
     * @param email
     * @param msg
     * @return 
     */
    
    public static boolean validEmail(TextField email, Text msg) {
        if (!email.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
            msg.setText("Invalid Email: Please try again.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method: Checks password length & if passwords match
     * @param pw
     * @param pw2
     * @param msg
     * @return 
     */
    public static boolean validPasswords(PasswordField pw, PasswordField pw2, Text msg) {
        if (pw.getLength() < 6 || pw2.getLength() < 6) {
            msg.setText("Invalid Password: must be 6 characters minimum");
            return false;
        } 
        if (!pw.getText().equals(pw2.getText())) {
            msg.setText("Invalid Password: passwords do not match");
            return false;
        }
        return true;
    }
    
    /**
     * Method: Check password length
     * @param pw
     * @param msg
     * @return 
     */
    public static boolean validPassword(PasswordField pw, Text msg) {
        if (pw.getLength() < 6) {
            msg.setText("Invalid Password: must be 6 characters minimum");
            return false;
        } else {
            return true;
        }
    }
} //End Subclass Validation
