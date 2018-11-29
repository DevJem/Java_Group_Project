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

    private static String name = null;

    public DBinterface() {
    }

    public static void setName(String n) {
        name = n;
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
        while (result == 0) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + name, "root", "root");
                System.out.println("Connected to DB:\t" + name + "\n\n");
                break;
            } catch (Exception e) {
                System.out.println("Not connected to DB yet. Creating DB...\n" + e);
            }
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                Statement create = conn.createStatement();
                result = create.executeUpdate("CREATE DATABASE " + name);
                System.out.println("Created Database. Green lights!");
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
