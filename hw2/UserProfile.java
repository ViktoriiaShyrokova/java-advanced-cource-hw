package hw2;

public class UserProfile {

    private final int id;
    private String username;
    private String email;
    private int age;
    private boolean isVerified;

    public UserProfile(int id, String username, String email, int age) {
        this.id = id;
        setUsername(username);
        setEmail(email);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setUsername(String username) {
        if(username == null || username.length() < 3 || username.length() >20) throw new IllegalArgumentException("Username should be from 3 to 20 symbols");
        this.username = username;
    }

    public void setEmail(String email) {
        if(email == null || !email.contains("@")) throw new IllegalArgumentException("Email is not valid");
        this.email = email;
    }

    public void setAge(int age) {
        if(age < 14 || age > 120) throw  new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public void verify() {
        this.isVerified = true;
    }
}
