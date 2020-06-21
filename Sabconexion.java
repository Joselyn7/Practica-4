package sabina.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sabconexion {
	private String jdbcURL;
	private String jdbcUserName;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public Sabconexion(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL=jdbcURL;
		this.jdbcUserName=jdbcUserName;
		this.jdbcPassword=jdbcPassword;
		
	}
	public void connection() throws SQLException{
		if(jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection= DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
	
		}
	}
	public void discconect() throws SQLException {
		if(jdbcConnection!=null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	public Connection getjdbcConnection() {
		return jdbcConnection;
	}
}






























