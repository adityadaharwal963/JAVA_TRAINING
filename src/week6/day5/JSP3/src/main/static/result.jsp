<jsp:useBean id="con" class="com.DBConnect" scope="application"/>
<html>
<body>

  <% if(con != null && ){
  %>
  <jsp:getProperty name="con" property="driver"/>
  Hello Connected
  <%
  }else{
  %>
  Not Connected
  <% }%>

</body>
</html>