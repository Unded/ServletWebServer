package com.test.dao;

import com.test.dao.exceptions.DaoException;
import com.test.dao.exceptions.NoSuchProductException;
import com.test.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDaoInterface {

    private Map<Integer, Product> data;

    public ProductDaoImpl() {
        data.put(1, new Product("Milk"));
        data.put(2, new Product("Bread"));
        data.put(3, new Product("Chocolate"));
    }

    public Product selectById(int id) throws NoSuchProductException, DaoException {
        if (data.containsKey(id)) {
            return data.get(id);
        }else {
            throw new NoSuchProductException("No such element in DB.");
        }
    }

    public List<Product> selectAll() throws DaoException {
        if (data.isEmpty()){
            throw new DaoException("DB is empty.");
        }else {
            return data.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        }
    }
}
