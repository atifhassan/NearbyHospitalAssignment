/*
Controller for Create Account FXML
Atif Hassan
CSC 202
 */
package Controllers;

import Exceptions.EmptyException;
import Exceptions.FullException;
import java.io.File;
import javafx.stage.FileChooser;
import classes.User;
import classes.UserList;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import java.util.regex.Pattern;

/**
 *
 * @author atifm
 */
public class CreateAccountController implements Initializable {

    @FXML
    private Button openDialog;
    @FXML
    private TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private DatePicker dobPicker;
    @FXML
    private ChoiceBox genderBox;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField photoField;
    @FXML
    private PasswordField pwordField;
    @FXML
    private PasswordField pword2Field;
    @FXML
    private Button registerBut;
    @FXML
    private Label pw1Label;
    @FXML
    private Label pw2Label;
    @FXML
    private Label fillLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField ssnField;
    @FXML
    private Label ssnLabel;
    @FXML
    private TextField phoneField;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label userNameLabel;
    private UserList list = new UserList();
    private String firstName = null;
    private String lastName = null;
    private LocalDate dob = null;
    private String username = null;
    private String email = null;
    private String photoPath = null;
    private String password = null;
    private String phone = null;
    private String password2 = null;
    private String gender = null;
    private String ssn = null;
    private FileChooser fileCH = new FileChooser();
    private User one;

    /**
     * Returns user to Login Window
     */
    @FXML
    private void cancelAccountBut() {
        returnToLogin();
    }

    /*
   
     */
    /**
     * Browse Button Action Opens Dialog box to select file
     */
    @FXML
    private void fileChoose() {
        Stage stage = (Stage) openDialog.getScene().getWindow();
        File file = fileCH.showOpenDialog(stage);
        if (file != null) {
            photoField.setText(file.getPath());
        }
    }

    /**
     *
     * @throws EmptyException
     * @throws FullException
     */
    @FXML
    private void createAccountBut() throws EmptyException, FullException {
        //Reset all the error labels
        fillLabel.setText("");
        pw1Label.setText("");
        pw2Label.setText("");
        emailLabel.setText("");
        ssnLabel.setText("");
        phoneLabel.setText("");
        userNameLabel.setText("");
        //get all form values
        firstName = fNameField.getText();
        lastName = lNameField.getText();
        dob = dobPicker.getValue();
        gender = genderBox.getSelectionModel().getSelectedItem().toString();
        username = userNameField.getText();
        email = emailField.getText();
        ssn = ssnField.getText();
        phone = phoneField.getText();
        photoPath = photoField.getText();
        password = pwordField.getText();
        password2 = pword2Field.getText();

        if (isFilled()) {
            if (isUserNameAvailable()) {
                if (isEmailValid()) {
                    if (isPhoneValid()) {
                        if (isSSNValid()) {
                            if (password.equals(password2)) { // do passwords match?
                                if (isPWValid()) {
                                    //create User and pass values
                                    one = new User(firstName, lastName, ssn, dob, gender, username, email, phone, photoPath, password);

                                    //add User to the list
                                    try {
                                        list.addUser(one);
                                    } catch (FullException ex) {
                                        Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    //write list to file
                                    try {
                                        list.WriteList();
                                    } catch (IOException ex) {
                                        Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    //Go back to login page
                                    returnToLogin();
                                } else {
                                    pw1Label.setText("Password Invalid");
                                }
                            } else {
                                pw2Label.setText("Passwords Do not Match");
                            }
                        } else {
                            ssnLabel.setText("SSN Invalid");
                        }
                    } else {
                        phoneLabel.setText("Phone Number Invalid");
                    }
                } else {
                    emailLabel.setText("Email Invalid");
                }
            } else {
                userNameLabel.setText("Username not Available");
            }
        } else {
            fillLabel.setText("All Fields Must be Completed");

        }
    }

    /**
     * check username list
     *
     * @return @throws EmptyException
     * @throws FullException
     */
    private boolean isUserNameAvailable() throws EmptyException, FullException {
        return !list.doesUsernameExist(username);
    }

    /**
     * make sure all forms are filled
     *
     * @return
     */
    private boolean isFilled() {
        if (firstName.isEmpty()) {
            return false;
        } else if (lastName.isEmpty()) {
            return false;
        } else if (dob == null) {
            return false;
        } else if (gender.equals("-")) {
            return false;
        } else if (username.isEmpty()) {
            return false;
        } else if (email.isEmpty()) {
            return false;
        } else if (ssn.isEmpty()) {
            return false;
        } else if (phone.isEmpty()) {
            return false;
        } else if (photoPath.isEmpty()) {
            return false;
        } else if (password.isEmpty()) {
            return false;
        } else if (password2.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * phone number needs to be 10 numbers
     *
     * @return
     */
    private boolean isPhoneValid() {
        return Pattern.matches("^[0-9]{10}$", phone);
    }

    /**
     * Social needs to be 9 numbers
     *
     * @return
     */
    private boolean isSSNValid() {
        return Pattern.matches("^[0-9]{9}$", ssn);
    }

    /**
     * email has to me in ***@mail.*** format
     *
     * @return
     */
    private boolean isEmailValid() {
        if (email.contains("@mail.")) {
            if (!email.endsWith(".")) {
                if (!email.startsWith("/@")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * does password have uppercase lowercase number and special char
     *
     * @return
     */
    private boolean isPWValid() {
        return Pattern.matches("^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{0,}$", password);
    }

    /**
     * return to login window
     */
    private void returnToLogin() {
        Stage createAccount = (Stage) registerBut.getScene().getWindow();

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
