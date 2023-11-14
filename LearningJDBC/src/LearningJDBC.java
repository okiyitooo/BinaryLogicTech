import java.sql.*;

public class LearningJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/javaDebuggers";
		String myusername = "root";
		String mypassword = "MySQLInstallerRootAccountPassword123!@#";
		Connection connection = DriverManager.getConnection(url,myusername,mypassword);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
		while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            System.out.println(id + " - " + username+ " - "+password+" - "+email);
        }

        resultSet.close();
        statement.close();
        connection.close();
		
	}

}
