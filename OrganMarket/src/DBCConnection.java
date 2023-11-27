import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCConnection {
	DBCConnection() throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public Connection getConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/OrganDatabase";
		String myUserName="root";
		String myPassword="MySQLInstallerRootAccountPassword123!@#";
		Connection connection = DriverManager.getConnection(url, myUserName, myPassword);
		return connection;
	}
}