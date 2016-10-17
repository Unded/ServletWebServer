package com.test.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "FirstIdFilter", servletNames = "ProductController")
public class FirstIdFilter implements Filter {
    private String ID_PARAMETER = "id";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID_PARAMETER));
        if (id == 1){
            req.setAttribute(ID_PARAMETER, 2);
            chain.doFilter(req, resp);
        }else {
            req.setAttribute(ID_PARAMETER, id);
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
