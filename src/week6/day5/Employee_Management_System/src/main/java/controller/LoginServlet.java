package controller;

import dao.UserDao;
import dao.UserService;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Logger log = Logger.getLogger("LoginServlet");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleParam = request.getParameter("role");
        UserDao userDao = new UserService();

        if (username == null || password == null || roleParam == null) {
            response.sendRedirect("index.jsp?error=Missing credentials");
            return;
        }

        try {
            if (userDao.verfiyUser(username, password)) {
                User user = userDao.getUserByUsername(username);
                if (user != null && user.getRole().equalsIgnoreCase(roleParam)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("role", user.getRole());

                    if (user.getRole().equalsIgnoreCase("EMPLOYER")) {
                        response.sendRedirect("employer.jsp");
                    } else {
                        response.sendRedirect("employee.jsp");
                    }
                } else {
                    response.sendRedirect("index.jsp?error=Invalid Role");
                }
            } else {
                response.sendRedirect("index.jsp?error=Invalid Credentials");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=System Error");
        }
    }
}
