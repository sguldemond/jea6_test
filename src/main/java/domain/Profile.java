package domain;

/**
 * Created by stasiuz on 16/02/2018.
 */
public class Profile {
    private String username;
    private String profilePicturePath;
    private String description;

    public Profile(String username, String description) {
        this.username = username;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }
}
