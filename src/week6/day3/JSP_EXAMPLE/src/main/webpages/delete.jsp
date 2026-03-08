<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<%

    if(request.getParameter("btn") != null &&
       request.getParameter("product_name") != null &&
       ) {

        String name = request.getParameter("product_name");
        String desc = request.getParameter("product_desc");
        String price = request.getParameter("product_price");

        HashMap<String, String[]> products = (HashMap<String, String[]>) session.getAttribute("products");
        if(products == null) {
            products = new HashMap<>();
        }
        if(products.containsKey(name)){
            products.remove(name);
            session.setAttribute("products", products);
            response.sendRedirect("admin.jsp");
        }else{
        %>
            Product not found
        <%
        }
    }
%>

<form method="post">
    Name : <input type="text" name="product_name"> <br/>
    <input type="submit" name="btn" value="Add Product"/>
</form>
</body>
</html>
