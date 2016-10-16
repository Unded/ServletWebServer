package com.test.dao;

import com.test.dao.exceptions.DaoException;
import com.test.dao.exceptions.NoSuchProductException;
import com.test.entity.Product;

import java.util.List;

public interface ProductDaoInterface {

    Product selectById(int id) throws NoSuchProductException, DaoException;

    List<Product> selectAll() throws DaoException;
}
