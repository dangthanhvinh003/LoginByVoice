<%-- 
    Document   : confirm
    Created on : Jan 31, 2024, 4:29:08 PM
    Author     : trang
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="sv" class="model.Student" scope="session" />
<jsp:setProperty name="sv" property="*" />

<!DOCTYPE html>
<html>
    <head>
        <title>Add Student</title>
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
            .box {
                width: 400px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                border: 1px solid #ccc; /*Thêm viền cho box*/
            }
            .container {
                width: 400px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }
            form {
                margin-top: 20px;
            }
            ul {
                list-style: none;
                padding: 0;
            }
            li {
                margin-bottom: 10px;
            }
            input[type="submit"],
            input[type="button"] {
                background-color: #51829B;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 3px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover,
            input[type="button"]:hover {
                background-color: #2B4E59;
            }
        </style>
    </head>
    <body>
        <form action="addStudent" method="POST">
            <div class="box">
                <ul>
                    <li>Student Name: ${sv.name}</li>
                    <li>Student Gender: ${sv.gender}</li>
                    <li>Student DOB: ${sv.dob}</li>
                </ul>
                <hr>    
                <input type="submit" value="Confirm" />
                <input type="button" value="Back" onclick="javascript:history.go(-1);" />
            </div>
        </form>

    </body>
</html>


