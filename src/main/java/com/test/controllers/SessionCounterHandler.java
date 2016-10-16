package com.test.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "SessionCounterHandler", urlPatterns = "session_counter")
public class SessionCounterHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        AtomicInteger counter = (AtomicInteger) session.getAttribute("counter");
        if (counter == null){
            counter = new AtomicInteger(1);
            session.setAttribute("counter", counter);
            response.getWriter().write("Hello, you are first time here!");
        }else{
            int countOfVisits = counter.incrementAndGet();
            response.getWriter().write("You visit this page " + countOfVisits + " times.");
        }
    }
}
