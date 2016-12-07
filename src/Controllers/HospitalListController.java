/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Exceptions.EmptyException;
import Exceptions.NullElementException;
import classes.Hospital;
import classes.ReadHospitalList;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import structures.BinarySearchTree;

/**
 * FXML Controller class
 *
 * @author Atif Hassan
 */
public class HospitalListController implements Initializable {

    private BinarySearchTree<Hospital> bst = new BinarySearchTree<>();
    private ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();
    private ReadHospitalList excel;
    @FXML
    private TableView<Hospital> HospitalTable;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn addressCol;
    @FXML
    private TableColumn cityCol;
    @FXML
    private TableColumn stateCol;
    @FXML
    private TableColumn zipCol;
    @FXML
    private TableColumn latCol;
    @FXML
    private TableColumn longCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn imageCol;
    @FXML
    private TextField searchBox;
    @FXML
    private Button logoutButton;
    @FXML
    private Button searchButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        excelToBST();
        populateList(hospitalData);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void handleEnterPressed() {
        searchBox.getParent().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                hospitalResults();
                searchBox.editableProperty().set(false);
                searchButton.setText("New Search");
            }
        });
    }

    @FXML
    private void search(){
        if(searchButton.getText().equals("Search")){
            hospitalResults();
            searchBox.editableProperty().set(false);
            searchButton.setText("New Search");
        }
        else{
            searchButton.setText("Search");
            searchBox.editableProperty().set(true);
            searchBox.setText("Search Zip Code");
            populateList(hospitalData);
        }
    }
    private void hospitalResults() {
        String zipCode = searchBox.getText();
        System.out.println(zipCode);
        Hospital temp = new Hospital();
        temp.setZipCode(zipCode);
        if (bst.Contains(temp)) {
            try {
                temp = bst.Get(temp);
            } catch (EmptyException | NullElementException ex) {
            }
            ObservableList<Hospital> results = FXCollections.observableArrayList();
            results.add(temp);
            populateList(results);
            searchButton.setText("New Search");
        } else {
            searchBox.setText("Hospital Not Found");
        }
    }

    private void excelToBST() {
        try {
            excel = new ReadHospitalList();
        } catch (IOException ex) {
        }
        List hospitalList = excel.getList();
        for (int row = 0; row < hospitalList.size(); row++) {
            List list = (List) hospitalList.get(row);
            Hospital hospital = new Hospital();
            hospital.setName(String.valueOf(list.get(0)));
            hospital.setAddress(String.valueOf(list.get(1)));
            hospital.setCity(String.valueOf(list.get(2)));
            hospital.setState(String.valueOf(list.get(3)));
            hospital.setZipCode(String.valueOf(list.get(4)));
            hospital.setLatitude(String.valueOf(list.get(5)));
            hospital.setLongitude(String.valueOf(list.get(6)));
            hospital.setPhone(String.valueOf(list.get(7)));
            hospital.setImage(String.valueOf(list.get(8)));
            hospitalData.add(hospital);
            bst.Add(hospital);
        }
    }

    private void populateList(ObservableList<Hospital> temp) {
        HospitalTable.setItems(temp);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("State"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
        latCol.setCellValueFactory(new PropertyValueFactory<>("Latitude"));
        longCol.setCellValueFactory(new PropertyValueFactory<>("Longitude"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        imageCol.setCellValueFactory(new PropertyValueFactory<>("Image"));
        HospitalTable.getColumns().setAll(nameCol, addressCol, cityCol, stateCol, zipCol, latCol, longCol, phoneCol, imageCol);
    }

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
}
