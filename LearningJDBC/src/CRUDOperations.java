import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class CRUDOperations {
	public static String createTable() {
		return "CREATE TABLE IF NOT EXISTS Books (\r\n"
				+ "  id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "  title VARCHAR(255) NOT NULL,\r\n"
				+ "  author VARCHAR(255) NOT NULL,\r\n"
				+ "  publication_year INT NOT NULL,\r\n"
				+ "  genre VARCHAR(255) NOT NULL,\r\n"
				+ "  ISBN VARCHAR(50) UNIQUE NOT NULL\r\n"
				+ ");\r\n"; 
	}
	public static String insert(int id,String title,String author,String year,String genre,String isbn) {
		return "INSERT INTO BOOKS VALUES "+id+"\""+title+"\""+"\""+author+"\""+"\""+year+"\""+"\""+genre+"\""+"\""+isbn+"\"";
	}
	public static void insertIntoBooks(Connection connection) throws SQLException, NumberFormatException, IOException {
		final String filePath = "books.txt";

        
            String insertStatement = "INSERT INTO Books (title, author, publication_year, genre, ISBN) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                preparedStatement.setString(1, values[0].trim());
                preparedStatement.setString(2, values[1].trim());
                preparedStatement.setInt(3, Integer.parseInt(values[2].trim()));
                preparedStatement.setString(4, values[3].trim());
                preparedStatement.setString(5, values[4].trim());
                preparedStatement.executeUpdate();
            }

            reader.close();
            preparedStatement.close();

            System.out.println("Books inserted successfully from the file.");
    
	}
	public static String deleteFromBooks(int id, String title, String author, String year, String genre, String isbn) {
	    StringBuilder deleteStatement = new StringBuilder("DELETE FROM Books WHERE ");
	    boolean conditionAdded = false;

	    if (id != 0) {
	        deleteStatement.append("id = ").append(id);
	        conditionAdded = true;
	    }

	    if (title != null && !title.isEmpty()) {
	        if (conditionAdded) {
	            deleteStatement.append(" AND ");
	        }
	        deleteStatement.append("title = '").append(title).append("'");
	        conditionAdded = true;
	    }

	    if (author != null && !author.isEmpty()) {
	        if (conditionAdded) {
	            deleteStatement.append(" AND ");
	        }
	        deleteStatement.append("author = '").append(author).append("'");
	        conditionAdded = true;
	    }

	    if (year != null && !year.isEmpty()) {
	        if (conditionAdded) {
	            deleteStatement.append(" AND ");
	        }
	        deleteStatement.append("publication_year = ").append(year);
	        conditionAdded = true;
	    }

	    if (genre != null && !genre.isEmpty()) {
	        if (conditionAdded) {
	            deleteStatement.append(" AND ");
	        }
	        deleteStatement.append("genre = '").append(genre).append("'");
	        conditionAdded = true;
	    }

	    if (isbn != null && !isbn.isEmpty()) {
	        if (conditionAdded) {
	            deleteStatement.append(" AND ");
	        }
	        deleteStatement.append("ISBN = '").append(isbn).append("'");
	        conditionAdded = true;
	    }

	    return deleteStatement.toString();
	}
	public static String read() {
		return "Select * FROM BOOKS";
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/javaDebuggers";
		String myusername = "root";
		String mypassword = "MySQLInstallerRootAccountPassword123!@#";
		Connection connection = DriverManager.getConnection(url,myusername,mypassword);
		Statement statement = connection.createStatement();
		String query="";
		query = createTable();
		int exitStatus = statement.executeUpdate(query);
//		insertIntoBooks(connection);
		System.out.println(exitStatus);
		ResultSet resultSet = statement.executeQuery(read());
		Map<Integer,String> map = new HashMap<>();
		while (resultSet.next()) {
			String str = resultSet.getString("title")+" "+resultSet.getString("author")+" "+resultSet.getString("publication_year");
            map.put( resultSet.getInt("id"),str);
        }
		for (Map.Entry<Integer,String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
//
//        resultSet.close();
        statement.close();
        connection.close();
        
	}
}
//retain all
//integer classes
//poll last
//equals objects
