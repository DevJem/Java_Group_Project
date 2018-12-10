package team1_finalproject.supporting_classes;

//Imports
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import team1_finalproject.Team1_FinalProject;

/**
 * @Course: SDEV 450 ~ Java Programming III - Enterprise Java
 * @Author Name: Jeremy DeHay
 * @Subclass DBinterface Description:
 */
//Begin Subclass DBInterface
public class DBInterface {

    private static String sName = null;
    private static String sPassword = null;
    // set up connection
    private static Connection conn = null;
    private static Statement create = null;

    public DBInterface() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Team1_FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setName(String n) {
        sName = n;
    }

    public static void setPassword(String pw) {
        sPassword = pw;
    }
    
    public boolean connect() {
        /**
         * Assist: https://stackoverflow.com/a/717451/4196281
         */
        // Use existing db
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + sName, "root", "root");
            System.out.println("Connected to DB:\t" + sName + "\n\n");
            
        } catch (Exception e) {
            System.out.println(e + "\nNot connected to DB.\n");
            conn = null;
            return false;
        }
        
        // Checks db input for validation
        try {
            DBQueries queries = new DBQueries(conn);
            System.out.println(queries.retrieveUser());
        } catch (SQLException ex) {
            Logger.getLogger(DBInterface.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public static void disconnect() {
        try {
            if (create != null)
                create.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Couldn't close connections\n" + e);
        }
    }
    
    public boolean createDB() {
        // Create db if doesn't exist
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            create = conn.createStatement();
            create.executeUpdate("CREATE DATABASE " + sName);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + sName, "root", "root");
            DBCreate newDB = new DBCreate(conn);
            if (!newDB.buildDB(sName)) {
                System.out.println("Failed creating tables");
                throw new SQLException();
            }
            if (!newDB.addUser(sName, sPassword)) {
                throw new SQLException();
            }
            System.out.println("Created Database. Green lights!");

        } catch (SQLException sqle) {                
            System.out.println("\nFailed to create DB. Error message:\n" + sqle);
            return false;
        } catch (Exception e) {
            System.out.println("\nFailed to create DB. Error message:\n" + e);
            return false;
        }
        return true;
    }

} // End Subclass DBInterface

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
