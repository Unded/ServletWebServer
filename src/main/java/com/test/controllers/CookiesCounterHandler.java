package com.test.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookiesCounterHandler", urlPatterns = "cookie_counter")
public class CookiesCounterHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie counter = null;

        for (Cookie element : cookies){
            if("counter".equals(element.getName())){
                counter = element;
                break;
            }
        }

        if (counter == null){
            response.addCookie(new Cookie("counter", "1"));
            response.getWriter().write("Hello, you are first time here!");
        }else{
            int countOfVisits = Integer.valueOf(counter.getValue());
            response.addCookie(new Cookie("counter", "" + ++countOfVisits));
            response.getWriter().write("You visit this page " + countOfVisits + " times.");
        }

    }
}
