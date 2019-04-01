package bookreviewapp;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class NavigationCntl {

    @FXML
    private final Stage stage;
    @FXML
    private Text actiontarget;
    private static NavigationCntl theNavigationCntl;

    private NavigationCntl(Stage theExistingStage) {
        stage = theExistingStage;
        this.setUpNavigationScene();
        stage.show();
    }

    public static NavigationCntl getNavigationCntl(Stage theStage) {
        if (theNavigationCntl != null) {
            return theNavigationCntl;
        } else {
            theNavigationCntl = new NavigationCntl(theStage);
            return theNavigationCntl;
        }
    }

    @FXML
    public void setUpNavigationScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("NavigationUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Navigation");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void getUserCntl() {
        UserCntl.getUserCntl();
    }

    public void getReviewListCntl(Stage theStage) {
        ReviewListCntl.getReviewListCntl(theStage);
    }

    public void exit() {
        System.exit(0);
    }
}
