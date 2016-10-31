package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.activation.DataSource;
import java.sql.*;

public class JdbcTransactionManagerImp implements JdbcTransactionManagerInterface {
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM shop.products WHERE id = ?";
    private static final String GET_PRODUCT_LIST = "SELECT * FROM shop.products;";


    @Override
    public ResultSet selectOne(MysqlDataSource dataSource, int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement pStatement;
        ResultSet result = null;
        try {
            pStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            pStatement.setInt(1, id);
            result = pStatement.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        return result;
    }

    @Override
    public ResultSet selectAll(DataSource dataSource) throws SQLException {
        return null;
    }
}
