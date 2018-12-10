package team1_finalproject.supporting_classes;

import java.sql.*;

/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Assignment Name: team1_finalproject.supporting_classes
  *  @Date: Nov 29, 2018
  *  @Subclass DBQueries Description:
  */
//Imports

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
     * @return 
     */
    String retrieveUser() {
        String sPassword = null;
        ResultSet result;
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
    
    public static boolean addAccount(String accountName, String username, String password,
            String notes) {
        ResultSet rsUserID;
        int iUser = -1;
        try {
            // Get user id
            rsUserID = stmt.executeQuery("SELECT idUser FROM User WHERE `program_username` = " + sName + ";");
            while (rsUserID.next()) {
                iUser = rsUserID.getInt("idUser");
                System.out.println("User id is " + iUser);
            }
            
            // add the account
            String query = 
                "INSERT INTO `" + sName + "`.`Account`\n" +
                    "(`account_name`,\n" +
                    "`username`,\n" +
                    "`password`,\n" +
                    "`notes`,\n" +
                    "`User_idUser`,\n" +
                    "`account_type`)\n" +
                "VALUES\n" +
                    "(\"" + accountName + "\",\n" +
                    "\"" + username + "\",\n" +
                    "\"" + password + "\",\n" +
                    "\"" + notes + "\",\n" +
                    iUser + ",\n" +
                    "0);";  // Account type to be added later. 
            stmt.executeQuery(query);
            System.out.println("Account added!");
            
        } catch (SQLException sqle) {
            System.out.println("Add Account failed.\n" + sqle);
            return false;
        }
        return true;
    }
    
    public static void editAccount(String accountName, String username, String password, String notes) {
        //TODO Edit account using only changed info
    }
    
    public static void deleteAccount (String accountName) {
        //TODO delete account
    }

} // End Subclass DBQueries

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