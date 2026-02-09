package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String s1 = req.getParameter("input1");
        String s2 = req.getParameter("input2");

        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Both inputs are required");
            return;
        }

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        float res = 0;

        if (req.getParameter("add") != null) {
            res = a + b;
        } else if (req.getParameter("sub") != null) {
            res = a - b;
        } else if (req.getParameter("mul") != null) {
            res = a * b;
        } else if (req.getParameter("div") != null) {
            if (b == 0) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cannot divide by zero");
                return;
            }
            res = (float) a / b;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>Calculator</title>
            </head>
            <body>
                <form method="post" action="CalServlet">
                    Input 1: <input type="number" name="input1" value="%d"><br><br>
                    Input 2: <input type="number" name="input2" value="%d"><br><br>
                    Result:  <input type="number" value="%f" readonly><br><br>

                    <input type="submit" name="add" value="+">
                    <input type="submit" name="sub" value="-">
                    <input type="submit" name="mul" value="*">
                    <input type="submit" name="div" value="/">
                </form>
            </body>
            </html>
        """.formatted(a, b, res));
    }
}
