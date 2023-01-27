import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor

    public ContactList() {
        this.contacts = new ArrayList<Person>();
        this.contacts.add(new Student("a", "z", "123", 10));
        this.contacts.add(new Student("b", "y", "567", 10));
        this.contacts.add(new Student("c", "x", "234", 10));
        this.contacts.add(new Student("d", "w", "987", 10));
        this.contacts.add(new Celebrity("z", "y", "3", 3));
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Celebrity");
        int number = scanner.nextInt();
        // if they choose to add a student contact
        if(number == 1){
            scanner.nextLine();
            System.out.println("Please fill in the following information.");
            System.out.println("First Name:");
            String firstName = scanner.nextLine();
            System.out.println("Last Name:");
            String lastName = scanner.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Grade:");
            int grade = scanner.nextInt();
            scanner.nextLine();

            Student student = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(student);

        }
        //if they choose to add a celebrity contact
        else if(number == 2){
            scanner.nextLine();
            System.out.println("Please fill in the following information.");
            System.out.println("First Name:");
            String firstName = scanner.nextLine();
            System.out.println("Last Name:");
            String lastName = scanner.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Instagram Followers:");
            int followers = scanner.nextInt();
            scanner.nextLine();
            Celebrity celebrity = new Celebrity(firstName, lastName, phoneNumber, followers);
            contacts.add(celebrity);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int n = contacts.size();
        //bubble sort for loop algorithm
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++){
                //if sort by equals 0 sort by first name
                if(sortBy == 0){
                    //assign current and next object to variables
                    String s1 = contacts.get(j).getFirstName();
                    String s2 = contacts.get(j+1).getFirstName();
                    //compare
                    int result = s1.compareTo(s2);

                    //if the first string comes after the second string, its swapped
                    if(result>0){
                        contacts.add(j+2, contacts.get(j));
                        contacts.remove(j);
                    }
                }
                //if sort by last name
                else if(sortBy == 1){
                    //assign current and next object to variables
                    String s1 = contacts.get(j).getLastName();
                    String s2 = contacts.get(j+1).getLastName();
                    //compare
                    int result = s1.compareTo(s2);

                    //if the first string comes after the second string, it s swapped
                    if(result>0){
                        contacts.add(j+2, contacts.get(j));
                        contacts.remove(j);
                    }
                }
                // if sort by phone number
                else{
                    String s1 = contacts.get(j).getPhoneNumber();
                    String s2 = contacts.get(j+1).getPhoneNumber();
                    int result = s1.compareTo(s2);

                    //if the first string comes after the second string, it s swapped
                    if(result>0){
                        contacts.add(j+2, contacts.get(j));
                        contacts.remove(j);
                    }
                }
            }
        }

    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName){
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getFirstName().equals(firstName)){
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName){
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getLastName().equals(lastName)){
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber){
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getPhoneNumber().equals(phoneNumber)){
                return contacts.get(i);
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i) instanceof Student)
            {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        while(input != 0){
            //adds a contact
            if(input == 1){
                addContact();
            }
            //prints by first name
            else if(input == 2){
                sort(0);
                printContacts();
            }
            //prints by last name
            else if(input == 3){
                sort(1);
                printContacts();
            }
            //prints contacts by phone number
            else if(input == 4){
                sort(2);
                printContacts();
            }
            //prints list of only students
            else if(input == 5){
                listStudents();
            }
            //allows input of first name to search for a contact
            else if(input == 6){
                System.out.println("Enter a first name:");
                String name = scanner.nextLine();
                Person result = searchByFirstName(name);
                if(result != null){
                    System.out.println(result);
                }
                else{
                    System.out.println(name + " is not in the list");
                }
            }
            else if(input == 7){
                System.out.println("Enter a last name:");
                String name = scanner.nextLine();
                Person result = searchByLastName(name);
                if(result != null){
                    System.out.println(result);
                }
                else{
                    System.out.println(name + " is not in the list");
                }

            }
            else if(input == 8){
                System.out.println("Enter a phone number:");
                String number = scanner.nextLine();
                Person result = searchByPhoneNumber(number);
                if(result != null){
                    System.out.println(result);
                }
                else{
                    System.out.println(number + " is not in the list");
                }

            }
            System.out.println();
            System.out.println();

            //ask for input again to stop forever loop
            printMenuOptions();
            input = scanner.nextInt();
            scanner.nextLine();
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
