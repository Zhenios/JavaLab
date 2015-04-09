/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import missstudent.ShowForm;
import missstudent.StaticData;
import student.Student;

/**
 *
 * @author Zhrnia
 */
public class StudentViewController {

    @FXML
    private URL location;

    @FXML
    private Label lastNameLabel;

    @FXML
    private TableColumn<Student, String> firstName;

    @FXML
    private TableColumn<Student, String> lastName;

    @FXML
    private Label instituteNameLabel;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Label groupNumberLabel;

    @FXML
    private Label lateDateLabel;

    @FXML
    private Label departmentNameLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private TableColumn<Student, String> group;

    @FXML
    private TableView<Student> table;

    @FXML
    void onClickAdd(ActionEvent event) {
        ShowForm add = new ShowForm("/view/StudentAdd.fxml", "Add Student", "");
        add.show();
    }

    @FXML
    void clickDelete(ActionEvent event) {
        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Confirm the deletion");
            alert.setContentText("Are you sure you want to delete?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                StaticData.data.remove(StaticData.selectedRow);
            } else {
                // ... user chose CANCEL or closed the dialog
            }
            
            
            
        } catch (Exception e) {
            ShowForm edit = new ShowForm("/view/StudentError.fxml", "Error", "");
            edit.show();
        }
    }

    @FXML
    void clickEdit(ActionEvent event) {
        
        try {
            ShowForm edit = new ShowForm("/view/StudentAddEdit.fxml", "Edit Student", "");
            edit.show();
        } catch (Exception e) {
            ShowForm edit = new ShowForm("/view/StudentError.fxml", "Error", "");
            edit.show();
        }
    }

    
    @FXML
    void initialize() {
        firstName.setCellValueFactory(new PropertyValueFactory<Student, String>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Student, String>("LastName"));
        group.setCellValueFactory(new PropertyValueFactory<Student, String>("Group"));
        table.setItems(StaticData.data);
        Student st1 = new Student("Zhenia", "Baraniyk", "243", "Department of Computer Science", "PZKS", "2015-03-12");
        Student st2 = new Student("Ivan", "Ivanov", "541", "Department of Computer Science", "KSM", "2015-04-02");
        Student st3 = new Student("Marina", "Repchyk", "241", "Department of Computer Science", "MPUIK", "2015-01-08");
        StaticData.data.add(st1);
        StaticData.data.add(st2);
        StaticData.data.add(st3);
//======Event double click row        
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    ShowForm edit = new ShowForm("/view/StudentAddEdit.fxml", "Edit Student", "");
                    edit.show();
                }
            }
        });

//======Event change selected row        
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // just in case you didnt already set the selection model to multiple selection.
        table.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                Student st = new Student();
                int row = 0;
                try {
                    String tmp = change.getList().toString();
                    char myChar = tmp.charAt(1);
                    tmp = String.valueOf(myChar);
                    row = Integer.parseInt(tmp);
                    StaticData.selectedRow = row;
                    System.out.println(row);
                } catch (Exception e) {
                    System.out.println("Error");
                }

                st = StaticData.data.get(row);
                firstNameLabel.setText(st.getFirstName());
                lastNameLabel.setText(st.getLastName());
                groupNumberLabel.setText(st.getGroup());
                departmentNameLabel.setText(st.getDepartment());
                instituteNameLabel.setText(st.getInstitute());
                lateDateLabel.setText(st.getLateDate());
            }
        });
    }
}
