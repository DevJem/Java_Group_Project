package team1_finalproject.supporting_classes;

/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Assignment Name: team1_finalproject.supporting_classes
  *  @Date: Nov 29, 2018
  *  @Subclass DBFileOperations Description:
  */
//Imports
import java.io.IOException;
import java.sql.Connection;

//Begin Subclass DBFileOperations
public class DBFileOperations {
    private Connection conn;
    
    public DBFileOperations(Connection c) {
        conn = c;
    }
    
    //TODO: Save an encrypted file
    // This code from https://stackoverflow.com/a/37829318/4196281
    public void saveFile(String sName) throws IOException, InterruptedException {
        String plainText;
        String dump = "mysqldump -u root -p root " + sName + " > path/to/file.sql";
        String[] cmdarray = {"/bin/sh","-c", dump};
        Process p = Runtime.getRuntime().exec(cmdarray);
        if (p.waitFor() == 0) {
            // Everything went fine
        } else {
           // Something went wrong
        }
        
    }
    
    public void openFile() {
        
    }

} // End Subclass DBFileOperations

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