package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String M_CONN_STRING =
			"jdbc:mysql://127.0.0.1:3306/dodsms";
	
	public static final String FILESERVER_DIR = 
			"C:\\Users\\bfloyd\\Documents\\";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("begin to connect to database");
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
	}
	
	public static void processException(SQLException e) {
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
	}
	
}
