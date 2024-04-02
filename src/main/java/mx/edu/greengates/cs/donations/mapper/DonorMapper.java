package mx.edu.greengates.cs.donations.mapper;

import mx.edu.greengates.cs.donations.model.Donor;

public class DonorMapper {

    public static Donor mapToDonor(String firstName, String lastName, String email, String address, String taxNumber) {
        return new Donor(firstName, lastName, email, address, taxNumber);
    }

    public static String mapToString(Donor donor) {
        return donor.getFirstName() + " " + donor.getLastName() + " (" + donor.getTaxNumber() + ")";
    }

    public static void mapToDonate(Donor donor, double amount) {
        donor.donate(amount);
    }

    public static double mapToTotalDonations(Donor donor) {
        return donor.getTotalDonations();
    }

    public static String mapToEmail(Donor donor) {
        return donor.getEmail();
    }

    public static String mapToAddress(Donor donor) {
        return donor.getAddress();
    }

    public static String mapToTaxNumber(Donor donor) {
        return donor.getTaxNumber();
    }

    public static String mapToFirstName(Donor donor) {
        return donor.getFirstName();
    }

    public static String mapToLastName(Donor donor) {
        return donor.getLastName();
    }

}
