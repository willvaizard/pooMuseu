package persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	private static String JDBC_URL = "jdbc:mysql://localhost/Museu";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "aluno";

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	private static final String JDBC_URL = "jdbc:mysql://mysql.asgardprint.com.br/asgardprint04";
//	private static final String JDBC_USER = "asgardprint04";
//	private static final String JDBC_PASSWORD = "ads2016";
	private static JDBCUtil instancia;
	private Connection con;
	
	private JDBCUtil(){
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static JDBCUtil getInstancia(){
		if (instancia == null){
			instancia = new JDBCUtil();
		}
		return instancia;
	}
	
	public Connection getConnection(){
		if (con == null){
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
	}

}
