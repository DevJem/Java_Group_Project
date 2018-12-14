package team1_finalproject.supporting_classes;

import java.sql.*;

/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Assignment Name: team1_finalproject.supporting_classes
  *  @Date: Nov 29, 2018
  *  @Subclass DBCreate Description:
  */
//Imports

//Begin Subclass DBCreate
public class DBCreate {
    private Statement stmt;
    
    public DBCreate(Connection conn) throws SQLException {
        stmt = conn.createStatement();
    }
    
    public boolean buildDB(String sName) {
        String sql;
        
        try {
            // Create User table
            sql = "CREATE TABLE `User` (\n" +
                "  `idUser` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `program_username` varchar(45) NOT NULL,\n" +
                "  `program_password` varchar(45) NOT NULL,\n" +
                "  `administrator` tinyint(1) DEFAULT '0',\n" +
                "  PRIMARY KEY (`idUser`),\n" +
                "  UNIQUE KEY `Username_UNIQUE` (`program_username`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);
            
            // Create Account table
            sql = "CREATE TABLE `Account` (\n" +
                "  `account_name` varchar(120) NOT NULL,\n" +
                "  `username` varchar(45) DEFAULT NULL,\n" +
                "  `password` varchar(45) DEFAULT NULL,\n" +
                "  `time_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `time_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
                "  `notes` varchar(250) DEFAULT NULL,\n" +
                "  `User_idUser` int(11) NOT NULL,\n" +
                "  `account_type` int(11) DEFAULT '0',\n" +
                "  PRIMARY KEY (`account_name`,`User_idUser`),\n" +
                "  UNIQUE KEY `account_name_UNIQUE` (`account_name`),\n" +
                "  KEY `fk_Account_User1_idx` (`User_idUser`),\n" +
                "  CONSTRAINT `fk_Account_User1` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE CASCADE ON UPDATE NO ACTION\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);

            // Create Settings table
            sql = "CREATE TABLE `Settings` (\n" +
                "  `password_update_notifications` tinyint(1) NOT NULL DEFAULT '0',\n" +
                "  `user_admin` tinyint(1) NOT NULL DEFAULT '0',\n" +
                "  `user_can_modify_settings` tinyint(1) NOT NULL DEFAULT '1',\n" +
                "  `User_idUser` int(11) NOT NULL,\n" +
                "  PRIMARY KEY (`User_idUser`),\n" +
                "  KEY `fk_Settings_User_idx` (`User_idUser`),\n" +
                "  CONSTRAINT `fk_Settings_User` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println("Error!\n" + e.getMessage());
            return false;
        }
        return true;
    }

    boolean addUser(String sName, String sPassword) {
        String sql = "INSERT INTO " + sName + ".`User` (`program_username`, "
                + "`program_password`, `administrator`) VALUES "
                + "(\"" + sName + "\", \"" + sPassword + "\", 1);";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to create user.\n" + e);
            return false;
        }
        
        return true;
    }
    
    boolean addSettings(String sName) {
        int iUserID = -1;
        ResultSet rsCreateSettings;
        
        try {
            // Get User ID
            rsCreateSettings = stmt.executeQuery("SELECT * FROM User WHERE `program_username` = \"" + sName + "\";");
            while (rsCreateSettings.next()) {
                iUserID = rsCreateSettings.getInt("idUser");
            }
            
            String sql = "INSERT INTO `" + sName + "`.`Settings`\n" +
            "(`password_update_notifications`,\n" +
            "`user_admin`,\n" +
            "`user_can_modify_settings`,\n" +
            "`User_idUser`)\n" +
            "VALUES\n" +
            "(0,\n" +
            "1,\n" +
            "1,\n" +
            iUserID + ");";
            
            System.out.println("user id is " + iUserID);
            
            stmt.executeUpdate(sql);
        } catch (SQLException sqle) {
            System.out.println("Could not add settings: " + sqle);
            return false;
        }
        return true;
    }
} // End Subclass DBCreate

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

