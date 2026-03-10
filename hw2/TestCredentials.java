package hw2;

public final class TestCredentials {

    private final String login;
    private final String password;
    private final String role;

    public TestCredentials(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public TestCredentials withRole(String newRole) {
        return new TestCredentials(this.login,this.password,newRole);
    }

    @Override
    public String toString() {
        return "TestCredentials{" +
                "login='" + login  +
                ", role='" + role +
                '}';
    }
}
