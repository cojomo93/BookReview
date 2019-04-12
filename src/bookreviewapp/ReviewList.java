package bookreviewapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
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
        Map<Integer, Review> mapReviews = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Review newReview = new Review("Title " + i, "author", "978-3-16-148410-0", "4", "No text");
            mapReviews.put(i, newReview);
        }
        Review newReview1 = new Review("Red Badge of Courage ", "Stephen Crane", "978-1514649008", "3", "Fantastic book!");
        Review newReview2 = new Review("To Kill a Mockingbird ", "Harper Lee", "978-0060935467", "5", "A classic!");
        mapReviews.put(11, newReview1);
        mapReviews.put(12, newReview2);

        Collection<Review> values = mapReviews.values();
        ArrayList<Review> testReviews = new ArrayList<Review>(values);

        for (Review value : testReviews) {
            System.out.println(value);
        }

        return testReviews;

    }

}
