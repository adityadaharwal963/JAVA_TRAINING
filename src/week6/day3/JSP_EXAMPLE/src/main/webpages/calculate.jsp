<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<%
HashMap<String,String[]> products = (HashMap<String,String[]>) session.getAttribute("products");
int amount = 0;
for(Map.Entry<String,String[]> p: products.entrySet()){
    if(request.getParameter(p.getKey())!=null){
        String[] data = p.getValue();
        amount += Integer.parseInt(data[1]);
    }
}
session.setAttribute("amount",amount);
if(amount!=0){
response.sendRedirect("bill.jsp");
}
%>
</body>
</html>
