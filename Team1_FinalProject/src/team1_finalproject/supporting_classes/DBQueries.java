package team1_finalproject.supporting_classes;

/**
 * @Course: SDEV 450 ~ Java Programming III - Enterprise Java
 * @Author Name: Jeremy DeHay
 * @Assignment Name: team1_finalproject.supporting_classes
 * @Date: Nov 29, 2018
 * @Subclass DBQueries Description:
 */
//Imports
import java.sql.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import team1_finalproject.Main_TableAccounts;

//Begin Subclass DBQueries
public class DBQueries {

    private static Statement stmt;
    private static String sRequiredPassword;
    private static String sName = null;

    public DBQueries(Connection conn) throws SQLException {
        stmt = conn.createStatement();
    }

    public static boolean checkPW(String enteredPW) {
        System.out.println("entered pw: " + enteredPW + " actual pw: " + sRequiredPassword);
        return enteredPW.equals(sRequiredPassword);
    }

    /**
     * pull username and password to test database connection.
     *
     * @return
     */
    String retrieveUser() {
        String sPassword = null;
        ResultSet result = null;
        String query = "SELECT * FROM User";
        try {
            result = stmt.executeQuery(query);
            while (result.next()) {
                sName = result.getString("program_username");
                sPassword = result.getString("program_password");
            }
        } catch (SQLException e) {
            System.out.println("Error getting info:\n" + e);
        }
        
        sRequiredPassword = sPassword;      // For pw validation
        return "Name is: " + sName + " and password is " + sPassword + "\n";  // TODO turn this off before deployment!!!
    }

    /**
     * Add account details
     * @param accountName
     * @param username
     * @param password
     * @param notes
     * @return 
     */
    public static boolean addAccount(String accountName, String username, String password,
            String notes) {
        ResultSet rsUserID;
        int iUser = -1;
        try {
            // Get user id
            rsUserID = stmt.executeQuery("SELECT idUser FROM User WHERE `program_username` = \"" + sName + "\";");
            while (rsUserID.next()) {
                iUser = rsUserID.getInt("idUser");
                System.out.println("User id is " + iUser);
            }

            // add the account
            String query
                    = "INSERT INTO `" + sName + "`.`Account`\n"
                    + "(`account_name`,\n"
                    + "`username`,\n"
                    + "`password`,\n"
                    + "`notes`,\n"
                    + "`User_idUser`,\n"
                    + "`account_type`)\n"
                    + "VALUES\n"
                    + "(\"" + accountName + "\",\n"
                    + "\"" + username + "\",\n"
                    + "\"" + password + "\",\n"
                    + "\"" + notes + "\",\n"
                    + iUser + ",\n"
                    + "0);";  // Account type to be added later. 
            stmt.executeUpdate(query);
            System.out.println("Account added!");

        } catch (SQLException sqle) {
            System.out.println("Add Account failed.\n" + sqle);
            return false;
        }
        return true;
    }

    /**
     * Edit account details
     * @param accountName
     * @param username
     * @param password
     * @param notes 
     * @return  
     */
    public static boolean editAccount(String accountName, String username, String password, String notes) {
        // Edit account using only changed info
        ResultSet rsEditAccount;
        String sAccount = "";
        try {
            // Get Account name
            rsEditAccount = stmt.executeQuery("SELECT * FROM Account WHERE `account_name` = \"" + accountName + "\";");
            while (rsEditAccount.next()) {
                sAccount = rsEditAccount.getString("account_name");
                System.out.println("Account is " + sAccount);
            }
            
            // edit the account
            int currentCount = 0;
            int lastCount = 0;
            String query = "UPDATE `Account` ";
            
            // edit entry if there's content
            if (!username.equals("")) {
                if (currentCount > lastCount) {
                    lastCount = currentCount;
                    query += ", ";
                }
                query += "SET `username` = \"" + username + "\"";
                currentCount++;
            }
            if (!password.equals("")) {
                if (currentCount > lastCount) {
                    lastCount = currentCount;
                    query += ", ";
                }
                query += "SET `password` = \"" + password + "\"";
                currentCount++;
            }
            if (!notes.equals("")) {
                if (currentCount > lastCount) {
                    lastCount = currentCount;
                    query += ", ";
                }
                query += "SET `notes` = \"" + notes + "\"";
                currentCount++;
            }
            query += " WHERE `account_name` = \"" + sAccount + "\"";
            
            stmt.executeUpdate(query);
            System.out.println("Account edited!");
            
        } catch (SQLException sqle) {
            System.out.println("Edit Account failed.\n" + sqle);
            return false;
        }
        return true;
    }

    /**
     * Delete account
     * @param accountName 
     */
    public static boolean deleteAccount(String accountName) {
        // delete account
        ResultSet rsDelAccount;
        String sAccount = "";
        try {
            // Get Account name
            rsDelAccount = stmt.executeQuery("SELECT * FROM Account WHERE `account_name` = \"" + accountName + "\";");
            while (rsDelAccount.next()) {
                sAccount = rsDelAccount.getString("account_name");
                System.out.println("Account is " + sAccount);
            }
            
            // Delete the account
            String query = "DELETE FROM Account WHERE `account_name` = \"" + accountName + "\";" ;
            stmt.executeUpdate(query);
            
        } catch (SQLException sqle) {
            System.out.println("Account deletion failed.\n" + sqle);
            return false;
        }
            return true;
    }
    
    public static ObservableList<Main_TableAccounts> buildTableView() {
        ObservableList<Main_TableAccounts> data = FXCollections.observableArrayList();
        String sqlStatement = "select * from Account";
        
        try {
            ResultSet rs = stmt.executeQuery(sqlStatement);
            
            while (rs.next()) {
                Main_TableAccounts mta = new Main_TableAccounts();
                mta.setAccount(new SimpleStringProperty(rs.getString("account_name")));
                mta.setUserID(new SimpleStringProperty(rs.getString("username")));
                mta.setPassword(new SimpleStringProperty(rs.getString("password")));
                mta.setCreated(rs.getTimestamp("time_created"));
                mta.setModified(rs.getTimestamp("time_modified"));
                mta.setNotes(new SimpleStringProperty(rs.getString("notes")));
                data.add(mta);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Error occured while loading data: " + e);
        }
        return data;
    }
    
    public static boolean validateCurrentUser() {
        
        return true;
    }
}


/*
 (                         *     
 )\ )                    (  `    
(()/(  (   (   (  (  (   )\))(   
 /(_)) )\  )\  )\ )\ )\ ((_)()\  
(_))_ ((_)((_)((_|(_|(_)(_()((_) 
 |   \| __\ \ / / | | __|  \/  | 
 | |) | _| \ V / || | _|| |\/| | 
 |___/|___| \_/ \__/|___|_|  |_| 
      https://is.gd/RGR0UQ                  
*/
