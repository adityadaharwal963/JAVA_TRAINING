<html>
<body>
<form action="make_connection.jsp" method="post">
    Select ConnectionURL <select name="driver">
        <option value="org.postgresql.Driver">org.postgresql.Driver</option>
        <option value="com.msql.cj.jdbc.Driver">com.msql.cj.jdbc.Driver</option>
        </select><br/>
    Select ConnectionURL <select name="url">
    <option value="jdbc:postgresql://localhost:5436/">jdbc:postgresql://localhost:5436</option>
    <option value="jdbc:msql://localhost:/3303">jdbc:msql://localhost:/3303</option>
    </select><br/>
    Enter Username Number  <input type= "text" name="username"><br/>
    Enter Password  <input type= "text" name="password"><br/>
    Enter DATABASE Name <input type= "text" name="dbname"><br/>
    <input type="submit" value="Save Record">
</form>
</body>
</html>