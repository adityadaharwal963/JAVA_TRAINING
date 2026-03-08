<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Validation</title>
</head>
<body>
    <%
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String role = request.getParameter("roles");
        session.setAttribute("username",user);
        if("admin".equals(user) && "1234".equals(pass) && "admin".equals(role) ) {
            response.sendRedirect("admin.jsp");
        } else if("customer".equals(user) && "1234".equals(pass) && "customer".equals(role)){
            response.sendRedirect("shopping.jsp");
        }
        else {
    %>
        <h2>Login Failed</h2>
        <p>Invalid username or password.</p>
        <a href="login.jsp">Try Again</a>
    <%
        }
    %>
</body>
</html>
