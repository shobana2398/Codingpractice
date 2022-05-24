package banking.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {
	
	private final static String CLASS_NAME = "org.postgresql.Driver";
  
    private final static String URL = "jdbc:postgresql://localhost:5432/Banking_Application";
    private final static String USER = "postgres";
    private final static String PASSWORD = "pass123";
    private static Connection connection;
	
	public static Connection postgeConnection()
	{
		
		   
		        if (connection == null) {
		            try {
		        // Class.forName(CLASS_NAME);
		                connection = DriverManager.getConnection(URL, USER, PASSWORD);
           } 
		            catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		        return connection;
		    }
		
	}


