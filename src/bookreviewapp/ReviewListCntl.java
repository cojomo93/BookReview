package bookreviewapp;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReviewListCntl {

    @FXML
    private final Stage stage;
    private static ReviewListCntl theReviewListCntl;
    private final ObservableList<Review> theListOfReviews;

    private ReviewListCntl(Stage theExistingStage) {
        theListOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();
        stage = theExistingStage;
        this.setUpReviewListScene();
        stage.show();
    }

    public static ReviewListCntl getReviewListCntl(Stage stage) {
        theReviewListCntl = new ReviewListCntl(stage);
        return theReviewListCntl;
    }

    private void setUpReviewListScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("ReviewListUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Review List");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void getAddReviewCntl(Stage theStage) {
        AddReviewCntl.getAddReviewCntl(theStage);
    }

    public ObservableList<Review> getListOfReviews() {
        return theListOfReviews;
    }

}
