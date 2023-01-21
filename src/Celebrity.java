/**
 * A subclass of Person that represents a Celebrity
 *
 * Created for Menlo School CS2
 *
 * @author: Lucas Ying
 * @version: 2022-2023
 */
public class Celebrity extends Person{
    private int instaFollowers;

    //The constructor extended from the person class using super().
    public Celebrity(String firstName, String lastName, String phoneNumber, int instaFollowers) {
        super(firstName, lastName, phoneNumber);
        this.instaFollowers = instaFollowers;
    }

    //Getter method for followers of celebrity.
    public int getInstaFollowers() {
        return instaFollowers;
    }
    //Override to add the number of instaFollowers in the toString methhod too.
    @Override
    public String toString() {
        return super.toString() + " Followers: " + instaFollowers;
    }
}
