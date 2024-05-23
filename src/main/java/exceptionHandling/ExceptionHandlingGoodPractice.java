package exceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandlingGoodPractice {

    private static final Logger logger = Logger.getLogger(ExceptionHandlingGoodPractice.class.getName());

    public static void main(String[] args) {
        try {
            readFile("example.txt");
            executeDatabaseQuery("INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')");
            performGenericOperation();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to read file", e);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error occurred", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error", e);
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
        throw new Exception("An unexpected error occurred during a generic operation");
    }

}
