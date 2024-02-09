/**
 * 
 */
package donations;

import java.util.Date;

//Donation class
public class Donation {
 private Donor donor;
 private Charity charity;
 private double amount;
 private Date date;
 private String instructions;

 // Constructor
 public Donation(Donor donor, Charity charity, double amount, Date date, String instructions) {
     this.donor = donor;
     this.charity = charity;
     this.amount = amount;
     this.date = date;
     this.instructions = instructions;
 }

 // Getters and setters
 // ...

 // Additional methods as needed
}