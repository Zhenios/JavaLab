/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import missstudent.ShowForm;
import missstudent.StaticData;
import student.Student;

/**
 *
 * @author Zhrnia
 */
public class StudentEditController {
    private Student st = new Student();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private DatePicker calendar;

    @FXML
    private ChoiceBox<String> fieldDepartment;

    @FXML
    private ChoiceBox<String> fieldInstitute;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField fieldSecondName;

    @FXML
    private TextField fieldFirstName;

    @FXML
    private TextField fieldGroup;
    
    @FXML
    void clickEdit(ActionEvent event) {
        
        
        String str;
        str = fieldFirstName.getText();
        if(!str.matches("^\\D*$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Name can not contain numbers.");
            alert.setContentText("Please check and try again!");

            alert.showAndWait();
            return;
        }else{
            //не содержит
        }
        
        str = fieldSecondName.getText();
        if(!str.matches("^\\D*$")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Name can not contain numbers.");
            alert.setContentText("Please check and try again!");

            alert.showAndWait();
            return;
        }else{
            //не содержит
        }
        
        
        
         if (!isEmptyFields())
        {
            st.setFirstName(fieldFirstName.getText());
            st.setLastName(fieldSecondName.getText());
            st.setGroup(fieldGroup.getText());
            st.setDepartment(fieldDepartment.getSelectionModel().getSelectedItem().toString()); 
            st.setInstitute(fieldInstitute.getSelectionModel().getSelectedItem().toString());
            st.setLateDate(calendar.getValue().toString());
        
       
            StaticData.data.set(StaticData.selectedRow, st);
            Stage stage = (Stage) btnAdd.getScene().getWindow();
         //close form Message
        stage.close();

        }
        else
         {
            ShowForm error = new ShowForm("/view/StudentErrorEmpty.fxml", "Error", "");
            error.show();
         }
            
        
    }
    
    private boolean isEmptyFields(){
        if (fieldFirstName.getText().isEmpty() || 
            fieldSecondName.getText().isEmpty() || fieldGroup.getText().isEmpty()
                || calendar.getValue().toString().equals("")) 
                //fields is empty
                return true;
        else
            return false;
        
    }
   
    
    @FXML
    void initialize() {        
        st = StaticData.data.get(StaticData.selectedRow);
        fieldFirstName.setText(st.getFirstName());
        fieldSecondName.setText(st.getLastName());
        fieldGroup.setText(st.getGroup());
        calendar.setValue(LocalDate.now());
        
        
        ObservableList<String> listOfDepartment = FXCollections.observableArrayList();
        listOfDepartment.add("Department of Computer Science");
        listOfDepartment.add("Faculty of Mathematics");
        listOfDepartment.add("Physics Department");
        fieldDepartment.setItems(listOfDepartment);
        
        ObservableList<String> listOfComputerScines = FXCollections.observableArrayList();
        listOfComputerScines.add("PZKS");
        listOfComputerScines.add("MPUIK");
        listOfComputerScines.add("KSM");
        
        ObservableList<String> listOfMath = FXCollections.observableArrayList();
        listOfMath.add("Department of Applied Mathematics");
        listOfMath.add("Department of Algebra and Computer Science");
        listOfMath.add("Department of Mathematical Analysis");
        
        ObservableList<String> listOfPhysics = FXCollections.observableArrayList();
        listOfPhysics.add("Department of Physics");
        listOfPhysics.add("Department of Theoretical Physics");
        listOfPhysics.add("Department of Solid State Physics");
        listOfPhysics.add("Department of Physics of Semiconductors and Nanostructures");
        
       if (st.getDepartment().equals("Department of Computer Science"))
             {
                fieldDepartment.getSelectionModel().select("Department of Computer Science");
                fieldInstitute.setItems(listOfComputerScines);
                fieldInstitute.getSelectionModel().select("PZKS");
             } 
       
       if (st.getDepartment().equals("Faculty of Mathematics"))
             {
                fieldDepartment.getSelectionModel().select("Faculty of Mathematics");
                fieldInstitute.setItems(listOfMath);
                fieldInstitute.getSelectionModel().select("Department of Applied Mathematics");
             } 
     
       if (st.getDepartment().equals("Physics Department"))
             {
                fieldDepartment.getSelectionModel().select("Physics Department");
                fieldInstitute.setItems(listOfPhysics);
                fieldInstitute.getSelectionModel().select("Department of Physics");
             } 
       
        fieldDepartment.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
             String tmp = (String) fieldDepartment.getItems().get((Integer) number2);
             System.out.println(tmp);
             if (tmp.equals("Department of Computer Science"))
             {
                fieldInstitute.setItems(listOfComputerScines);
                fieldInstitute.getSelectionModel().select("PZKS");
             }
             if (tmp.equals("Faculty of Mathematics"))
             {
                fieldInstitute.setItems(listOfMath);
                fieldInstitute.getSelectionModel().select("Department of Applied Mathematics");
             }
             
             if (tmp.equals("Physics Department"))
             {
                fieldInstitute.setItems(listOfPhysics);
                fieldInstitute.getSelectionModel().select("Department of Physics");
             }
             
      }
    });
        
    }
    
        
    
    
}
