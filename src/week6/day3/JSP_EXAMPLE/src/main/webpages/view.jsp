<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<%
String user = (String) session.getAttribute("username");
%>

<h2>Welcome <%= user %></h2>

<h1>Products</h1>

<%
HashMap<String,String[]> products =
    (HashMap<String,String[]>) session.getAttribute("products");

if(products == null){
%>
    <h3>No Products</h3>
<%
}else {
%>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Description</th>
</tr>

<%
for (Map.Entry<String,String[]> p : products.entrySet()) {
    String name = p.getKey();
    String[] description = p.getValue();
%>

<tr>
    <td><%= name %></td>
    <td><%= description[1] %></td>
    <td><%= description[0] %></td>
</tr>

<%
}
%>
</table>
<a href="admin.jsp">Back</a>
<%
}
%>

</body>
</html>
