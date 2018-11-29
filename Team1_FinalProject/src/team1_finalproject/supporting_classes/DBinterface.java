package team1_finalproject.supporting_classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import team1_finalproject.Team1_FinalProject;

/**
 * @Course: SDEV 450 ~ Java Programming III - Enterprise Java
 * @Author Name: Jeremy DeHay
 * @Subclass DBinterface Description:
 */
//Imports
//Begin Subclass DBinterface
public class DBinterface {

    private static String sName = null;
    private static String sPassword = null;

    public DBinterface() {
    }

    public static void setName(String n) {
        sName = n;
    }

    public static void setPassword(String pw) {
        sPassword = pw;
    }
    
    public void connect() {
        int result = 0;

        // set up connection
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Team1_FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * Here we try to make a new database for each user. This looks for a
         * database under the current username and, if it's not found, creates
         * one. Assist: https://stackoverflow.com/a/717451/4196281
         */
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + sName, "root", "root");
            System.out.println("Connected to DB:\t" + sName + "\n\n");
        } catch (Exception e) {
            System.out.println(e + "\nNot connected to DB yet. Creating DB...\n");
            conn = null;
        }
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                Statement create = conn.createStatement();
                result = create.executeUpdate("CREATE DATABASE " + sName);
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + sName, "root", "root");
                DBCreate newDB = new DBCreate(conn);
                if (!newDB.buildDB()) {
                    throw new SQLException();
                }
                if (!newDB.addUser(sName, sPassword)) {
                    throw new SQLException();
                }
                System.out.println("Created Database. Green lights!");

                System.out.println(newDB.retrieveUser());
            } catch (SQLException sqle) {                
                System.out.println("\nFailed to create DB. Error message:\n" + sqle);
            } catch (Exception e) {
                System.out.println("\nFailed to create DB. Error message:\n" + e);
            }
        }
        
    }

} // End Subclass DBinterface

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
