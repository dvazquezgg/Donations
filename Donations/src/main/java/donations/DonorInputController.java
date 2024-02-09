package donations;

//DonorInputController.java

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.stage.Stage;


public class DonorInputController {
 @FXML
 private TextField firstNameField;

 @FXML
 private TextField lastNameField;

 @FXML
 private TextField mobilePhoneField;

 @FXML
 private TextField emailAddressField;
 
 @FXML
 private Button addButton;

 @FXML
 private void submitDonorInfo() {
     String firstName = firstNameField.getText();
     String lastName = lastNameField.getText();
     String mobilePhone = mobilePhoneField.getText();
     String emailAddress = emailAddressField.getText();

     // Create a Donor object or perform actions with the donor information
     Donor donor = new Donor(firstName, lastName, mobilePhone, emailAddress);

     saveDonorToDatabase(donor);
     
     // Add logic to handle the donor information as needed
     System.out.println("Donor Information Submitted: " + donor.toString());
     closeStage();
 }
 
 private void saveDonorToDatabase(Donor donor) {
     String insertQuery = "INSERT INTO donor (first_name, last_name, mobile_phone, email_address) VALUES (?, ?, ?, ?)";

     try (Connection connection = DriverManager.getConnection("jdbc:sqlite:donor_database.db");
          PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

         preparedStatement.setString(1, donor.getFirstName());
         preparedStatement.setString(2, donor.getLastName());
         preparedStatement.setString(3, donor.getMobilePhone());
         preparedStatement.setString(4, donor.getEmailAddress());

         preparedStatement.executeUpdate();

         System.out.println("Donor information saved to the database.");

     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 
 private void closeStage() {
     // Get the current stage (window) and close it
     Stage stage = (Stage) addButton.getScene().getWindow();
     stage.close();
 }
 
}
