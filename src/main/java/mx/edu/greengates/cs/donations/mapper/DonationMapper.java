package mx.edu.greengates.cs.donations.mapper;

import mx.edu.greengates.cs.donations.model.Charity;
import mx.edu.greengates.cs.donations.model.Donation;
import mx.edu.greengates.cs.donations.model.Donor;
import mx.edu.greengates.cs.utils.DateUtils;

import java.time.format.DateTimeParseException;
import java.util.Date;

public class DonationMapper {

    public static Donation mapToDonation(String[] entry) {
        int id = Integer.parseInt(entry[0]);
        Donor donor = new Donor(entry[1], entry[2], entry[3], entry[4], entry[5]);
        Date date = null;
        try {
            date = DateUtils.convertFromStringToDate(entry[6], "MM/dd/yy");
        } catch (DateTimeParseException e) {
            try {
                date = DateUtils.convertFromStringToDate(entry[6], "MM/dd/yyyy");
            } catch (DateTimeParseException ex) {
                date = DateUtils.convertFromStringToDate(entry[6], "M/dd/yyyy");
            }
        }
        // Remove the dollar sign from the amount
        String amountWithoutSymbol = entry[7].substring(1);
        // Remove commas
        amountWithoutSymbol = amountWithoutSymbol.replace(",", "");
        double amount = Double.parseDouble(amountWithoutSymbol);
        Charity charity = new Charity(entry[8]);
        return new Donation(id, donor, charity, amount, date);
    }

    public static Donation mapToDonation(int id, Donor donor, Charity charity, double amount, Date date) {
        return new Donation(id, donor, charity, amount, date);
    }

    public static String mapToString(Donation donation) {
        return donation.getDonor() + " donated $" + donation.getAmount() + " to " + donation.getCharity();
    }

    public static Date mapToDate(Donation donation) {
        return donation.getDate();
    }

    public static Donor mapToDonor(Donation donation) {
        return donation.getDonor();
    }

    public static Charity mapToCharity(Donation donation) {
        return donation.getCharity();
    }

    public static double mapToAmount(Donation donation) {
        return donation.getAmount();
    }

    public static int mapToId(Donation donation) {
        return donation.getId();
    }
}
