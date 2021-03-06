package com.test.controllers;

import com.test.dao.ProductDaoImpl;
import com.test.dao.exceptions.NoSuchProductException;
import com.test.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController", urlPatterns = "product")
public class ProductController extends HttpServlet {

    private ProductDaoImpl data = new ProductDaoImpl();

    private String ID_PARAMETER = "id";
    private String ATTRIBUTE_FOR_VIEW = "product";
    private String PAGE_OK = "product.jsp";
    private String PAGE_ERROR = "error.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (Integer) request.getAttribute(ID_PARAMETER);
        try {

            Product productModel = data.selectById(id);
            if (productModel != null) {
                request.setAttribute(ATTRIBUTE_FOR_VIEW, productModel);
                request.getRequestDispatcher(PAGE_OK).forward(request, response);
            } else {
                request.setAttribute(ATTRIBUTE_FOR_VIEW, new Product(id, "Product not found"));
                request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
            }

        } catch (NoSuchProductException e) {
            e.printStackTrace();
        }
    }
}
