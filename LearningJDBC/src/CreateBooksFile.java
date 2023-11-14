import java.io.FileWriter;
import java.io.IOException;

public class CreateBooksFile {

    public static void main(String[] args) {
        final String filePath = "books.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("The Lord of the Rings,J.R.R. Tolkien,1954,Fantasy,978-0-395-08252-6\n");
            writer.write("The Hobbit,J.R.R. Tolkien,1937,Fantasy,978-0-04-000231-9\n");
            writer.write("Pride and Prejudice,Jane Austen,1813,Romance,978-0-19-282315-9\n");
            writer.write("Harry Potter and the Sorcerer's Stone,J.K. Rowling,1997,Fantasy,978-0-590-35260-1\n");
            writer.write("To Kill a Mockingbird,Harper Lee,1960,Southern Gothic,978-0-8129-7037-4\n");
            writer.write("1984,George Orwell,1949,Dystopian,978-0-14-016726-2\n");
            writer.write("Animal Farm,George Orwell,1945,Satire,978-0-15-133166-3\n");
            writer.write("The Great Gatsby,F. Scott Fitzgerald,1925,American Novel,978-0-15-668550-6\n");
            writer.write("The Catcher in the Rye,J.D. Salinger,1951,Coming-of-Age,978-0-312-54078-9\n");
            writer.write("Invisible Man,Ralph Ellison,1952,Bildungsroman,978-0-679-72491-0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
