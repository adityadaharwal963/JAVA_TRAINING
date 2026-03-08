package org.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HistoryServlet", value = "/HistoryServlet")
public class HistoryServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();


        String limitParam = req.getParameter("showLimit");
        int limit = 5;
        try {
            if (limitParam != null) limit = Integer.parseInt(limitParam);
        } catch (NumberFormatException e) {
            limit = 5;
        }


        List<Date> fullHistory = (List<Date>) session.getAttribute("fullHistory");
        if (fullHistory == null) {
            fullHistory = new ArrayList<>();
        }


        fullHistory.add(new Date());


        session.setAttribute("fullHistory", fullHistory);


        int totalSize = fullHistory.size();
        int recordsToShow = Math.min(limit, totalSize);


        out.println("<html><body>");
        out.println("<h2>Access History</h2>");
        out.println("<p>Total records stored: " + totalSize + "</p>");
        out.println("<h3>Showing Latest " + recordsToShow + " Access Times:</h3>");
        out.println("<ul>");


        for (int i = totalSize - 1; i >= totalSize - recordsToShow; i--) {
            out.println("<li>" + fullHistory.get(i) + "</li>");
        }


        out.println("</ul>");
        out.println("<hr>");


        out.println("<form action='HistoryServlet' method='post'>");
        out.println("Show last: <input type='number' name='showLimit' value='" + limit + "' style='width:50px;'>");
        out.println("<input type='submit' value='Refresh / Update View'>");
        out.println("</form>");


        out.println("</body></html>");
    }
}

