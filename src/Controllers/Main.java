/*
main class
Atif Hassan
CSC 202
*/
package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 *
 * @author atifm
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //creates login window
        Parent root = FXMLLoader.load(getClass().getResource("Views/Login.fxml"));
        stage.setTitle("Login");
        stage.centerOnScreen();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("Images/icon.png"));//adds icon
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
//username: atif
//pw: Pw#3