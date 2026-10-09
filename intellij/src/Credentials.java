public class Credentials {
    private String username;
    private String password;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public void updateCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validateCredentials() {
        //TODO
    }

    public void signUp() {
        //TODO
    }

    public void logIn() {
        //TODO
    }
}
