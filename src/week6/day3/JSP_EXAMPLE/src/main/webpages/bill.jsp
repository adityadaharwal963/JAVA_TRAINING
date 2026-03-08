<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<%

String user =  (String) session.getAttribute("username");
Integer amount = (Integer) session.getAttribute("amount");

if(user !=null){
%>
<h1>Thank you, <%= user %> </h1>
<h2> Your Billed amount : <%= amount %> </h2>
<%
}
%>
</body>
</html>
