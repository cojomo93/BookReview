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
        return testReviews;

    }

}
