/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import classes.Hospital;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Atif Hassan
 */
public class HospitalController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label city;
    @FXML
    private Label state;
    @FXML
    private Label zip;
    @FXML
    private Label latitude;
    @FXML
    private Label longitude;
    @FXML
    private Label distance;
    @FXML
    private Label phone;
    @FXML
    private ImageView photo1;
    private Hospital data;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObjectInputStream in =new ObjectInputStream(new FileInputStream("databases/hospital.dat"));
            data = (Hospital) in.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        name.setText(data.getName());
        address.setText(data.getAddress());
        city.setText(data.getCity());
        state.setText(data.getState());
        zip.setText(data.getZipCode());
        latitude.setText(String.valueOf(data.getLatitude()));
        longitude.setText(String.valueOf(data.getLongitude()));
        distance.setText(String.valueOf(data.getDistance()));
        phone.setText(data.getPhone());
        URL myURL;
        Image image = new Image(data.getImage());
        photo1.setImage(image);
        
    }    
    
    @FXML
    private void goBack(){
        Stage createAccount = (Stage) backButton.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Views/HospitalList.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);

                createAccount.setTitle("Hospital List");
                scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                createAccount.setScene(scene);
                createAccount.centerOnScreen();
    }
}
