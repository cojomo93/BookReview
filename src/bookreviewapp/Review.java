package bookreviewapp;

import java.io.Serializable;

public class Review implements Serializable {

    public final String reviewTitle;
    public final String reviewAuthor;
    public final String reviewISBN;
    public final String reviewRating;
    public final String reviewText;

    public Review(String reviewTitle, String reviewAuthor, String reviewISBN, String reviewRating, String reviewText) {

        this.reviewTitle = reviewTitle;
        this.reviewAuthor = reviewAuthor;
        this.reviewISBN = reviewISBN;
        this.reviewRating = reviewRating;
        this.reviewText = reviewText;

    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public String getReviewISBN() {
        return reviewISBN;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getReviewRating() {
        return reviewRating;
    }

}
