import java.sql.*;
import java.util.*;

public class Donor {
	static  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	String username;
	String password;
	int[] donationPreferences;
	DatabaseClass database;
	public Donor() {
		database = new DatabaseClass();
	}
	public void getOrgans() {

	    // Retrieve organ donation preferences from the database
	    String selectQuery = "SELECT heart, liver, kidney, stomach, bonemarrow, bones FROM donors WHERE username = ?";
	    try (Connection connection = database.getConnection();
	         PreparedStatement statement = connection.prepareStatement(selectQuery)) {
	        statement.setString(1, this.username);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int heart = resultSet.getInt("heart");
	            int liver = resultSet.getInt("liver");
	            int kidney = resultSet.getInt("kidney");
	            int stomach = resultSet.getInt("stomach");
	            int bonemarrow = resultSet.getInt("bonemarrow");
	            int bones = resultSet.getInt("bones");

	            System.out.println("Your donations: ");
	            System.out.println("You have " + heart+ " Hearts in the market." );
	            System.out.println("You have " + liver+ " Livers in the market." );
	            System.out.println("You have " + kidney+ " Kidneys in the market.");
	            System.out.println("You have " + stomach+ " Stomachs in the market.");
	            System.out.println("Bone Marrow: " + (bonemarrow )+" kilos.");
	            System.out.println("You have " + bones+ " Bones in the market. " );
	        } else {
	            System.out.println("User not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public boolean signup(String username, String password, int[] donationPreferences) throws SQLException {
		  // Check if username exists
		  if (database.checkUsernameExists(username)) {
			  System.out.println("Username already exists");
			  return false; // Username already exists
		  }

		  // Insert user data into database
		  String insertQuery = "INSERT INTO donors (username, password, heart, liver, kidney, stomach, bonemarrow, bones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		  try (Connection connection = database.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			    statement.setString(1, username);
			    statement.setString(2, password);
			    for (int i = 0; i < donationPreferences.length; i++) {
			      statement.setInt(3 + i, donationPreferences[i]);
			    }
			    statement.executeUpdate();
		  } catch (SQLException e) {
		    e.printStackTrace();
		    return false;
		  }
		  this.username = username;
		  this.password=password;
		  this.donationPreferences=donationPreferences;
		  database.addOrgansToOrganDatabase(this.donationPreferences);
		  System.out.println("Registration Successful");
		  return true; // Successful registration
	}
	public boolean login(String username, String password) {
		  // Check if username exists
		  if (!database.checkUsernameExists(username)) {
			  System.out.println("Username Doesnt Exist");
			  return false;
		  }

		  // Retrieve password from database
		  String selectQuery = "SELECT password FROM donors WHERE username = ?";
		  try (Connection connection = database.getConnection();
		       PreparedStatement statement = connection.prepareStatement(selectQuery)) {
		    statement.setString(1, username);
		    ResultSet resultSet = statement.executeQuery();
		    if (resultSet.next()) {
		      String storedPassword = resultSet.getString("password");
		      if (storedPassword.equals(password)) {
		    	  this.username = username;
				  this.password=password;
		        return true; // Successful login
		      }
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  System.out.println("Invalid Password");
		  return false; // Invalid password 
		}

	public boolean requestSignUpUserInfo(Scanner scanner) throws SQLException {

	    System.out.print("Enter username: ");
	    String username = scanner.nextLine();
	 // Check username length
	    if (username.length() < 6 || username.length() > 20) {
	    	scanner.close();
	        System.out.println("Username must be between 6 and 20 characters long.");
	        return false;
	    }
	    System.out.println("Enter new password: ");
	    String password = scanner.nextLine();
	 // Check password strength
	    if (!database.validatePasswordStrength(password)) {
	        System.out.println("Password must be at least 8 characters long and contain at least one letter and one number.");
	        return false;
	    }
	    int count = 0;
	    System.out.println("Organ preferences:");
	    System.out.println("How many hearts would you like to offer: ");
	    count = scanner.nextInt();
	    int heartPreference = count < 0? 0 : count;

	    System.out.println("How many livers would you like to offer: ");
	    count = scanner.nextInt();
	    int liverPreference = count < 0 ? 0 : count;

	    System.out.println("How many kidneys would you like to offer: ");
	    count = scanner.nextInt();
	    int kidneyPreference = count < 0 ? 0 : count;

	    System.out.println("How many stomachs would you like to offer: ");
	    count = scanner.nextInt();
	    int stomachPreference = count < 0 ? 0 : count;

	    System.out.println("How many kilograms of bonemarrow are you offering(We're currently experiencing a shortage): ");
	    count = scanner.nextInt();
	    int bonemarrowPreference = count < 0 ? 0 : count;

	    System.out.println("How many bones would you like to offer: ");
	    count = scanner.nextInt();
	    int bonesPreference = count < 0 ? 0 : count;

	    int[] donationPreferences = new int[6];
	    donationPreferences[0] = heartPreference;
	    donationPreferences[1] = liverPreference;
	    donationPreferences[2] = kidneyPreference;
	    donationPreferences[3] = stomachPreference;
	    donationPreferences[4] = bonemarrowPreference;
	    donationPreferences[5] = bonesPreference;

	    // Validate user input and sign up if valid
	    if (validateUserInput(donationPreferences)) {
	        signup(username, password, donationPreferences);
	        return true; // Successful sign up
	    }

	    return false; // Invalid input
	}
	private boolean validateUserInput(int[] donationPreferences) {
	    int count=0;
	    for (int organs : donationPreferences ) {
	    	count+=organs;
	    }
	    // No organs
	    if (count ==0) { 
	    	System.out.println("You can not signup without organs!"); 
	    	return false;
	    }
	    return true; // Input is valid
	}
	public boolean changePassword(Scanner scanner) throws SQLException {
		System.out.println("Username: ");
		scanner.nextLine();
		String username = scanner.nextLine();
		if (!this.username.equals("root") && !username.equals(this.username)) {System.out.println("Wrong username"); return false;}
        if (isRoot(username)) {System.out.println("Root's password cannot be changed."); return false;}

        System.out.println("Password: ");
        String Password = scanner.nextLine();
        return database.updatePassword(username, Password);
     }

	public boolean deleteAccount(Scanner scanner) throws SQLException {
		System.out.println("Username: ");
		scanner.nextLine();
		String username = scanner.nextLine();
		if (!this.username.equals("root") && !username.equals(this.username)) {System.out.println("Wrong username"); return false;}
		if (isRoot(username)) {System.out.println("Root cannot be deleted."); return false;}
		System.out.println("Password: ");
		String password = scanner.nextLine();
		return database.deleteAccount(username, password);
	}
	private boolean isRoot(String username) {
		return username.equals( "root");
	}
	@SuppressWarnings("unused") 
	public boolean isRoot() {
		return isRoot(this.username);
	}
	public boolean getAll(Scanner s) throws SQLException {
		if (!isRoot()) {System.out.println("Only the root account can get all"); return false;}
		return database.GetAndPrintAll();
	}
	public boolean getAllOrgans(Scanner input) throws SQLException {
		// TODO Auto-generated method stub
		if (!isRoot()) { 
			System.out.println("Only the root account can get all"); return false; 
		}
		return database.getAndPrintAllOrgans();
		
	}
	
}
