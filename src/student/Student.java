/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Zhrnia
 */
public class Student {
    
    private String firstName;
    private String lastName;
    private String Group;
    private String Department;
    private String Institute;
    private String lateDate;
    
    public Student(String firstName, String lastName, String Group, 
            String Department, String Institute, String lateDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Group = Group;
        this.Department = Department;
        this.Institute = Institute;
        this.lateDate = lateDate;
    }
    
    public Student()
    {
    
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return Group;
    }

    public String getDepartment() {
        return Department;
    }

    public String getInstitute() {
        return Institute;
    }

    public String getLateDate() {
        return lateDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setInstitute(String Institute) {
        this.Institute = Institute;
    }

    public void setLateDate(String lateDate) {
        this.lateDate = lateDate;
    }

    
}
