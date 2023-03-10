/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Lucas Ying
 * @version: 2022-2023
 */

public class Person {
    // TODO: Complete the Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //the toString method in the Person class
    @java.lang.Override
    public java.lang.String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
