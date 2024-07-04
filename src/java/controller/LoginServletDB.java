package controller;

import dao.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "LoginServletDB", urlPatterns = {"/logindb"})
public class LoginServletDB extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "show";
    private String username;
    private String password;

    private static final Logger logger = Logger.getLogger(LoginServletDB.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Specify the full path to your Python script
            ProcessBuilder pb = new ProcessBuilder("python", "C:\\Users\\Administrator\\test.py");
            Process p = pb.start();

            // Read the script's output
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = in.readLine()) != null) {
                output.append(line).append("\n");
            }
            line = output.toString();
            line = line.trim().toLowerCase();
            line = Character.toLowerCase(line.charAt(0)) + line.substring(1);

            // Send the output to the client
            String[] parts = line.split("\\s+"); // Tách các phần bằng khoảng trắng

            StringBuilder usernameText = new StringBuilder();
            StringBuilder passwordText = new StringBuilder();

            boolean isUsername = false;
            boolean isPassword = false;

            for (int i = 0; i < parts.length; i++) {
                if (isUsername) {
                    if (!parts[i].equals("password")) {
                        usernameText.append(parts[i]);
                    } else {
                        isUsername = false;
                        isPassword = true;
                    }
                } else if (isPassword) {
                    passwordText.append(parts[i]);
                }

                if (parts[i].equals("username")) {
                    isUsername = true;
                } else if (parts[i].equals("password")) {
                    isPassword = true;
                }
            }

            // Loại bỏ khoảng trắng và ghép lại username và password
            username = usernameText.toString().replaceAll("\\s", "");
            password = passwordText.toString().replaceAll("\\s", "");

            response.getWriter().println("<html><body>");
            response.getWriter().println("<style>");
            response.getWriter().println("body {");
            response.getWriter().println("    font-family: Arial, sans-serif;");
            response.getWriter().println("    background-color: #f5f5f5;");
            response.getWriter().println("    margin: 0;");
            response.getWriter().println("    padding: 0;");
            response.getWriter().println("    text-align: center;");
            response.getWriter().println("}");
            response.getWriter().println("h1 {");
            response.getWriter().println("    text-align: center;");
            response.getWriter().println("}");
            response.getWriter().println("form {");
            response.getWriter().println("    display: flex;");
            response.getWriter().println("    justify-content: center;");
            response.getWriter().println("}");
            response.getWriter().println("input[type='submit'] {");
            response.getWriter().println("    background-color: #51829B;");
            response.getWriter().println("    color: #fff;");
            response.getWriter().println("    border: none;");
            response.getWriter().println("    padding: 10px 20px;");
            response.getWriter().println("    border-radius: 3px;");
            response.getWriter().println("    cursor: pointer;");
            response.getWriter().println("    transition: background-color 0.3s ease;");
            response.getWriter().println("}");
            response.getWriter().println("input[type='submit']:hover {");
            response.getWriter().println("    background-color: #2B4E59;");
            response.getWriter().println("}");
            response.getWriter().println("</style>");
            response.getWriter().println("<h1>Python Script Output:</h1>");
            response.getWriter().println("<pre>" + output.toString() + "</pre>");
            response.getWriter().println("<form action='./logindb' method='post'>");
            response.getWriter().println("<input type='submit' value='Submit'/>");
            response.getWriter().println("</form>");
            response.getWriter().println("<p> Your User Name is  " + username + "</p>");
            response.getWriter().println("<p> Your PassWord is  " + password + "</p>");
            request.setAttribute("user", this.username);
            request.setAttribute("pass", this.password);
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<html>");
            response.getWriter().println("<body>");
            response.getWriter().println("Look like you haven't said anything yet ^^");
            response.getWriter().println("<button onclick=\"location.reload();\">Reload Page</button>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        boolean result = false;
        try {
            String username1 = request.getParameter("user");
            String password1 = request.getParameter("pass");
            UserDAO ud = new UserDAO();
            if (username1 == null && password1 == null) {
                result = ud.checkLogin(username, password);
            } else {
                result = ud.checkLogin(username1, password1);
            }
            if (result) {
                url = SUCCESS;
            } else {
                String error = "invalid username or password";
                request.setAttribute("Error", error);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect(url);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
