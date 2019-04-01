package bookreviewapp;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddReviewCntl {

    @FXML
    private final Stage stage;
    private static AddReviewCntl theAddReviewCntl;
    private final ObservableList<Review> theListOfReviews;

    private AddReviewCntl(Stage theExistingStage) {
        theListOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();
        stage = theExistingStage;
        this.setUpAddReviewScene();
        stage.show();
    }

    public static AddReviewCntl getAddReviewCntl(Stage stage) {
        if (theAddReviewCntl != null) {
            return theAddReviewCntl;
        } else {
            theAddReviewCntl = new AddReviewCntl(stage);
            return theAddReviewCntl;
        }
    }

    private void setUpAddReviewScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("AddReviewUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Add Review");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error:");
        }
    }

    public ObservableList<Review> getListOfReviews() {
        return theListOfReviews;
    }

    public void addReviewsAdded(Review review) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData().add(review);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }
}
