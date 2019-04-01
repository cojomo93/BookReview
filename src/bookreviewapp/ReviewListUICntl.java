package bookreviewapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReviewListUICntl implements Initializable {

    @FXML
    private Text actiontarget;
    @FXML
    private TableView<Review> reviewTable;
    @FXML
    private TableColumn<Review, String> TitleColumn;
    @FXML
    private TableColumn<Review, String> AuthorColumn;
    @FXML
    private TableColumn<Review, String> ISBNColumn;
    @FXML
    private TableColumn<Review, String> RatingColumn;
    @FXML
    private TableColumn<Review, String> TextColumn;
    @FXML
    private ObservableList<Review> listOfReviews;

    public ReviewListUICntl() {
        this.TextColumn = new TableColumn<>("Text");
        this.RatingColumn = new TableColumn<>("Rating");
        this.ISBNColumn = new TableColumn<>("ISBN");
        this.AuthorColumn = new TableColumn<>("Author");
        this.TitleColumn = new TableColumn<>("Title");
        this.reviewTable = new TableView<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();

        // Set up the table columns and link them to the table data fields
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("reviewTitle"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("reviewAuthor"));
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("reviewISBN"));
        RatingColumn.setCellValueFactory(new PropertyValueFactory<>("reviewRating"));
        TextColumn.setCellValueFactory(new PropertyValueFactory<>("reviewText"));

        // Add the data to the table
        reviewTable.setItems(listOfReviews);
    }

    @FXML
    protected void handleAddReviewButtonAction(ActionEvent event) {
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();
        ReviewListCntl.getReviewListCntl(stage).getAddReviewCntl(stage);

    }

    @FXML
    protected void handleReviewCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();
        NavigationCntl.getNavigationCntl(stage).setUpNavigationScene();
    }
}
