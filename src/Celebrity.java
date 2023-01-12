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

    public Celebrity(String firstName, String lastName, String phoneNumber, int instaFollowers) {
        super(firstName, lastName, phoneNumber);
        this.instaFollowers = instaFollowers;
    }

    public int getInstaFollowers() {
        return instaFollowers;
    }

    @Override
    public String toString() {
        return super.toString() + instaFollowers;
    }
}
