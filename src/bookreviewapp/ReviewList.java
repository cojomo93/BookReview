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
        Collection<Review> values = mapReviews.values();
        ArrayList<Review> testReviews = new ArrayList<Review>(values);

        Review newReview1 = new Review("Red Badge of Courage ", "Stephen Crane", "978-1514649008", "3", "Fantastic book!");
        Review newReview2 = new Review("To Kill a Mockingbird ", "Harper Lee", "978-0060935467", "5", "A classic!");
        Review newReview3 = new Review("Of Mice and Men To ", "John Steinbeck", "978-0140177398", "4", "I guess I never realized how much writing technique has changed over the years. This book make me understand the difference between then and now.");
        Review newReview4 = new Review("Lord of the Flies ", "William Golding", "978-0399501487", "3", "In my quest to read the greatest American horror stories of all time, I'm so elated to say I've finally reached Lord of the Flies. Oh my, what an epic story in great proportions! I think what scared me the most about this story are the parallels between the timeline in the story and our time we're living right now.");
        Review newReview5 = new Review("Adventures of Huckleberry Finn  ", "Mark Twain", "978-1503214958", "5", " It is not just an adventure of two boys... but also a social and political commentary on slavery. Now I truly appreciate the significance and genius of Mark Twain.");
        Review newReview6 = new Review("A Tale of Two Cities ", "Charles Dickens", "978-0486406510", "1", "I was not a fan of this classic book");
        Review newReview7 = new Review("Hamlet ", "William Shakespeare", "978-0743477123", "5", "My favorite play of all time!");
        Review newReview8 = new Review("Moby Dick ", "Herman Melville", "978-1853260087", "2", "Tried to read but just couldn't plow through all the extraneous material. I guess Melville thought all of the detail he added important and at the time of the books writing, in may well have been. For me, most of it was endless verbiage that added nothing to the story. ");
        Review newReview9 = new Review("And Then There Were None ", "Agatha Christie Lee", "978-0062073488", "4", "Very, very clever! So clever that I may read it again some day even though I know the ending, or actually BECAUSE I know the ending and want to read once again how Agatha Christie adroitly executed the plot. Well written and enjoyable.");
        Review newReview10 = new Review("Alice in Wonderland: Alice's Adventures in Wonderland and Through the Looking Glass ", "Lewis Carroll", "978-1631582752", "5", "This is incredible! Absolutely beautiful.. Extended my expectations!! I have seriously never seen a more beautiful book! The detail is awesome and even the story itself is from the original Lewis Carroll version. Not only is each page a beautiful pop up.. But each page has mini fold out pages with more pop up artwork. ");
        Review newReview11 = new Review("The Lion, the Witch and the Wardrobe ", "C. S. Lewis", "978-0064404990", "1", "Love the story but half of the pages are not printed correctly. The ink is too light to read.");
        Review newReview12 = new Review("The Da Vinci Code ", "Dan Brown", "978-0307474278", "3", "I wasn't going to read this book because I had heard so many really bad things about it. What most of the people who have commented on it don't seem to understand that it is FICTION!");
        Review newReview13 = new Review("Harry Potter and the Chamber of Secrets ", "J. K. Rowling", "978-0439064873", "5", "My favorite book of all time!");
        Review newReview14 = new Review("The Adventures of Sherlock Holmes ", " Sir Arthur Conan Doyle", "978-1607102113", "4", "Of the novels, The Hound of the Baskerville is the best, but this runs a close second. It contains many of the passages which gave us the clearest idea of Holmes - who finds emotion clouds the mind, and 'cannot congratulate' Watson on his marriage for that reason. ");
        Review newReview15 = new Review("20,000 Leagues Under the Sea ", "Jules Verne", "978-1853260315", "3", "This story did not captivate me nearly as much as other Jules Verne novels. I think I preferred the third person narration and humor of Around the World in 80 Days. I expected more of that humor and feeling of adventure from this novel as well. ");
        Review newReview16 = new Review("Le Petit Prince ", "Antoine de Saint-Exupéry", "978-0156013987", "4", "This was a simple, yet profound, allegorical classic… one that can be enjoyed from the ages of 9 to 99, as it can be interpreted on so many different levels. On a very basic level, it allows the reader to reflect on what is truly important in life, “what is essential, is invisible to the eye.” It can also be interpreted by an older audience as a war fable, having political symbolism.");
        Review newReview17 = new Review("Charlotte's Web ", "E. B. White", "978-0061124952", "1", "Horrible digital download. Misspelled words, chapters inserted in the middle of paragraphs, just a complete mess. Can’t even read it to my daughter. Very disappointed.");
        Review newReview18 = new Review("The Very Hungry Caterpillar ", "Eric Carle", "978-0399226908", "5", "My five-year-old twins LOVE books (something that makes this bibliophile ecstatic!) and I'm always looking for cute new books they would like to read. I saw this one just before Valentine's Day and thought it would be a cute book to read on Valentine's Day.");
        Review newReview19 = new Review("Gone With the Wind ", "Margaret Mitchell", "978-0684830681", "3", "I have read this book many times. I have worn out 2 or 3 copies. Finally bought a digital version and it's kind of disappointing. The transcription leaves a bit to be desired. There are misspelling and punctuation errors.");
        Review newReview20 = new Review("The Great Gatsby ", "F. Scott Fitgerald", "978-0743273565", "4", "This is the second time I've read this book and it's gone up a full two stars in my estimation. It's about ten years since my first reading and I can't remember why I didn't like it back then, but it may have had something to do with the fact that it's quite a depressing story.");
        Review newReview21 = new Review("The Hunger Games ", "Suzanne Collins", "978-0439023528", "2", "Okay, I'm in my 50s so maybe I'm not the best one to review a book series classified as \"YA.\" But these stories have been spoken of as \"new classics,\" and classics should be accessible to any age, which I figure entitles me to an opinion. Overall story--a cross between old Roman gladiator games and new dystopian future reality shows. And the sad thing is, it doesn't seem that far in the future, or that big a step from where we are now in reality television.");
        Review newReview22 = new Review("Animal Farm ", "George Orwell", "9780451526342", "5", "Animal Farm is a prescient reflection on politics - and the perennial gap between well-meaning aspirations, and the reality of their pursuit.");
        Review newReview23 = new Review("The Jungle ", "Upton Sinclair", "978-1503331860", "5", "Such a great book");

        mapReviews.put(1, newReview1);
        mapReviews.put(2, newReview2);
        mapReviews.put(3, newReview3);
        mapReviews.put(4, newReview4);
        mapReviews.put(5, newReview5);
        mapReviews.put(6, newReview6);
        mapReviews.put(7, newReview7);
        mapReviews.put(8, newReview8);
        mapReviews.put(9, newReview9);
        mapReviews.put(10, newReview10);
        mapReviews.put(11, newReview11);
        mapReviews.put(12, newReview12);
        mapReviews.put(13, newReview13);
        mapReviews.put(14, newReview14);
        mapReviews.put(15, newReview15);
        mapReviews.put(16, newReview16);
        mapReviews.put(17, newReview17);
        mapReviews.put(18, newReview18);
        mapReviews.put(19, newReview19);
        mapReviews.put(20, newReview20);
        mapReviews.put(21, newReview21);
        mapReviews.put(22, newReview22);
        mapReviews.put(22, newReview23);

        for (Review value : testReviews) {
            System.out.println(value);
        }

        return testReviews;

    }

}
