package bookreviewapp;

import java.io.Serializable;

public class PersistentDataCollection implements Serializable {

    private UserList theUserList;
    private ReviewList theReviewList;

    public PersistentDataCollection() {
        if (theUserList == null) {
            theUserList = new UserList();
        }
        if (theReviewList == null) {
            theReviewList = new ReviewList();
        }
    }

    public UserList getuserList() {
        return theUserList;
    }

    public ReviewList getReviewList() {
        return theReviewList;
    }

}
