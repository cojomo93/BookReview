package bookreviewapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField textField;
//    @FXML
//    private ObservableMap<Integer, Review> mapOfReviews;

    public ReviewListUICntl() {
        this.TextColumn = new TableColumn<>("Text");
        this.RatingColumn = new TableColumn<>("Rating");
        this.ISBNColumn = new TableColumn<>("ISBN");
        this.AuthorColumn = new TableColumn<>("Author");
        this.TitleColumn = new TableColumn<>("Title");
        this.reviewTable = new TableView<>();
        this.textField = new TextField();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();
        //mapOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();

        // Set up the table columns and link them to the table data fields
        TitleColumn.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewTitle"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewAuthor"));
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewISBN"));
        RatingColumn.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewRating"));
        TextColumn.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewText"));


        reviewTable.setItems(listOfReviews);
       //reviewTable.setItems((ObservableList<Review>) mapOfReviews);
       

        FilteredList<Review> flReview = new FilteredList(listOfReviews, p -> true);//Pass the data to a filtered list
      // FilteredList<Review> flReview = new FilteredList(mapOfReviews, p -> true);
       
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            flReview.setPredicate(review -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (review.getReviewTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (review.getReviewAuthor().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (review.getReviewISBN().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (review.getReviewRating().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });

            SortedList<Review> sortedData = new SortedList<>(flReview);
            sortedData.comparatorProperty().bind(reviewTable.comparatorProperty());
            reviewTable.setItems(sortedData);

           
        });

    }

    @FXML
    protected void handleAddReviewButtonAction(ActionEvent event) {
        System.out.println("I clicked Add Review");
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
