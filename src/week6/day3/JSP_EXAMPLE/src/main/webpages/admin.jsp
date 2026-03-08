<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <%
    String user = (String) session.getAttribute("username");
    %>
    <h2>Welcome <%= user %> </h2>
    <button><a href='add.jsp'>Add Product</a></button><br/>
    <button><a href='update.jsp'>Update Product</a></button><br/>
    <button><a href='delete.jsp'>Delete Product</a></button><br/>
    <button><a href='view.jsp'>View Product</a></button><br/>

    <button><a href='login.jsp'>Logout </a></button>
</body>
</html>
