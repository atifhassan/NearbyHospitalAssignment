/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Exceptions.EmptyException;
import classes.Hospital;
import classes.Location;
import classes.ReadHospitalList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import structures.BinarySearchTree;
import structures.Heap;

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
    private TableColumn disCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn imageCol;
    @FXML
    private TextField latBox;
    @FXML
    private TextField longBox;
    @FXML
    private Button logoutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Slider radius;
    private double lat;
    private double lon;
    private Heap<Hospital> heap;

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
     * @throws EmptyException
     */
    @FXML
    private void search() throws EmptyException {
        if (searchButton.getText().equals("Search")) {
            latBox.editableProperty().set(false);
            longBox.editableProperty().set(false);
            searchButton.setText("New Search");
            hospitalResults();
        } else {
            searchButton.setText("Search");
            latBox.editableProperty().set(true);
            latBox.setPromptText("Latitude");
            longBox.editableProperty().set(true);
            longBox.setPromptText("Longitude");
            populateList(hospitalData);
        }
    }

    /**
     *
     */
    @FXML
    private void hospitalSelect() {
        HospitalTable.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Hospital data = HospitalTable.getSelectionModel().getSelectedItem();
                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("databases/hospital.dat"));
                    out.writeObject(data);
                } catch (IOException ex) {
                }
                Stage createAccount = (Stage) HospitalTable.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Views/Hospital.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);

                createAccount.setTitle(data.getName());
                scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                createAccount.setScene(scene);
                createAccount.centerOnScreen();
            }
        });
    }

    /**
     *
     */
    @FXML
    private void Locate() {
        latBox.setText(Location.getLatitude());
        longBox.setText(Location.getLongitude());
    }

    /**
     *
     */
    @FXML
    private void hospitalResults() throws EmptyException {
        if (searchButton.getText().equals("Search")) {

        } else {
            makeHeap();
            Double r = radius.getValue();
            ObservableList<Hospital> results = FXCollections.observableArrayList();
            while (!heap.isEmpty()) {
                Hospital h = heap.dequeue();
                if (h.getDistance() <= r) {
                    results.add(h);
                }
            }
            populateList(results);
        }
    }

    private void makeHeap() {
        lat = Double.parseDouble(latBox.getText());
        lon = Double.parseDouble(longBox.getText());
        heap = new Heap<>();
        bst.Reset();
        Hospital.setCompareInt(6);
        try {
            while (!bst.isEmpty()) {
                Hospital temp = bst.getNext();
                temp.setDistance(lat, lon);
                heap.enqueue(temp);
            }
        } catch (EmptyException ex) {
        }
    }

    /**
     *
     */
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

    /**
     *
     * @param temp
     */
    private void populateList(ObservableList<Hospital> temp) {
        HospitalTable.setItems(temp);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("State"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
        latCol.setCellValueFactory(new PropertyValueFactory<>("Latitude"));
        longCol.setCellValueFactory(new PropertyValueFactory<>("Longitude"));
        disCol.setCellValueFactory(new PropertyValueFactory<>("Distance"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        imageCol.setCellValueFactory(new PropertyValueFactory<>("Image"));
        HospitalTable.getColumns().setAll(nameCol, addressCol, cityCol, stateCol, zipCol, latCol, longCol, disCol, phoneCol, imageCol);
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
