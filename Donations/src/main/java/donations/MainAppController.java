package donations;

//MainAppController.java

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MainAppController implements Initializable {
 @FXML
 private ListView<String> donorListView;

 @Override
 public void initialize(URL location, ResourceBundle resources) {
     // Initialize the donor list view with data from the database
     refreshDonorList();
 }

 private void refreshDonorList() {
     // Clear existing items in the list view
     donorListView.getItems().clear();

     // Fetch donor names from the database and populate the list view
     List<String> donorNames = DBHandler.getDonorNames();
     donorListView.getItems().addAll(donorNames);
 }

 @FXML
 private void addDonor() {
	    // Launch the DonorInputApp as a modal dialog
	    DonorInputApp donorInputApp = new DonorInputApp();
	    Stage donorInputDialogStage = new Stage();
	    try {
	    	donorInputDialogStage.initModality(Modality.APPLICATION_MODAL);
		    donorInputDialogStage.setOnHidden(event -> {
		        // After adding a new donor (when the dialog is closed), refresh the donor list
		        refreshDonorList();
		    });
		    donorInputApp.start(donorInputDialogStage);
	    } catch (IOException ioe) {
	    	ioe.printStackTrace();
	    }
 }
}
