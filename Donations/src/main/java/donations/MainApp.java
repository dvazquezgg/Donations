package donations;

//MainApp.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
 @Override
 public void start(Stage primaryStage) throws IOException {
	 // Create the database if it doesn't exist
     DBHandler.createDatabase();
     
     Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));

     Scene scene = new Scene(root, 400, 300);

     primaryStage.setTitle("Donor Management System");
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 public static void main(String[] args) {
     launch(args);
 }
}
