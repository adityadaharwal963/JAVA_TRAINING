<%@ page import="java.sql.SQLException" %>
    <% if (session.getAttribute("role") !=null) { if
        (session.getAttribute("role").toString().equalsIgnoreCase("EMPLOYER")) { response.sendRedirect("employer.jsp");
        return; } else if (session.getAttribute("role").toString().equalsIgnoreCase("EMPLOYEE")) {
        response.sendRedirect("employee.jsp"); return; } } %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Login</title>
        </head>

        <body>
            <h1>Employee Management System</h1>
            <h2 style="color:red">
                <% if (request.getParameter("error") !=null) { out.print(request.getParameter("error")); } %>
            </h2>
            <form action="Login" method="post">
                Login As:
                <select name="role">
                    <option value="EMPLOYER">Employer</option>
                    <option value="EMPLOYEE">Employee</option>
                </select>
                <br /><br />
                Username: <input type="text" name="username" required /><br /><br />
                Password: <input type="password" name="password" required /><br /><br />
                <input type="submit" value="Login" />
            </form>
        </body>

        </html>