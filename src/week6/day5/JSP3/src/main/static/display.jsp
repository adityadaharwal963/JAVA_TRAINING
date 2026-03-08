<jsp:useBean id="acc" class="com.Account" scope="application"/>

<html>
<body>
Customer Account Number : <jsp:getProperty name="acc" property="accountNo"/> <br/>
Customer Name :  <jsp:getProperty name="acc" property="name"/> <br/>
Customer Balance :  <jsp:getProperty name="acc" property="balance"/> <br/>

</body>
</html>