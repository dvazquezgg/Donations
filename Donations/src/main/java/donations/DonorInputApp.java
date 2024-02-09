package donations;

//DonorInputApp.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DonorInputApp extends Application {
 @Override
 public void start(Stage primaryStage) throws IOException {

     
     Parent root = FXMLLoader.load(getClass().getResource("DonorInput.fxml"));

     Scene scene = new Scene(root, 400, 300);

     primaryStage.setTitle("Donor Information Input");
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 public void showDonorInputDialog() {
     Stage stage = new Stage();
     try {
         start(stage);
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 public static void main(String[] args) {
     launch(args);
 }
}
