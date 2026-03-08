<%@ page import="java.util.List" %>
    <%@ page import="entity.Employee" %>
        <%@ page import="dao.EmployeeService" %>
            <% if (session.getAttribute("role")==null ||
                !String.valueOf(session.getAttribute("role")).equalsIgnoreCase("EMPLOYER")) {
                response.sendRedirect("index.jsp"); return; } %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Employer Dashboard</title>
                </head>

                <body>
                    <h1>Employer Dashboard</h1>
                    <a href="LogoutServlet">Logout</a>
                    <hr>

                    <h2>Add New Employee</h2>
                    <form action="EmployeeServlet" method="post">
                        <input type="hidden" name="action" value="add" />
                        <table>
                            <tr>
                                <td>Name:</td>
                                <td><input type="text" name="name" required /></td>
                            </tr>
                            <tr>
                                <td>Username:</td>
                                <td><input type="text" name="username" required /></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" name="password" required /></td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><input type="email" name="email" /></td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td><input type="text" name="phone" /></td>
                            </tr>
                            <tr>
                                <td>Department:</td>
                                <td><input type="text" name="department" /></td>
                            </tr>
                            <tr>
                                <td>Designation:</td>
                                <td><input type="text" name="designation" /></td>
                            </tr>
                            <tr>
                                <td>Salary:</td>
                                <td><input type="text" name="salary" /></td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td><input type="text" name="address" /></td>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td><input type="text" name="city" /></td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td><input type="text" name="gender" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Add Employee" /></td>
                            </tr>
                        </table>
                    </form>

                    <hr>

                    <h2>Search Employee</h2>
                    <form action="employer.jsp" method="get">
                        Name: <input type="text" name="searchName" />
                        <input type="submit" value="Search" />
                    </form>

                    <hr>

                    <h2>All Employees</h2>
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>Actions</th>
                        </tr>
                        <% EmployeeService empService=new EmployeeService(); String
                            search=request.getParameter("searchName"); List<Employee> list;
                            if (search != null && !search.isEmpty()) {
                            list = empService.searchByName(search);
                            } else {
                            list = empService.findAllEmployees();
                            }
                            if (list != null) {
                            for (Employee e : list) {
                            %>
                            <tr>
                                <td>
                                    <%= e.getId() %>
                                </td>
                                <td>
                                    <%= e.getName() %>
                                </td>
                                <td>
                                    <%= e.getEmail() %>
                                </td>
                                <td>
                                    <%= e.getDepartment() %>
                                </td>
                                <td>
                                    <a href="emp_edit.jsp?id=<%= e.getId() %>">Edit</a> |
                                    <a href="EmployeeServlet?action=delete&id=<%= e.getId() %>">Delete</a>
                                </td>
                            </tr>
                            <% } } %>
                    </table>
                </body>

                </html>