package bookreviewapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReviewSet implements Serializable {

    private final ArrayList<Review> theListOfReviewsSet;

    public ReviewSet() {
        theListOfReviewsSet = getReviews();
        Set<Review> setReview = new HashSet<>(theListOfReviewsSet);
        setReview.addAll(theListOfReviewsSet);
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
