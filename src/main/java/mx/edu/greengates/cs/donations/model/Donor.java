package mx.edu.greengates.cs.donations.model;

public class Donor {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String taxNumber;

    private double totalDonations;

    public Donor(String firstName, String lastName, String email, String address, String taxNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.taxNumber = taxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public double getTotalDonations() {
        return totalDonations;
    }

    public void donate(double amount) {
        totalDonations += amount;
    }

    public String toString() {
        return firstName + " " + lastName + " (" + taxNumber + ")";
    }

}
