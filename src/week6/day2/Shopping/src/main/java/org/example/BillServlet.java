package org.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BillServlet",value = "/BillServlet")
public class BillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getAttribute("username");
        Integer amount = (Integer) req.getAttribute("amount");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h1>Bill Servlet</h1>");
        out.print("<p> Thank You " + userName + "</p>");
        out.print("<p> Your Bill Amount : " + amount + "</p>");
        out.print("</body></html>");
    }
}
