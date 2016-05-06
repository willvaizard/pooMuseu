package persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	private static String JDBC_URL = "jdbc:mysql://mysql.asgardprint.com.br/asgardprint01";
	//	private static String JDBC_USER = "asgardprint01";
	//	private static String JDBC_PASSWORD = "ads2016";
	
	private static String JDBC_URL = "jdbc:mysql://localhost/Museu";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "ads2016";


	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Failed to initialise JDBC driver");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
