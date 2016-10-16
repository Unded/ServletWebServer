package com.test.controllers;

import com.test.dao.ProductDaoImpl;
import com.test.dao.exceptions.DaoException;
import com.test.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllProductsController", urlPatterns = "allproducts")
public class ShowAllProductsController extends HttpServlet {

    private ProductDaoImpl data = new ProductDaoImpl();
    private String ATTRIBUTE_FOR_VIEW = "productList";
    private String PAGE_ALL_PRODUCTS = "allproducts.jsp";
    private String PAGE_DB_ERROR = "dberror.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> productList = data.selectAll();
            if (productList != null) {
                request.setAttribute(ATTRIBUTE_FOR_VIEW, productList);
                request.getRequestDispatcher(PAGE_ALL_PRODUCTS).forward(request, response);
            }else {
                response.sendRedirect(PAGE_DB_ERROR);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
