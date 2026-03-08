<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <%
    if(session.getAttribute("products")==null){
        session.setAttribute("products",new HashMap<String,String[]>());
    }
    session.setAttribute("username","");
    %>
    <h2>Login</h2>
    <form action="validate.jsp" method="post">
        Username: <input type="text" name="username" /><br/><br/>
        Password: <input type="password" name="password" /><br/><br/>
        Role : <select name="roles" id="roles">
               <option value="admin">admin</option>
               <option value="customer">customer</option>
               </select>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
