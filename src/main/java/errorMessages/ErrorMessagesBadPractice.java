package errorMessages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ErrorMessagesBadPractice {

    public static void main(String[] args) {
        try {
            readFile("example.txt");
            executeDatabaseQuery("INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')");
            performGenericOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void executeDatabaseQuery(String query) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    private static void performGenericOperation() throws Exception {
        throw new Exception("Generic error.");
    }

}
