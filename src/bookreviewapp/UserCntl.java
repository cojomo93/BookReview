package bookreviewapp;

import javafx.collections.ObservableList;

public class UserCntl {

    private static UserCntl theUserCntl;
    private final ObservableList<User> theListOfUsers;

    UserCntl() {
        theListOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
    }

    public static UserCntl getUserCntl() {
        if (theUserCntl != null) {
            return theUserCntl;
        } else {
            theUserCntl = new UserCntl();
            return theUserCntl;
        }
    }

    public void addUserRow(User newUser) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData().add(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public ObservableList<User> getListOfUsers() {
        return theListOfUsers;
    }
}
