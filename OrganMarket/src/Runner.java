import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.*;
import java.io.BufferedReader;

public class Runner {
	static boolean isRoot;
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		DonorDAO user = new DonorDAO();
		Scanner input = new Scanner(System.in);
		System.out.println("Click 1 to login or 2 to signUp");
		int goIn = input.nextInt();
		boolean exit;
		while (goIn!=1 && goIn!=2)
			try {
				goIn = input.nextInt();
				if (goIn!=0 && goIn!=2)System.out.println("Invalid input.");
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter an integer.");
				input.nextLine();
		        continue;
			}
		input.nextLine();
		if (goIn==1) {
			System.out.println("Enter username: ");
		    String username = input.nextLine();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		    System.out.println("Enter your password:");
		    String password = reader.readLine();
		    if (username.equals("root")) isRoot=true;
			exit = !user.login(username, password);
		} else {
			//signUp()
			exit = !user.requestSignUpUserInfo(input);
		}
		if(!exit)System.out.println("Welcome to the Organ Trailer! (❁´◡`❁)");
	    while (!exit) {
	        System.out.println("Would you like to: ");
	        System.out.println("1. Delete Account");
	        System.out.println("2. Count your organs");
	        System.out.println("3. Change password");
	        System.out.println("4. Exit");
	        if(user.isRoot()) {
	        	System.out.println("5. Get all from DONORS database");
	        	System.out.println("6. Get all from ORGANS database");
	        }
	        if (!input.hasNext())
	        	input.next();
	        int choice = input.nextInt();
	        switch (choice) {
	            case 1:
	                // Handle account deletion
	                user.deleteAccount(input);
	                exit = true;
	                break;
	            case 2:
	                // Handle getting organ donation information
	                user.getOrgans();
	                break;
	            case 3:
	            	// Handle Changing Password
	            	user.changePassword(input);
	            	break;
	            case 4:
	            	// Bye
	            	System.out.println("Bye");
	                exit = true;
	                break;
	            case 5:
	            	user.getAll(input);
	            	break;
	            case 6:
	            	user.getAllOrgans(input);
	            	break;
	            default:
	                System.out.println("Invalid option.");
	        }
	    }
	    input.close();
	}
}