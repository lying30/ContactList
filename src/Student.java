/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Lucas Ying
 * @version: 2022-2023
 */

public class Student extends Person{
    // TODO: Modify and complete this class
    private int grade;

    //This is the student constructor that uses super() to refer to instance variables in the extended class Person
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    // The toString method that is overrided to add the grade too.
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
