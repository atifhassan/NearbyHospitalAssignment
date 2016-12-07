/*
Atif Hassan
CSC 202
Controller for Welcome FXML
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * @author atifm
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button logoutButton;

    /*
    Returns user back to Login in screen
     */
    @FXML
    private void LogOut() {
        Stage createAccount = (Stage) logoutButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Views/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        createAccount.setTitle("Login");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        createAccount.setScene(scene);

        createAccount.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
