package com.sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession hs = req.getSession(false);

        if (hs != null) {
            hs.invalidate();
            out.println("<h2>Logged out</h2>");
        }

        out.println("<a href='index.html'>Login Again</a>");
    }
}