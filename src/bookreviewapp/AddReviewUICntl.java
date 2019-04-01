package bookreviewapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddReviewUICntl implements Initializable {

    ObservableList<String> reviewRatingList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    @FXML
    private Text actiontarget;
    @FXML
    private TextField reviewTitle;
    @FXML
    private TextField reviewAuthor;
    @FXML
    private TextField reviewISBN;
    @FXML
    private ChoiceBox<String> reviewRating;
    @FXML
    private TextArea reviewText;
    @FXML
    private final TableView<Review> reviewTable = new TableView<Review>();
    @FXML
    private ObservableList<Review> listOfReviews;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reviewRating.setValue(reviewRatingList.get(0));
        reviewRating.setItems(reviewRatingList);
    }

    @FXML
    protected void handleCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();
        NavigationCntl.getNavigationCntl(stage).getReviewListCntl(stage);
    }

    @FXML
    protected void handleSaveButtonAction(ActionEvent event) {
        Review review = new Review(reviewTitle.getText(), reviewAuthor.getText(), reviewISBN.getText(), reviewRating.getValue(), reviewText.getText());
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();

        AddReviewCntl.getAddReviewCntl(stage).addReviewsAdded(review);
        NavigationCntl.getNavigationCntl(stage).getReviewListCntl(stage);
        listOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();
        reviewTable.setItems(listOfReviews);

    }

}
