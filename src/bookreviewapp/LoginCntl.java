package bookreviewapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginCntl {

    @FXML
    private Text actiontarget;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public LoginCntl() {
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
        String un = usernameField.getText();
        String pw = passwordField.getText();
        if (authenticate(un, pw)) {
            Stage stage = (Stage) actiontarget.getScene().getWindow();
            stage.hide();
            NavigationCntl theNavigationCntl = NavigationCntl.getNavigationCntl(stage);
        } else {
            usernameField.setText("");
            passwordField.setText("");
            actiontarget.setText("Invalid login");
        }
    }

    public boolean authenticate(String username, String password) {
        boolean authenticated = false;
        ObservableList<User> userList = UserCntl.getUserCntl().getListOfUsers();
        for (int a = 0; a < 3; a++) {
            if (username.equals(userList.get(a).getUsername()) && password.equals(userList.get(a).getPassword())) {
                authenticated = true;
            }
        }
        return authenticated;
    }
}
