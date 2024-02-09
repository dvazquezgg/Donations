package donations;

import java.util.Date;

// Donor class
public class Donor {
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String emailAddress;

    // Constructor
    public Donor(String firstName, String lastName, String mobilePhone, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.emailAddress = emailAddress;
    }

    // Getters and setters (you may generate these methods based on your IDE)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
