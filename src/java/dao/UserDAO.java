/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trang
 */
public class UserDAO {

    private static final String LOGIN = "SELECT [UserName]FROM [School].[dbo].[User] where UserName=? and Password=?";
    boolean check = false;
    PreparedStatement prStm = null;
    ResultSet rs = null;

    public boolean checkLogin(String user, String pass) {
        boolean check = false;
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                prStm = con.prepareStatement(LOGIN);
                prStm.setString(1, user);
                prStm.setString(2, pass);
                rs = prStm.executeQuery();
                if (rs.next()) {
                    check = true;
                    System.out.println("User found in the database.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in checkLogin: " + ex.getMessage());
        }
        return check;
    }

}
