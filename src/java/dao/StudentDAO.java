/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author trang
 */
public class StudentDAO {

    public static int addStudent(Student s) {
        int id = -1;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Insert into Student(name, gender,dob) output inserted.id values(?,?,?)");
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getGender().substring(0, 1));
            stmt.setDate(3, s.getDateOB());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static ArrayList<Student> getStudentsByPage(int pageNumber){
        ArrayList<Student> stdList = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY; ");
            ps.setInt(1, 10*(pageNumber - 1)+1); // set gia tri 1 vao ?1
            ps.setInt(2, 10); // set gia tri 10 vao ?2
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                java.sql.Date dob = rs.getDate("dob");
                Student student = new Student(id, name, gender, dob);
                stdList.add(student);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stdList;
    }

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Student");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                java.sql.Date dob = rs.getDate("dob");

                Student student = new Student(id, name, gender, dob);
                studentList.add(student);
            }

            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentList;
    }

    public static void deleteStudentById(int studentId) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Student WHERE id = ?");
            stmt.setInt(1, studentId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Can't delete Student");
            } else {
                System.out.println("Delete Student successful !");
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Student getStudentById(int studentId) {
        Student student = null;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Student WHERE id = ?");
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                java.sql.Date dob = rs.getDate("dob");

                student = new Student(studentId, name, gender, dob);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Thay bằng logging nếu cần
        }
        return student;
    }

    public static boolean editStudent(Student student) {
        boolean success = false;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE Student SET name = ?, gender = ?, dob = ? WHERE id = ?");
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getGenderDb());
            stmt.setDate(3, student.getDateOB());
            stmt.setInt(4, student.getId());
            int rowsUpdated = stmt.executeUpdate();
            success = (rowsUpdated > 0);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Thay bằng logging nếu cần
        }
        return success;
    }

      public static List<Student> getStudents(int pageNumber, int pageSize) {
        String query = "SELECT * FROM Student ORDER BY Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Student> result = new ArrayList<>();

        try (Connection con =DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            int offset = 1 + (pageNumber-1) * pageSize ;
            stmt.setInt(1, offset);
            stmt.setInt(2, pageSize);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    String gender = rs.getString("Gender");
                    Date dob = rs.getDate("Dob");
                    result.add(new Student(id, name, gender, dob));
                }
            }
        } catch (SQLException e) {
            // Handle exceptions (logging, etc.)
            e.printStackTrace();
        }

        return result;
    }
    public static int getTotalStudentCount() {
        String query = "SELECT COUNT(*) FROM Student";
        int totalStudents = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                totalStudents = rs.getInt(1);
            }
        } catch (SQLException e) {
            // Handle exceptions (logging, etc.)
            e.printStackTrace();
        }

        return totalStudents;
    }
    public static List<Student> getStudentsByName(String name) {
    String query = "SELECT * FROM Student WHERE name LIKE ?";
    List<Student> result = new ArrayList<>();

    try (Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setString(1, "%" + name + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String studentName = rs.getString("name");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                result.add(new Student(id, studentName, gender, dob));
            }
        }
    } catch (SQLException e) {
        // Handle exceptions (logging, etc.)
        e.printStackTrace();
    }

    return result;
}


    
}
