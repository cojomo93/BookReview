package bookreviewapp;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName = new String();
    private String lastName = new String();
    private String username = new String();
    private String password = new String();

    public User(String newFirstName, String newLastName, String newUsername, String newPassword) {
        firstName = newFirstName;
        lastName = newLastName;
        username = newUsername;
        password = newPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String newUsername) {
        username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }
}
