package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingServlet",value = "/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getAttribute("username");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Shopping cart</title>" +
                "</head>" +
                "<body>" +
                "<h2> Welcome <span name=\"username\">"+userName+"</h2>" +
                "<form id=\"shoppingForm\" action=\"CalculateServlet\" method=\"post\">" +
                "  <table>" +
                "    <tr>" +
                "      <td>Sr no</td>" +
                "      <td>Item</td>" +
                "      <td>Price</td>" +
                "      <td>Quantity</td>" +
                "      <td>Buy</td>" +
                "    </tr>" +
                "    <tr>" +
                "      <td>1</td>" +
                "      <td>Dell</td>" +
                "      <td>50000</td>" +
                "      <td><input type=\"number\" name=\"quantity-dell\" ></td>" +
                "      <td><input type=\"checkbox\" name=\"dell\" value=\"buy\"></td>" +
                "    </tr>" +
                "    <tr>" +
                "      <td>2</td>" +
                "      <td>HP</td>" +
                "      <td>70000</td>" +
                "      <td><input type=\"number\" name=\"quantity-hp\" ></td>" +
                "      <td><input type=\"checkbox\" name=\"hp\" value=\"buy\"></td>" +
                "    </tr>" +
                "    <tr>" +
                "      <td>3</td>" +
                "      <td>MAC</td>" +
                "      <td>150000</td>" +
                "      <td><input type=\"number\" name=\"quantity-mac\" ></td>" +
                "      <td><input type=\"checkbox\" name=\"mac\" value=\"buy\"></td>" +
                "    </tr>" +
                "    <tr>" +
                "      <td>4</td>" +
                "      <td>Lenovo</td>" +
                "      <td>65000</td>" +
                "      <td><input type=\"number\" name=\"quantity-lenovo\" ></td>" +
                "      <td><input type=\"checkbox\" name=\"lenovo\" value=\"buy\"></td>" +
                "    </tr>" +
                "  </table>" +
                "  <input type=\"submit\" value=\"Buy\">" +
                "</form>" +
                "</body>" +
                "</html>" 
        );
    }
}
