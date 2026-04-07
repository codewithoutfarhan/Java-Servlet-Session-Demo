package com.sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession hs = req.getSession(false);

        if (hs != null) {

            String name = (String) hs.getAttribute("user");

            out.println("<h2>Welcome " + name + "</h2>");
            out.println("<a href='logout'>Logout</a>");

        } else {
            out.println("<h2>No session found</h2>");
        }
    }
}