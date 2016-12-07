//User class does all of the writing
//Atif Hassan
//CSC 202
package classes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author atifm
 */
public final class User extends Person implements Serializable,Comparable {

    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String photo;

    /**
     * Stores login information
     */
    public User() {
    }
    
    /**
     * 
     * @param username
     * @param password 
     */
    public User(String username, String password){
        this.username= username;
        this.password = password;
    }
    
    /**
     * 
     *
     * @param firstName
     * @param lastName
     * @param ssn
     * @param dob
     * @param gender
     * @param username
     * @param email
     * @param phone
     * @param photo
     * @param password
     */
    public User(String firstName, String lastName, String ssn, LocalDate dob, String gender, String username, String email, String phone, String photo, String password) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setSSN(ssn);
        super.setDOB(dob);
        super.setGender(gender);
        this.username = username;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.phoneNumber = phone;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Name " + super.getFirstName() + " " + super.getLastName()
                + "\nDate of First: " + super.getDOB()
                + "\nGender: " + super.getGender()
                + "\nUsername: " + getUsername()
                + "\nE-mail: " + getEmail()
                + "\nPhone Number: " + getPhoneNumber()
                + "\nSSN: " + getSSN()
                + "\nPhoto Path: " + getPhoto()
                + "\nPassword: " + getPassword();
    }

    /**
     *
     * @param compare
     * @return
     */
    public boolean equals(User compare){
        return this.username.equals(compare.getUsername())&& this.password.equals(compare.getPassword());
    }
    @Override
    public int compareTo(Object compare) {
        return this.username.compareTo(((User)compare).getUsername());
    }
}
