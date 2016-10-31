package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.test.dao.exceptions.DaoException;
import com.test.dao.exceptions.NoSuchProductException;
import com.test.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcProductDaoImp implements ProductDaoInterface {

    JdbcTransactionManagerImp tm = new JdbcTransactionManagerImp();
    private static MysqlDataSource dataSource = new MysqlDataSource();

    Product product = new Product();

    public JdbcProductDaoImp() {

        dataSource.setURL("jdbc:mysql://localhost");
        dataSource.setDatabaseName("shop");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("03042401");
    }

    @Override
    public Product selectById(int id) throws NoSuchProductException {

//        try {
//            Connection con = dataSource.getConnection();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM shop.products WHERE id = 2");
//            if (rs != null) {
//                while (rs.next()) {
//                    product.setId(rs.getInt("id"));
//                    product.setName(rs.getString("product_name"));
//                }
//            }else {
//                System.err.println("!!!NULL !!!!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            ResultSet result = tm.selectOne(dataSource, id);
            if (result != null){
                while (result.next()){
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("product_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoSuchProductException("No such product in DB");
        }
        return product;
    }

    @Override
    public List<Product> selectAll() throws DaoException {
        return null;
    }

}
