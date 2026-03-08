<jsp:useBean id="con" class="com.DBConnect" scope="application"/>
<jsp:setProperty name = "con" property="*"/>
<html>
<body>
    <% boolean status = con.getConnection();
    if(status){
    %>
  <a href="result.jsp">Hello Connection</a>
<%
}
%>
</body>
</html>