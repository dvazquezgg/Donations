package mx.edu.greengates.cs.donations.model;

import java.util.ArrayList;

public class Charity {

    private String name;

    private double balance;

    private int donationCount;

    public Charity(String name) {
        this.name = name;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        balance += amount;
        donationCount++;
    }

    public void withdraw(double amount) {
        balance -= amount;
        donationCount--;
    }

    public double getBalance() {
        return balance;
    }

    public int getDonationCount() {
        return donationCount;
    }
    public void setDonationCount(int donationCount) {
        this.donationCount = donationCount;
    }

    @Override
    public String toString() {
        return name + " has a balance of $" + balance;
    }
}
