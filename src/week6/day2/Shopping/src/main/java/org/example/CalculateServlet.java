package org.example;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet",value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String dell = (String) req.getParameter("dell");
        String hp = (String) req.getParameter("hp");
        String mac = (String) req.getParameter("mac");
        String lenovo = (String) req.getParameter("lenovo");
        String quantity_dell = req.getParameter("quantity-dell");
        String quantity_mac = req.getParameter("quantity-mac");
        String quantity_hp = req.getParameter("quantity-hp");
        String quantity_lenovo = req.getParameter("quantity-lenovo");


        int amount = 0;
        if(dell!=null && quantity_dell==null ){
            amount = amount + Integer.parseInt(quantity_dell);
        }
        if(hp!=null && quantity_mac==null ){
            amount = amount + + Integer.parseInt(quantity_hp);
        }
        if(mac!=null){
            String quantity = req.getParameter("quantity-mac");
            int d = Integer.parseInt(quantity);
            amount = amount + d;
        }
        if(lenovo!=null){
            String quantity = req.getParameter("quantity-lenovo");
            int d = Integer.parseInt(quantity);
            amount = amount + d;
        }
        req.setAttribute("username",username);
        req.setAttribute("amount",amount);
        RequestDispatcher dispatcher = req.getRequestDispatcher("BillServlet");
        dispatcher.forward(req,resp);

    }
}
