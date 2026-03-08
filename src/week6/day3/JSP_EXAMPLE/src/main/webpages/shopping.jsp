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
    <h2>Welcome <%= user %> </h2>

    <h1> Products </h1>

    <%
    HashMap<String,String[]> products = (HashMap<String,String[]> ) session.getAttribute("products");
    if(products == null){
    %>
    <h3> no Products </h3>
    <%
    }else {
    %>
    <form method="post" action="calculate.jsp">
    <table>
     <tr>
            <td>Name </td>
            <td>Price </td>
            <td>Desc</td>
            <td>Buy</td>
            <tr/>

    <%
        for (Map.Entry<String,String[]> p : products.entrySet()) {
                    String name = p.getKey();
                    String[] description = p.getValue();
    %>
        <tr>
        <td>Name : <%= name %> </td>
        <td>Price : <%= description[1] %> </td>
        <td>Desc : <%= description[0] %> </td>
        <td><input type="checkbox" name=<%= name %> value="buy"></td>
        <tr/>

    <%
        }
    %>
    </table>
    <button type="submit" name="btn">Proceed to Billing</button>
    </form>
    <%
    }
    %>

</body>
</html>
