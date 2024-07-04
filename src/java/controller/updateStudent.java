/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "updateStudent", urlPatterns = {"/updateStudent"})
public class updateStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentIdString = request.getParameter("id");
        if (studentIdString != null && !studentIdString.isEmpty()) {
            int studentId = Integer.parseInt(studentIdString);
            Student student = StudentDAO.getStudentById(studentId);
            if (student != null) {
                request.setAttribute("student", student);
                response.sendRedirect("show");
            } else {
                response.sendRedirect("students.jsp"); // hoặc trang lỗi khác
            }
        } else {
            response.sendRedirect("students.jsp"); // hoặc trang lỗi khác
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");

        String dobString = request.getParameter("dob");
        java.sql.Date dob = null;
        try {
            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdfInput.parse(dobString);
            dob = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Tạo đối tượng Student từ dữ liệu được gửi từ biểu mẫu
        Student student = new Student(studentId, name, gender, dob);

        // Gọi phương thức cập nhật sinh viên trong StudentDAO
        boolean updated = StudentDAO.editStudent(student);

        if (updated) {
            response.sendRedirect("show"); // Hoặc trang thông báo cập nhật thành công
        } else {
            response.sendRedirect("error.jsp"); // Hoặc trang thông báo lỗi
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
