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
            sql = "CREATE TABLE IF NOT EXISTS `User` (\n" +
                "  `idUser` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `program_username` VARCHAR(45) NOT NULL,\n" +
                "  `program_password` VARCHAR(45) NOT NULL,\n" +
                "  `administrator` TINYINT(1) NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idUser`),\n" +
                "  UNIQUE INDEX `Username_UNIQUE` (`program_username` ASC))";
            stmt.executeUpdate(sql);
            
            // Create Account table
            sql = "CREATE TABLE IF NOT EXISTS `Account` (\n" +
                "  `account_name` VARCHAR(120) NOT NULL,\n" +
                "  `username` VARCHAR(45) NULL DEFAULT NULL,\n" +
                "  `password` VARCHAR(45) NULL DEFAULT NULL,\n" +
                "  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `time_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
                "  `notes` VARCHAR(250) NULL DEFAULT NULL,\n" +
                "  `User_idUser` INT(11) NOT NULL,\n" +
                "  `account_type` INT(11) NULL DEFAULT '0',\n" +
                "  UNIQUE INDEX `account_name_UNIQUE` (`account_name` ASC),\n" +
                "  INDEX `fk_Account_User1_idx` (`User_idUser` ASC),\n" +
                "  CONSTRAINT `fk_Account_User1`\n" +
                "    FOREIGN KEY (`User_idUser`)\n" +
                "    REFERENCES " + sName + ".`User` (`idUser`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE NO ACTION)";
            stmt.executeUpdate(sql);

            // Create Settings table
            sql = "CREATE TABLE IF NOT EXISTS `Settings` (\n" +
                "  `password_update_notifications` TINYINT(1) NOT NULL DEFAULT '0',\n" +
                "  `user_admin` TINYINT(1) NOT NULL DEFAULT '0',\n" +
                "  `user_can_modify_settings` TINYINT(1) NOT NULL DEFAULT '1',\n" +
                "  `User_idUser` INT(11) NOT NULL,\n" +
                "  INDEX `fk_Settings_User_idx` (`User_idUser` ASC),\n" +
                "  CONSTRAINT `fk_Settings_User`\n" +
                "    FOREIGN KEY (`User_idUser`)\n" +
                "    REFERENCES " + sName + ".`User` (`idUser`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)";
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

