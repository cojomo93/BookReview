package bookreviewapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class ReviewListUICntl implements Initializable {

    @FXML
    private Text actiontarget;
    @FXML
    private ChoiceBox<String> searchChoice;
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
        this.searchChoice = new ChoiceBox();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reviewTable.setEditable(true);

        // Get the data for the table
        listOfReviews = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReviewList().getReviewData();

        // Set up the table columns and link them to the table data fields
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("reviewTitle"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("reviewAuthor"));
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("reviewISBN"));
        RatingColumn.setCellValueFactory(new PropertyValueFactory<>("reviewRating"));
        TextColumn.setCellValueFactory(new PropertyValueFactory<>("reviewText"));

        // Add the data to the table
        //reviewTable.setItems(listOfReviews);
        FilteredList<Review> flReview = new FilteredList(listOfReviews, p -> true);//Pass the data to a filtered list
        reviewTable.setItems(flReview);//Set the table's items using the filtered list
        reviewTable.getColumns().addAll(TitleColumn, AuthorColumn, ISBNColumn, RatingColumn, TextColumn);

        searchChoice.getItems().addAll("Title", "Author", "ISBN", "Rating");
        searchChoice.setValue("Title");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.setOnKeyReleased(keyEvent
                -> {
            switch (searchChoice.getValue())//Switch on choiceBox value
            {
                case "Title":
                    flReview.setPredicate(p -> p.getReviewTitle().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Author":
                    flReview.setPredicate(p -> p.getReviewAuthor().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "ISBN":
                    flReview.setPredicate(p -> p.getReviewISBN().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                case "Rating":
                    flReview.setPredicate(p -> p.getReviewRating().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;

            }
        });

        searchChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
                flReview.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
            }
        });
        HBox hBox = new HBox(searchChoice, textField);//Add choiceBox and textField to hBox
        hBox.setAlignment(Pos.CENTER);//Center HBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( hBox);

        //     ((Group) scene.getRoot()).getChildren().addAll(vbox);
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

    @FXML
    protected void handleSearchButtonAction(ActionEvent event) {
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();

        SearchCntl.getSearchCntl(stage);
        //ReviewListCntl.getReviewListCntl(stage).getAddReviewCntl(stage);

    }
}
