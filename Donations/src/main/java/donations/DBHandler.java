package donations;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHandler {
    private static final String JDBC_URL = "jdbc:sqlite:donor_database.db";

    public static void createDatabase() {
    	
        File databaseFile = new File("donor_database.db");

        if (databaseFile.exists()) {
            System.out.println("Database already exists.");
            return; // Database already exists, no need to create it again
        }
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {

            // Create Donor table
            String createDonorTable = "CREATE TABLE IF NOT EXISTS donor (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "first_name TEXT NOT NULL," +
                    "last_name TEXT NOT NULL," +
                    "mobile_phone TEXT NOT NULL," +
                    "email_address TEXT NOT NULL)";

            statement.executeUpdate(createDonorTable);

            System.out.println("Database and tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<String> getDonorNames() {
        List<String> donorNames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT first_name, last_name FROM donor");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                donorNames.add(firstName + " " + lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donorNames;
    }
}
