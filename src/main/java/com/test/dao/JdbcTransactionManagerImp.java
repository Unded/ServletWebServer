package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.test.entity.Product;

import javax.activation.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransactionManagerImp implements JdbcTransactionManagerInterface {

    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM shop.products WHERE id = ?";
    private static final String GET_PRODUCT_LIST = "SELECT * FROM shop.products;";

    @Override
    public Product selectOne(MysqlDataSource dataSource, int id) throws SQLException {
        Product product = new Product();
        PreparedStatement pStatement;
        ResultSet result;
        try (Connection connection = dataSource.getConnection()) {
            pStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            pStatement.setInt(1, id);
            result = pStatement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("product_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAll(MysqlDataSource dataSource) throws SQLException {
        List<Product> list = new ArrayList<>();
        int counter = 0;
        try(Connection connection = dataSource.getConnection()){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM shop.products;");
            while (rs.next()){
                list.add(counter++, new Product(rs.getInt("id"), rs.getString("product_name")));
            }
        }
        return list;
    }
}
