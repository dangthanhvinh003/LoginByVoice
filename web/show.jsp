<%-- 
    Document   : newjsp
    Created on : Feb 19, 2024, 8:08:24 PM
    Author     : Administrator
--%>
<%@page import="controller.showStudent"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.StudentDAO"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Students</title>

        <style>
            .pagination {
                text-align: center;
                margin-top: 20px;
            }

            .pagination a {
                color: black;
                text-decoration: none;
                padding: 8px 16px;
                border-radius: 5px;
                margin: 0 5px; /* Thêm khoảng cách giữa các nút phân trang */
            }

            .pagination a:hover {
                background-color: #f2f2f2;
            }

            .pagination .current {
                background-color: #51829B;
                color: white;
                padding: 8px 16px;
                border-radius: 5px;
                margin: 0 5px; /* Thêm khoảng cách giữa các nút phân trang */
            }

            .pagination .ellipsis {
                margin: 0 5px; /* Thêm khoảng cách giữa dấu ba chấm và các nút phân trang */
            }

            body {
                background-color: #FFFFFF;
                color: #51829B;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            h1 {
                text-align: center;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #51829B;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            a {
                color: #51829B;
                text-decoration: none;
            }
            a:hover {
                color: #000000;
            }
            form {
                margin-top: 20px;
                text-align: center;
            }
            input[type="submit"] {
                background-color: #51829B;
                color: #FFFFFF;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #000000;
            }
            /* Pagination Styles */
            .pagination a {
                color: black;
                text-decoration: none;
                padding: 8px 16px;
                border-radius: 5px;
            }
            .pagination a:hover {
                background-color: #f2f2f2;
            }
            .pagination .current {
                background-color: #51829B;
                color: white;
            }
            .nop {
                text-align: center; /* Center inline elements */
                margin: 0 auto; /* Center block-level elements */
            }
        </style>
    </head>

    <body>
        <h1>List of Students</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${studentList}" var="student" varStatus="iterStats">
                <tr>
                    <td>${iterStats.index + 10 * (currentPage - 1) +1}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.dob}</td>
                    <td>
                        <button class="edit"><a href="editStudent.jsp?id=${student.id}">Edit</a></button>
                    </td>
                    <td>
                        <button class="delete"><a href="deleteStudent?id=${student.id}">Delete</a></button>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <br>
        <br>
        <div class="nop">
            <c:if test="${numOfPages > 1}">
                <div class="pagination" >
                    <c:set var="url" value="${pageContext.request.contextPath}/show.jsp"/>
                    <c:choose>
                        <c:when test="${currentPage > 1}">
                            <a style="color: black;" href="show?page=1">First</a>
                            <a style="color: black;" href="show?page=${currentPage - 1}">Previous</a>
                        </c:when>
                        <c:otherwise>
                            <span style="color: black;">First</span>
                            <span style="color: black;">Previous</span>
                        </c:otherwise>
                    </c:choose>

                    <c:set var="ellipsis" value="..." />
                    <c:set var="gap" value="1" />

                    <c:forEach begin="1" end="${numOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage == i}">
                                <span style="color: black;" class="current">${i}</span>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${i == 1 || i == numOfPages || (i >= currentPage - gap && i <= currentPage + gap)}">
                                    <a style="color: black;" href="show?page=${i}">${i}</a>
                                </c:if>
                                <c:if test="${i == currentPage - gap - 1 || i == currentPage + gap + 1}">
                                    ${ellipsis}
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${currentPage < numOfPages}">
                            <a style="color: black;" href="show?page=${currentPage + 1}">Next</a>
                            <a style="color: black;" href="show?page=${numOfPages}">Last</a>
                        </c:when>
                        <c:otherwise>
                            <span style="color: black;">Next</span>
                            <span style="color: black;">Last</span>
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:if>
        </div>

        <form action="addStudent.jsp">
            <input type="submit" value="Add Student">
        </form>
        <form action="searchStudent.jsp" method="post">
            <input type="submit" value="Search Student">
        </form>
        <form action="showStudent" method="post">
            <input type="submit" value="Speech">
        </form>
    </body>

</html>