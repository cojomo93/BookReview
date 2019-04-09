package bookreviewapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReviewList implements Serializable {

    private final ArrayList<Review> theListOfReviews;

    public ReviewList() {
        theListOfReviews = getReviews();
    }

    public ObservableList<Review> getReviewData() {
        ObservableList<Review> listOfReviews;
        List<Review> reviewsList = (List<Review>) this.theListOfReviews;
        listOfReviews = FXCollections.observableList(reviewsList);
        return listOfReviews;
    }

    private ArrayList<Review> getReviews() {
        ArrayList<Review> testReviews = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Review newReview = new Review("Title " + i, "author", "978-3-16-148410-0", "4", "No text");

            testReviews.add(newReview);
        }
        Review newReview1 = new Review("Red Badge of Courage ", "Stephen Crane", "978-1514649008", "3", "Fantastic book!");
        Review newReview2 = new Review("To Kill a Mockingbird ", "Harper Lee", "978-0060935467", "5", "A classic!");
        testReviews.add(newReview1);
        testReviews.add(newReview2);
        return testReviews;

    }

}
