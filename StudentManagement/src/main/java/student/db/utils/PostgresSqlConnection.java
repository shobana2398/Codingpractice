package student.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresSqlConnection {

	private static Connection connection;
	//for singleton purpose
	private PostgresSqlConnection(){}

	public static Connection getConnection() {

		try {

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the Connection
			String user = "*****"; // user of mysql
			String password = "*****"; // password of mysql
			String url = "jdbc:mysql://localhost:3306/student_manage";
			connection = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
