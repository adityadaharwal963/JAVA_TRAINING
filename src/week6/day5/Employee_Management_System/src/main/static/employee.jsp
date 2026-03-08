<%@ page import="entity.Employee" %>
    <%@ page import="dao.EmployeeService" %>
        <% if (session.getAttribute("role")==null ||
            !String.valueOf(session.getAttribute("role")).equalsIgnoreCase("EMPLOYEE")) {
            response.sendRedirect("index.jsp"); return; } String username=(String) session.getAttribute("username");
            EmployeeService empDao=new EmployeeService(); Employee e=empDao.findByUsername(username); %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Employee Profile</title>
            </head>

            <body>
                <h1>Employee Profile</h1>
                <a href="LogoutServlet">Logout</a>
                <hr>

                <h2>Your Details</h2>
                <% if (e !=null) { %>
                    <form action="EmployeeServlet" method="post">
                        <input type="hidden" name="action" value="employeeUpdate" />
                        <input type="hidden" name="id" value="<%= e.getId() %>" />
                        <table border="1">
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <%= e.getId() %>
                                </td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td>
                                    <%= e.getName() %>
                                </td>
                            </tr>
                            <tr>
                                <td>Department:</td>
                                <td>
                                    <%= e.getDepartment() %>
                                </td>
                            </tr>
                            <tr>
                                <td>Designation:</td>
                                <td>
                                    <%= e.getDesignation() %>
                                </td>
                            </tr>
                            <tr>
                                <td>Salary:</td>
                                <td>
                                    <%= e.getSalary() %>
                                </td>
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
                                <td colspan="2"><input type="submit" value="Update My Details" /></td>
                            </tr>
                        </table>
                    </form>
                    <% } else { %>
                        <p>Profile not found or not mapped yet.</p>
                        <% } %>
            </body>

            </html>