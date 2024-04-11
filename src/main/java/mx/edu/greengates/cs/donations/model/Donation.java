package mx.edu.greengates.cs.donations.model;

import mx.edu.greengates.cs.utils.DateUtils;

import java.util.Date;

public class Donation {

    private int id; // default value is 0
    private Donor donor;
    private Charity charity;
    private double amount;
    private Date date;

    public Donation(Donor donor, Charity charity, double amount) {
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
        date = new Date();
    }

    public  Donation(int id, Donor donor, Charity charity, double amount, Date date) {
        this.id = id;
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }

    public Donor getDonor() {
        return donor;
    }

    public Charity getCharity() {
        return charity;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return donor + " donated $" + amount + " in " + DateUtils.convertFromDateToString(date) + " to " + charity;
    }
}
