package team1_finalproject;

/**
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject
 * @Date: Nov 18, 2018
 * @Subclass Main_TableAccounts Description: Holds data for table view
 */
//Imports
import javafx.beans.property.SimpleStringProperty;

//Begin Subclass Main_TableAccounts
public class Main_TableAccounts {

    //Variables
    private SimpleStringProperty account;
    private SimpleStringProperty userID;
    private SimpleStringProperty password;
    private SimpleStringProperty url;
    private SimpleStringProperty notes;

    //Default constructor
    public Main_TableAccounts() {

    }

    //Overload Constructor
    public Main_TableAccounts(String account, String userID, String password, 
            String url, String notes) {
        this.account = new SimpleStringProperty(account);
        this.userID = new SimpleStringProperty(userID);
        this.password = new SimpleStringProperty(password);
        this.url = new SimpleStringProperty(url);
        this.notes = new SimpleStringProperty(notes);
    }

    public String getAccount() {
        return account.get();
    }

    public void setAccount(SimpleStringProperty account) {
        this.account = account;
    }

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(SimpleStringProperty userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

    public String getUrl() {
        return url.get();
    }

    public void setUrl(SimpleStringProperty url) {
        this.url = url;
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(SimpleStringProperty notes) {
        this.notes = notes;
    }
    
    
}   //End Subclass Main_TableAccounts