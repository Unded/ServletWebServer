package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.test.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface JdbcTransactionManagerInterface {

    Product selectOne(MysqlDataSource dataSource, int id) throws SQLException;

    List<Product> selectAll(MysqlDataSource dataSource) throws SQLException;
}
