/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missstudent;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Zhrnia
 */


public class MissStudent extends Application {

    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        try {
            rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
            primaryStage.setTitle("Students");
            primaryStage.setScene(new Scene(rootLayout));
            
             //set Resizable on false
            primaryStage.setResizable(false);

            
            Image applicationIcon = new Image(getClass().getResourceAsStream("image/logo.bmp"));
            primaryStage.getIcons().add(applicationIcon);
           
            primaryStage.show();
            showPersonOverview();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 
    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/StudentView.fxml"));
        rootLayout.setCenter(anchorPane);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
