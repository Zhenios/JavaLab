/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missstudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import student.Student;

/**
 *
 * @author Zhrnia
 */
public class StaticData {
    
    
    public static int selectedRow = 0;
     //list
    public static ObservableList<Student> data = FXCollections.observableArrayList();
    
}
