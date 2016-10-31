package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.test.dao.exceptions.DaoException;
import com.test.dao.exceptions.NoSuchProductException;
import com.test.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDaoImp implements ProductDaoInterface {

    private JdbcTransactionManagerImp tm = new JdbcTransactionManagerImp();
    private MysqlDataSource dataSource = new MysqlDataSource();


    public JdbcProductDaoImp() {
        dataSource.setURL("jdbc:mysql://localhost");
        dataSource.setDatabaseName("shop");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("03042401");
    }

    @Override
    public Product selectById(int id) throws NoSuchProductException {
        Product product;
        try {
            product = tm.selectOne(dataSource, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoSuchProductException("No such product in DB");
        }
        return product;
    }

    @Override
    public List<Product> selectAll() throws DaoException {
        List<Product> list = new ArrayList<>();
        try {
            list =  tm.selectAll(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
