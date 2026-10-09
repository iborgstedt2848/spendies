import java.util.List;

public class User {
    private Credentials credentials;
    private List<String> friends;
    private Dashboard dashboard;

    public User(Credentials credentials, List<String> friends, Dashboard dashboard) {
        this.credentials = credentials;
        this.friends = friends;
        this.dashboard = dashboard;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public List<String> getFriends() {
        return friends;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void addFriend(String user) {
        friends.add(user);
    }

    public void removeFriend(String user) {
        friends.remove(user);
    }
}
