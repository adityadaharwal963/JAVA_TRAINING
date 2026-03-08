package controller;

import dao.EmployeeService;
import dao.UserService;
import entity.Employee;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        EmployeeService empDao = new EmployeeService();
        UserService userDao = new UserService();

        try {
            if ("add".equalsIgnoreCase(action)) {

                User u = new User();
                u.setUsername(request.getParameter("username"));
                u.setPassword(request.getParameter("password"));
                u.setRole("EMPLOYEE");
                User createdUser = userDao.addUser(u);

                Employee e = new Employee();
                e.setName(request.getParameter("name"));
                e.setEmail(request.getParameter("email"));
                e.setPhone(request.getParameter("phone"));
                e.setDepartment(request.getParameter("department"));
                e.setDesignation(request.getParameter("designation"));
                try {
                    e.setSalary(Double.parseDouble(request.getParameter("salary")));
                } catch (NumberFormatException ex) {
                    e.setSalary(0.0);
                }
                e.setAddress(request.getParameter("address"));
                e.setCity(request.getParameter("city"));
                e.setGender(request.getParameter("gender"));
                e.setUserId(createdUser.getId());

                empDao.addEmployee(e);
                response.sendRedirect("employer.jsp");
            } else if ("update".equalsIgnoreCase(action)) {
                // Employer updates
                Employee e = empDao.findById(Integer.parseInt(request.getParameter("id")));
                if (e != null) {
                    e.setName(request.getParameter("name"));
                    e.setEmail(request.getParameter("email"));
                    e.setPhone(request.getParameter("phone"));
                    e.setDepartment(request.getParameter("department"));
                    e.setDesignation(request.getParameter("designation"));
                    try {
                        e.setSalary(Double.parseDouble(request.getParameter("salary")));
                    } catch (NumberFormatException ex) {
                        e.setSalary(0.0);
                    }
                    e.setAddress(request.getParameter("address"));
                    e.setCity(request.getParameter("city"));
                    e.setGender(request.getParameter("gender"));
                    empDao.updateEmployee(e);
                }
                response.sendRedirect("employer.jsp");
            } else if ("employeeUpdate".equalsIgnoreCase(action)) {
                // Employee updates own profile
                String sessionUser = (String) request.getSession().getAttribute("username");
                if (sessionUser != null) {
                    Employee e = empDao.findByUsername(sessionUser);
                    if (e != null && String.valueOf(e.getId()).equals(request.getParameter("id"))) {
                        e.setEmail(request.getParameter("email"));
                        e.setPhone(request.getParameter("phone"));
                        e.setAddress(request.getParameter("address"));
                        e.setCity(request.getParameter("city"));
                        empDao.updateEmployee(e);
                    }
                }
                response.sendRedirect("employee.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            response.sendRedirect("employer.jsp?error=Error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        EmployeeService empDao = new EmployeeService();
        if ("delete".equalsIgnoreCase(action)) {
            try {
                empDao.deleteEmployee(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("employer.jsp");
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
