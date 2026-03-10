package hw2;

public class UserProfileMain {

    public static void main(String[] args) {
        try {
        UserProfile user1 = new UserProfile(1,"Joe","joe@gmail.com", 350);
        UserProfile user2 = new UserProfile(2,"Jack","jack@gmail.com", 70);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
