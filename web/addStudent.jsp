<%-- 
    Document   : addStudent
    Created on : Jan 31, 2024, 4:28:24 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Student</title>
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
        }
        label {
            display: block; /* Hiển thị nhãn dạng block */
            margin-bottom: 5px; /* Khoảng cách với phần tử dưới */
        }
        input[type="text"],
        select {
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
        <form action="confirm.jsp" method="post">
            <div>
                <label>Name:</label>
                <input type="text" name="name" required/>
            </div>
            <div>
                <label>Gender:</label>
                <select name="gender">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                    <option value="L">LGBT</option>
                    <option value="O">Other</option>
                </select>
            </div>
            <div>
                <label>Date of Birth:</label>
                <input type="text" name="dob" id="dobInput" pattern="\d{2}/\d{2}/\d{4}" placeholder="dd/MM/yyyy" required />
                <script>
                    // JavaScript to enforce the dd/MM/yyyy format
                    document.getElementById('dobInput').addEventListener('input', function (e) {
                        if (!/^\d{2}\/\d{2}\/\d{4}$/.test(e.target.value)) {
                            e.target.setCustomValidity('Invalid date format. Please use dd/MM/yyyy.');
                        } else {
                            e.target.setCustomValidity('');
                        }
                    });
                </script>
            </div>

            <div>
                <input type="submit" value="Add_Student" />
            </div>
        </form>
        <form action="addStudent" method="get" >
              <div>
                <input type="submit" value="Speech" />
            </div>
        </form>
        </form
    </body>
</html>
