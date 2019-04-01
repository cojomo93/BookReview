package bookreviewapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NavigationUICntl {

    @FXML
    private Text actiontarget;

    @FXML
    protected void handleExitButtonAction(ActionEvent event) {
        actiontarget.setText("Exit button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        NavigationCntl.getNavigationCntl(theStage).exit();
    }

    @FXML
    protected void handleSetReminderButtonAction(ActionEvent event) {
        Stage stage = (Stage) actiontarget.getScene().getWindow();
        stage.hide();
        NavigationCntl.getNavigationCntl(stage).getReviewListCntl(stage);
    }

}
