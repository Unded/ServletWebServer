package com.test.filters;

import javax.servlet.*;
import java.io.IOException;

public class SecondIdFilter implements Filter {
    private String ID_PARAMETER = "id";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        int id = (Integer) req.getAttribute(ID_PARAMETER);
        if (id == 2){
            req.setAttribute(ID_PARAMETER, 3);
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
