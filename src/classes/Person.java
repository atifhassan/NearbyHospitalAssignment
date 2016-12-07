//Simple class to set and get info
//Atif Hassan
//CSC 202
package classes;

/**
 *
 * @author atifm
 */
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author atifm
 */
public class Person  implements Serializable{

    private String firstName;
    private String lastName;
    private String ssn;
    private LocalDate dob;
    private String gender;

    /**
     * This class is super class for User class
     */
    public Person() {

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param ssn
     * @param dob
     * @param gender
     */
    public Person(String firstName, String lastName, String ssn, LocalDate dob, String gender) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public String getSSN() {
        return ssn;
    }

    /**
     *
     * @return
     */
    public LocalDate getDOB() {
        return dob;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param ssn
     */
    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    /**
     *
     * @param dob
     */
    public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
