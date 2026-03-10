package hw2;

public class TestCredentialsMain {

    public static void main(String[] args) {

        TestCredentials adminCredentials = new TestCredentials("admin","qwerty","ADMIN");
        TestCredentials userCredentials = adminCredentials.withRole("USER");

        System.out.println(adminCredentials.getRole());
        System.out.println(userCredentials.getRole());
    }
}
