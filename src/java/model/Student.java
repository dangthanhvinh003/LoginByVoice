/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
import dao.StudentDAO;
import java.io.Serializable;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Serializable{
    private int id;
    private String name;
    private char gender;
    private Date dob;

    public Student() {
    }

    public Student(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender.charAt(0);
        setDob(dob);
    }
    
    public Student(int id, String name, String gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender.charAt(0);
        this.dob = dob;
    }
    public Student(Student s){
        this(s.id,s.name,s.getGender(),s.dob);
    }
//    public Student(int id){
//        this(StudentDAO.getStudent(id));
//    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        switch(gender){
            case 'M': return "Male";
            case 'F': return "Female";
            case 'L': return "LGBT";
            case 'O': return "Other";
            default: return "";
        }
    }
      public String getGenderDb() {
        switch(gender){
            case 'M': return "M";
            case 'F': return "F";
            case 'L': return "L";
            case 'O': return "O";
            default: return "";
        }
    }
    
    public void setGender(String gender) {
        this.gender = gender.charAt(0);
    }

    public String getDob() {
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(dob);
    }

    public Date getDateOB(){
        return dob;
    }
    public void setDob(String dob) {
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dob = new Date(sd.parse(dob).getTime());
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid DOB");
        }
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + getGender() + ", dob=" + getDob() + '}';
    }

    public int addNew(){
        return StudentDAO.addStudent(this);
    }

//    public Student update(){
//        return StudentDao.update(this);
//    }
//    
//    public int delete(){
//        return StudentDao.delete(id);
//    }
}
