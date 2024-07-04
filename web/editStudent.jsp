<%-- 
    Document   : editStudent
    Created on : Feb 19, 2024, 8:42:13 PM
    Author     : Administrator
--%>


<%@page import="dao.StudentDAO"%>
<%@page import="model.Student"%>
<%@page import="dao.StudentDAO"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<h1>Edit Student</h1>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        width: 400px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
    }
    h1 {
        text-align: center;
        margin-top: 0;
        margin-right: 50px;
    }
    form {
        margin-top: 20px;
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        background-color: #51829B;
        color: #fff;
        border: none;
        padding: 10px;
        border-radius: 3px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #2B4E59;
    }
    .error {
        color: red;
        margin-top: 10px;
        text-align: center;
    }
</style>
</head>
<body>
    
    
    <%-- Lấy ID sinh viên từ URL --%>
    <% 
        String studentIdString = request.getParameter("id");
        if (studentIdString != null) {
            int studentId = Integer.parseInt(studentIdString);
            Student student = StudentDAO.getStudentById(studentId);
            if (student != null) {
    %>
                <%-- Hiển thị biểu mẫu chỉnh sửa thông tin sinh viên --%>
                <form action="updateStudent" method="post">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    Name: <input type="text" name="name" value="<%= student.getName() %>" required><br>
                    Gender: <input type="text" name="gender" value="<%= student.getGender() %>"required><br>
                    Date of Birth: <input type="text" name="dob" value="<%= student.getDateOB() %>"required
                                         ><br>
                    <input type="submit" value="Update">
                </form>
    <%      
            } else {
                out.println("Student not found.");
            }
        } else {
            out.println("Student ID not provided.");
        }
    %>
</body>
</html>



