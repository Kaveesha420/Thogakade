package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class login_Form_Controller {

    public PasswordField txtPassword;
    public TextField txtUserName;
    Stage stage = new Stage();

    public void loginOnAction(ActionEvent event) {
        String name = txtUserName.getText();
        String password = txtPassword.getText();

        if ("admin".equals(name) && "1234".equals(password)){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/dashbord_Form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Dashbord");
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid User");
            alert.setContentText("Please Input Valid UserName and Password");
            alert.showAndWait();
        }

    }
}