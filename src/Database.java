//Database class
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Claude Butnaru

public class Database 
{
      public static void connect() 
      {
        Connection conn = null;  
        try 
        {  
            // db parameters  
            String url = "jdbc:sqlite:mainDB.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            System.out.println("Connection to SQLite has been established.");  
        } 
            catch (SQLException e) 
            {  
            System.out.println(e.getMessage());  
            } 
            finally 
            {  
            try 
            {  
                if (conn != null) 
                {  
                    conn.close();  
                }  
            } 
            catch (SQLException ex) 
            {  
              System.out.println(ex.getMessage());  
            }  
        }  
    }      
}
