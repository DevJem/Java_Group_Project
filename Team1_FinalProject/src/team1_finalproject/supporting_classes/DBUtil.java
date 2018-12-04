package team1_finalproject.supporting_classes;

/** 
 * @Course: SDEV 450 ~ Java Enterprise
 * @Author Name: Jenney Chang
 * @Assignment Name: team1_finalproject.supporting_classes
 * @Date: Nov 30, 2018
 * @Subclass DBUtil Description: helper class to run query calls to database
 */
//Imports
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

//Begin Subclass DBUtil
public class DBUtil {
    
    //Variables
    private static Connection connection = null;
    
    //Used to execute Add, Edit, Delete queries to database
    public static void dbExecuteQuery(String sqlStatement) throws SQLException {
        Statement statement = null;
       
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            System.out.println("Error occured during query: " + e);
        }
    }
    
    //Returns result set from database
    public static ResultSet dbExecute(String sqlStatement) throws SQLException {
        Statement statement = null;
        ResultSet results = null;
        CachedRowSetImpl cache = null;
        
        try {
            statement = connection.createStatement();
            results = statement.executeQuery(sqlStatement);
            cache = new CachedRowSetImpl();
            cache.populate(results);
        } catch(SQLException e) {
            System.out.println("Error occured during retrieval query: " + e);
        } finally {
            if(statement != null) {
                results.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
        
        return results;
    }
} //End Subclass DBUtil