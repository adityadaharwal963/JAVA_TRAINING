<%@ page import="entity.Employee" %>
    <%@ page import="dao.EmployeeService" %>
        <% if (session.getAttribute("role")==null || !session.getAttribute("role").equals("EMPLOYER")) {
            response.sendRedirect("index.jsp"); return; } String idStr=request.getParameter("id"); Employee e=null;
            if(idStr !=null) { EmployeeService empDao=new EmployeeService(); e=empDao.findById(Integer.parseInt(idStr));
            } %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Edit Employee</title>
            </head>

            <body>
                <h1>Edit Employee</h1>
                <a href="employer.jsp">Back to Dashboard</a> | <a href="LogoutServlet">Logout</a>
                <hr>

                <% if (e !=null) { %>
                    <form action="EmployeeServlet" method="post">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="id" value="<%= e.getId() %>" />
                        <table>
                            <tr>
                                <td>Name:</td>
                                <td><input type="text" name="name" value="<%= e.getName() %>" required /></td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><input type="email" name="email" value="<%= e.getEmail() %>" /></td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td><input type="text" name="phone"
                                        value="<%= e.getPhone() != null ? e.getPhone() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td>Department:</td>
                                <td><input type="text" name="department"
                                        value="<%= e.getDepartment() != null ? e.getDepartment() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td>Designation:</td>
                                <td><input type="text" name="designation"
                                        value="<%= e.getDesignation() != null ? e.getDesignation() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td>Salary:</td>
                                <td><input type="text" name="salary"
                                        value="<%= e.getSalary() == 0.0 ? "" : e.getSalary() %>" /></td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td><input type="text" name="address"
                                        value="<%= e.getAddress() != null ? e.getAddress() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td><input type="text" name="city"
                                        value="<%= e.getCity() != null ? e.getCity() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td><input type="text" name="gender"
                                        value="<%= e.getGender() != null ? e.getGender() : "" %>" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Update Employee" /></td>
                            </tr>
                        </table>
                    </form>
                    <% } else { %>
                        <p>Invalid Employee ID.</p>
                        <% } %>
            </body>

            </html>