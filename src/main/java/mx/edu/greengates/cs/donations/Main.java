package mx.edu.greengates.cs.donations;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import mx.edu.greengates.cs.donations.controller.MainController;
import mx.edu.greengates.cs.donations.mapper.DonationMapper;
import mx.edu.greengates.cs.donations.model.Charity;
import mx.edu.greengates.cs.donations.model.Donation;
import mx.edu.greengates.cs.donations.model.Donor;
import mx.edu.greengates.cs.utils.ReadCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static final String VERSION = "1.0.0";
    private static ArrayList<Donation> donations = new ArrayList<>();
    private static ArrayList<Donor> donors = new ArrayList<>();
    private static ArrayList<Charity> charities = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        // Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        stage.setTitle("Donations App v" + VERSION);
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        readFile();
        launch();
    }

    public static void addDonation(Donation donation){
        donations.add(donation);
    }

    public static void addDonor(Donor donor){
        donors.add(donor);
    }

    public static void addCharity(Charity charity){
        charities.add(charity);
    }

    public static void printDonations(){
        for(Donation donation : donations){
            System.out.println(donation);
        }
    }

    public static void printDonors(){
        for(Donor donor : donors){
            System.out.println(donor);
        }
    }

    public static void printCharities(){
        for(Charity charity : charities){
            System.out.println(charity);
        }
    }

    private static int findCharityIndex(Charity charity){
        for(int i = 0; i < charities.size(); i++){
            if(charities.get(i).equals(charity)){
                return i;
            }
        }
        return -1; // not found
    }

    public static ArrayList<Donation> getDonations(){
        return donations;
    }

    private static void readFile() {
        ReadCSV readCSV = new ReadCSV("Final.csv");
        readCSV.read();

        List<List<String>> records = readCSV.getRecords();
        int recordCount = 0;
        for (List<String> record : records) {
            System.out.println(record);
            // convert the List<String> to an array of Strings
            if(recordCount > 0){
                String[] recordArray = record.toArray(new String[record.size()]);
                Donation donation= DonationMapper.mapToDonation(recordArray);
                donations.add(donation);
            }
            recordCount++;
        }
        fillDonors();
        fillCharities();
    }

    private static void fillDonors(){
        for(Donation donation : donations){
            if(donors.contains(donation.getDonor())){
                continue;
            } else {
                donors.add(donation.getDonor());
            }
        }
    }

    private static void fillCharities(){
        for(Donation donation : donations){
            double amount = donation.getAmount();
            if(charities.contains(donation.getCharity())){
                int index = findCharityIndex(donation.getCharity());
                charities.get(index).deposit(amount);
            } else {
                donation.getCharity().deposit(amount);
                charities.add(donation.getCharity());
            }
        }
    }
}