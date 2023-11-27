import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseClass {
	DBCConnection connection;
	DatabaseClass() throws ClassNotFoundException{
		connection = new DBCConnection();
	}
	
	public boolean addOrgansToOrganDatabase(int[] organs) throws SQLException {
		String insertQuery = "UPDATE Organs\r\n"
				+ "SET Hearts = Hearts + ?,\r\n"
				+ "    Livers = Livers + ?,\r\n"
				+ "    Kidneys = Kidneys + ?,\r\n"
				+ "    Stomachs = Stomachs + ?,\r\n"
				+ "    BoneMarrow_kg = BoneMarrow_kg + ?,\r\n"
				+ "    Bones = Bones + ?\r\n"
				+ "WHERE user = \"Market\"";
		PreparedStatement statement = connection.getConnection().prepareStatement(insertQuery);
		for (int i = 0; i < organs.length; i++)
			statement.setInt(i+1, organs[i]);
		statement.executeUpdate();
		return true;
	}
	public boolean checkUsernameExists(String username) {
	    String selectQuery = "SELECT COUNT(*) FROM donors WHERE username = ?";
	    try (Connection connection = this.connection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(selectQuery)) {
	        statement.setString(1, username);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0; // Username exists if count is greater than 0
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; // Username does not exist
	}
	public boolean isCorrectPassword(String username, String password) throws SQLException {
	    
		Connection connection = getConnection();

	    String sql = "SELECT password FROM donors WHERE username = ?";
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setString(1, username);

	    ResultSet resultSet = statement.executeQuery();

	    boolean isCorrectPassword = false;
	    if (resultSet.next()) {
	        String storedPassword = resultSet.getString("password");
	        if (password.equals(storedPassword)) {
	            isCorrectPassword = true;
	        }
	    }

	    resultSet.close();
	    statement.close();
	    connection.close();

	    return isCorrectPassword;
	}


	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return this.connection.getConnection();
	}

	public boolean updatePassword(String username, String Password, Scanner scanner) throws SQLException {
	    // Establish connection
	    Connection connection = getConnection();

	    // Prepare update statement
	    if (!checkUsernameExists(username)) {System.out.println("Username does not exist!");return false;}
	    if (!isCorrectPassword(username,Password)) {System.out.println("IncorrectPassword!"); return false;}
	    System.out.println("Enter new Password: ");
	    String password = scanner.nextLine();
	    if (!validatePasswordStrength(password)) {System.out.println("Password too weak!"); return false;}
	    String sql = "UPDATE donors SET password = ? WHERE username = ?";
	    PreparedStatement statement = connection.prepareStatement(sql);

	    // Set update parameters
	    statement.setString(1, password);
	    statement.setString(2, username);
	    statement.execute();
	    // Close resources
	    statement.close();
	    connection.close();
	    System.out.println(Password+" has been discarded");
	    System.out.println("Password change Successful!");
	    return true;
	}
	public boolean validatePasswordStrength(String password) {
	    if (password.length() < 8) {
	        return false; 
	    }
	
	    boolean hasLetter = false;
	    boolean hasDigit = false; 
	
	    for (char character : password.toCharArray()) {
	        if (Character.isLetter(character)) {
	            hasLetter = true;
	        } else if (Character.isDigit(character)) {
	            hasDigit = true;
	        }
	    }
	
	    return hasLetter && hasDigit;
	}
	public boolean deleteAccount(String Username, String Password) throws SQLException {
		if (!checkUsernameExists(Username)) {System.out.println("Username does not exist! "+ Username);return false;}
		if (!isCorrectPassword(Username,Password)) {System.out.println("IncorrectPassword!"); return false;}
		  // Delete user from database
		  String deleteQuery = "DELETE FROM donors WHERE username = ?";
		  try (Connection connection = getConnection();
		       PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
		    statement.setString(1, Username);
		    statement.executeUpdate();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  System.out.println("The username '********' and password '*********' have been deleted, but your organs have been kept.");
		  return true; // Successful account deletion
	}

	public boolean GetAndPrintAll() throws SQLException {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM donors");
            System.out.println("___________________________________________________________________");
            System.out.print(  "Username\t");
            System.out.print( "Hearts\t");
            System.out.print(  "Liver\t");
            System.out.print( "Kidney");
            System.out.print( "Stomach\t");
            System.out.print(  "Bonemarrow\t");
            System.out.print( "Bones\t\n");
            System.out.println("___________________________________________________________________");
            while (rs.next()) {
                String username = rs.getString("username");
                if (username.equals("root")) continue;
                int heart = rs.getInt("heart");
                int liver = rs.getInt("liver");
                int kidney = rs.getInt("kidney");
                int stomach = rs.getInt("stomach");
                int bonemarrow = rs.getInt("bonemarrow");
                int bones = rs.getInt("bones");
                
                System.out.print(  username+"\t");
                System.out.print( heart+"\t");
                System.out.print(  liver+"\t");
                System.out.print( kidney+"");
                System.out.print( stomach+"\t");
                System.out.print(  bonemarrow+"\t");
                System.out.print( bones+"\t");
                System.out.println();
            }

            rs.close();
            stmt.close();
            conn.close();
            return true;
    }
	public boolean getAndPrintAllOrgans() throws SQLException {
		Connection connection = getConnection();
		String query = "SELECT * FROM ORGANS";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("| Hearts\t| Livers\t| Kidneys\t| Stomachs\t| BoneMarrow_kg\t|  Bones\t|");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("| " + rs.getInt("Hearts") + "\t| " + rs.getInt("livers") + "\t| " + rs.getInt("kidneys") + "\t| " + rs.getInt("stomachs") + "\t| " + rs.getInt("boneMarrow_kg") + "\t| " + rs.getInt("bones")+"\t|");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
		}
		statement.close();
		connection.close();
		return true;
	}
}
