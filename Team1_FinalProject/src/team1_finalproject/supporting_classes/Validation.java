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
     *
     * @param email
     * @param msg
     * @return
     */
    public static boolean validEmail(TextField email) {
        return email.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
    }

    /**
     * Method: Checks password length & if passwords match
     *
     * @param pw
     * @param pw2
     * @param msg
     * @return
     */
    public static boolean validPasswords(PasswordField pw, PasswordField pw2) {
        if (pw.getLength() < 6) {
            return false;
        }
        if (pw2.getLength() < 6) {
            return false;
        }
        if (!pw.getText().equals(pw2.getText())) {
            return false;
        }
        return true;
    }

    /**
     * Method: Check password length
     *
     * @param pw
     * @param msg
     * @return
     */
    public static boolean validPassword(PasswordField pw, Text msg) {
        if (pw.getLength() < 6) {
            msg.setText("Invalid Password: min. 6 characters");
            msg.setVisible(true);
            return false;
        } else {
            return true;
        }
    }
} //End Subclass Validation
