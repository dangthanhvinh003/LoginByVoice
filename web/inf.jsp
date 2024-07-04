<%-- 
    Document   : inf
    Created on : Feb 1, 2024, 9:58:39 AM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-top: 0;
        }
        form {
            text-align: center;
            margin-top: -25px;
            margin-left: 40px;
        }
        input[type="submit"] {
            background-color: #51829B;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #2B4E59;
        }
    </style>
    </head>
    <body>
        <h1>${requestScope.MSG}</h1>
    <form action="show.jsp">
        <input type="submit" value="Back">
    </form>
    </body>
</html>
