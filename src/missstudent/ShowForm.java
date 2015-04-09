/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missstudent;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Zhrnia
 */
public class ShowForm {
    //path .fxml file
    private String path;
    //title ErrorMessage form
    private String title;
    
    private String pathImage;
    
    //constructor 
    public ShowForm(){
        path = "/view/StudentAdd.fxml";
        title = "Add Student";
        pathImage = "";
    }
    
    //constructor overload
    public ShowForm(String viewPath, String titleText, String pathImage){
        this.path = viewPath;
        this.title = titleText;
        this.pathImage = "";
    }   
    
    //constructor overload
    public ShowForm(String titleText){
        path = "FXMLAddForm.fxml";
        title = titleText;
    }   
    
    //set Path
    public void setPath(String ViewPath){
        path = ViewPath;
    }
     
    //set Title
    public void setTitle(String TitleText){
        title = TitleText;
    }
    
    //get Title
    public String getTitle(){
        return title;
    }
    
    //get Path
    public String getPath(){
        return path;
    }
    
    //show Message 
    public void show() {
        Stage addDepartentStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            addDepartentStage.setScene(new Scene(root));
            addDepartentStage.initModality(Modality.APPLICATION_MODAL);
            
            //set Title
            addDepartentStage.setTitle(title);
            
             //set Icon programms
            Image applicationIcon = new Image(getClass().getResourceAsStream(pathImage));
            addDepartentStage.getIcons().add(applicationIcon);
            
            } catch (IOException e) {
               // e.getStackTrace();
            }
        //set Resizable on false
        addDepartentStage.setResizable(false);
        
        //show form
        addDepartentStage.show();
    }

    
}
