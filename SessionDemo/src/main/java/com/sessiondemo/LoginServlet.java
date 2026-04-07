package com.sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");

        // SESSION CREATE
        HttpSession hs = req.getSession();

        // STORE DATA
        hs.setAttribute("user", name);

        out.println("<h2>Login Successful</h2>");
        out.println("<a href='home'>Go to Home</a>");
    }
}