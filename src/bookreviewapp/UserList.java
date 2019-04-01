package bookreviewapp;

import javafx.collections.*;
import java.io.*;
import java.util.*;

public class UserList implements Serializable {

    private ArrayList<User> theListOfUsersAL;

    public UserList() {
        theListOfUsersAL = getUserList();
    }

    public ObservableList<User> getUserData() {
        ObservableList<User> theListOfUsers;
        List<User> userList = (List<User>) theListOfUsersAL;
        theListOfUsers = FXCollections.observableList(userList);
        return theListOfUsers;
    }

    private ArrayList<User> getUserList() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add((new User("John", "Doe", "johndoe", "12345")));
        userList.add((new User("Jane", "Deere", "janedeere", "abcde")));
        userList.add((new User("Sam", "Spade", "samspade", "password")));
        return userList;
    }
}
