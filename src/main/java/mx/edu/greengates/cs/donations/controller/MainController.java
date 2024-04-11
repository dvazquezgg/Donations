package mx.edu.greengates.cs.donations.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.util.Callback;
import mx.edu.greengates.cs.donations.Main;
import mx.edu.greengates.cs.donations.mapper.DonorMapper;
import mx.edu.greengates.cs.donations.model.Donation;
import mx.edu.greengates.cs.donations.model.Donor;
import mx.edu.greengates.cs.donations.model.Charity;
import mx.edu.greengates.cs.utils.Validation;

import java.util.ArrayList;

public class MainController {

    @FXML
    private ListView<String> lvDonations;

    @FXML
    private Button btnCreateReceipts;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtTaxNumber;

    @FXML
    private Button btnAddDonor;

    @FXML
    private Button btnClearDonor;

    @FXML
    private ChoiceBox<Donor> selectDonor;
    @FXML
    private ChoiceBox<Charity> selectCharity;

    private ObservableList<Donor> donorList = FXCollections.observableArrayList();
    private ObservableList<Charity> charityList = FXCollections.observableArrayList();

    @FXML
    private void addDonorButton() {
        System.out.println("Add Donor");
        if (Validation.empty(txtFirstName)) return;
        if (Validation.empty(txtLastName)) return;
        if (Validation.emptyOrNonEmail(txtEmail)) return;
        if (Validation.empty(txtAddress)) return;
        if (Validation.emptyOrNonPattern(txtTaxNumber, "^\\d{2}-\\d{3}-\\d{4}$")) return;
        Donor donor = DonorMapper.mapToDonor(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtAddress.getText(), txtTaxNumber.getText());
        System.out.println(DonorMapper.mapToString(donor));
        Main.addDonor(donor);
        Main.printDonors();
        donorList.add(donor);
    }

    @FXML
    private void clearDonorButton() {
        System.out.println("Clear Donor");
        txtFirstName.clear();
        txtLastName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtTaxNumber.clear();
    }

    @FXML
    private void createReceiptsButton() {
        System.out.println("Create Receipts");
        Main.printDonations();
    }

    public void initialize() {
        // Sample data: replace this with your actual ArrayList
        ArrayList<Donation> donations = Main.getDonations();

        ArrayList<String> itemList = new ArrayList<>(); // Create an ArrayList
        for (Donation donation : donations) {
            itemList.add(donation.toString());
        }
        // Create an ObservableList from the ArrayList
        lvDonations.getItems().addAll(itemList);

        // Customize how each item is displayed
        lvDonations.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                        }
                    }
                };
            }
        });

        // Assuming you have access to the donations, donors, and charities ArrayLists
        donorList.addAll(Main.getDonors());
        selectDonor.setItems(donorList);

        charityList.addAll(Main.getCharities());
        selectCharity.setItems(charityList);
    }

}
