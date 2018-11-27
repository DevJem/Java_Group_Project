package team1_finalproject.supporting_classes;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import team1_finalproject.Team1_FinalProject;

/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Subclass DBinterface Description:
  */
//Imports

//Begin Subclass DBinterface
public class DBinterface {
    
    public DBinterface() {
    }
    
    public void connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Team1_FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mydb", "root", "root");
            if (conn != null) {
                System.out.println("Connected to DB:\t" + conn + "\n\n");
            }
        } catch (Exception e) {
            System.out.println("Not connected to DB\n" + e);
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