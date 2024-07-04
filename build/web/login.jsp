<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body {
                background-color: #51829B; /* Màu nền */
                color: white; /* Màu chữ */
                font-family: Arial, sans-serif; /* Kiểu font */
                margin: 0; /* Loại bỏ margin */
                padding: 0; /* Loại bỏ padding */
            }
            h1 {
                text-align: center; /* Căn giữa tiêu đề */
            }
            form {
                width: 300px; /* Độ rộng form */
                margin: 0 auto; /* Căn giữa form */
                padding: 20px; /* Khoảng cách với nội dung */
                background-color: #51829B; /* Màu nền form */
                border-radius: 10px; /* Bo tròn góc */
            }
            input[type="text"],
            input[type="password"],
            input[type="submit"] {
                width: 100%; /* Độ rộng input */
                margin-bottom: 10px; /* Khoảng cách giữa các input */
                padding: 10px; /* Kích thước padding */
                border: none; /* Loại bỏ border */
                border-radius: 5px; /* Bo tròn góc */
            }
            input[type="text"],
            input[type="password"]
            {
                width: 94%; /* Độ rộng input */
                margin-bottom: 10px; /* Khoảng cách giữa các input */
                padding: 10px; /* Kích thước padding */
                border: none; /* Loại bỏ border */
                border-radius: 5px; /* Bo tròn góc */
            }
            input[type="submit"] {
                background-color: white; /* Màu nền nút */
                color: #51829B; /* Màu chữ nút */
                cursor: pointer; /* Đổi hình con trỏ khi di chuột */
            }
            input[type="submit"]:hover {
                background-color: #51829B; /* Màu nền khi di chuột vào nút */
                color: white; /* Màu chữ khi di chuột vào nút */
            }
        </style>
        <script>
            var count = 3; // Số giây đếm ngược

            // Hàm bắt đầu đếm ngược
            function startCountdown() {
                var countdownElement = document.getElementById("countdown");

                // Hiển thị số giây đầu tiên
                countdownElement.innerText = count;

                // Đếm ngược mỗi giây
                var countdownInterval = setInterval(function () {
                    if (count > 1) {
                        count--;
                        countdownElement.innerText = count; // Cập nhật số giây
                    } else {
                        clearInterval(countdownInterval); // Dừng đếm ngược khi đạt 1
                        countdownElement.innerText = "GO!"; // Thay đổi văn bản trước khi hành động tiếp theo
                        setTimeout(function () {
                            document.getElementById("speechForm").submit(); // Submit form sau khi đếm ngược
                        }, 1000); // Chờ 1 giây trước khi submit form
                    }
                }, 1000); // Đếm ngược mỗi 1 giây (1000 milliseconds)
            }
        </script>
    </head>
    <body>

        <h1>Login</h1>
        <form action="./logindb" method="get">
            <div id="countdown" style="font-size: 24px; font-weight: bold;"></div>
            <input type="submit" value="Speech" onclick="startCountdown()"/>
        </form>
        <div id="countdown" style="font-size: 24px; font-weight: bold; text-align: center">Hãy nói theo fomat : username ..... password .....</div>
        <form action="./logindb" method="post">
            <input type="text" name="user" value="${username}" /> <!-- Hiển thị username -->
            <input type="password" name="pass" value="${password}" /> <!-- Hiển thị password -->
            <input type="submit" value="Login" />
        </form>
    </body>
</html>