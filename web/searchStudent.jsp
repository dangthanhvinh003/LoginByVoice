<%-- 
    Document   : searchStudent.jsp
    Created on : Mar 1, 2024, 10:12:03 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search</title>
     <style>
        body {
            background-color: #FFFFFF; /* Màu nền */
            color: #51829B; /* Màu chữ */
            font-family: Arial, sans-serif; /* Kiểu font */
            margin: 0; /* Loại bỏ margin */
            padding: 0; /* Loại bỏ padding */
        }
        form {
            width: 300px; /* Độ rộng form */
            margin: 0 auto; /* Căn giữa form */
            padding: 20px; /* Khoảng cách với nội dung */
            text-align: center; /* Căn giữa form */
        }
        input[type="text"] {
            width: 100%; /* Độ rộng input */
            padding: 10px; /* Kích thước padding */
            margin-bottom: 10px; /* Khoảng cách giữa các input */
            border: 1px solid #51829B; /* Đường viền */
            border-radius: 5px; /* Bo tròn góc */
            box-sizing: border-box; /* Kích thước tính cả border và padding */
        }
        input[type="submit"] {
            background-color: #51829B; /* Màu nền nút */
            color: #FFFFFF; /* Màu chữ nút */
            padding: 10px 20px; /* Kích thước padding */
            border: none; /* Loại bỏ border */
            border-radius: 5px; /* Bo tròn góc */
            cursor: pointer; /* Đổi hình con trỏ khi di chuột */
        }
        input[type="submit"]:hover {
            background-color: #000000; /* Màu nền khi di chuột vào nút */
        }
    </style>
</head>
<body>
<html>
    <form action='searchStudent' method='Post'>
        <input type='text' name='name' placeholder='Enter Student Name'>
        <input type='submit' value='Search'>
    </form>
    <form action="show">
        <input type="submit" value="Back">
    </form>
    <form action="searchStudent" method="get">
        <input type="submit" value="Speech">
    </form>
</body>
</html>
