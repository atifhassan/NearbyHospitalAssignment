//Controller for Login window
//Atif Hassan 
//CSC 202
package Controllers;

import Exceptions.EmptyException;
import Exceptions.FullException;
import classes.UserList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author atifm
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button createBut;
    @FXML
    private Label loginLabel;
    private String username;
    private String password;
    private UserList list = new UserList("databases/userList.dat");
    
    /**
     * 
     * @param event
     * @throws EmptyException
     * @throws FullException
     * @throws Exception 
     */
    @FXML
    private void handleLoginButton() throws EmptyException, FullException, Exception {
        //reset error label
        loginLabel.setText("");

        //get form data
        username = userField.getText();
        password = passField.getText();
        
        //username password validation
        if (list.doesUsernameExist(username)) {
            if (list.getUser(username).getPassword().matches(password)) {
                //change to welcome windows
                changeWindow("Views/HospitalList.fxml", "Hospital List");
            } else {//password error
                loginLabel.setText("Passowrd Invalid");
            }
        } else {//UserName error
            loginLabel.setText("Username Invalid");
        }
    }
        /**
     *
     * @param event
     */
    @FXML
    private void handleEnterPressed() {
        passField.getParent().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    handleLoginButton();
                } catch (FullException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    /**
     *
     */
    /**
     * changes scene to create account
     * @param event 
     */
    @FXML
    private void handleCreateButton(ActionEvent event) {
        changeWindow("Views/CreateAccount.fxml", "Create Account");
    }
    
    private void changeWindow(String fxml, String title) {
        Stage createAccount = (Stage) createBut.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        createAccount.setTitle(title);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        createAccount.setScene(scene);
        createAccount.centerOnScreen();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
