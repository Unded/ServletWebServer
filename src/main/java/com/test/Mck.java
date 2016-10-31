package com.test;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

public class Mck {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("shop");
        dataSource.setURL("jdbc:mysql://localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("03042401");

        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM shop.products;");
        while (result.next()){
            System.out.print(result.getInt("id") + " - ");
            System.out.println(result.getString("product_name"));
        }
//        getOne(2);
//        getAll();
    }

    private static void getOne(int id) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "03042401");
        PreparedStatement pSt = con.prepareStatement("SELECT * FROM shop.products WHERE id = ?");
        pSt.setInt(1, id);
        ResultSet result = pSt.executeQuery();
        while (result.next()){
            System.out.print(result.getString("id") + " - ");
            System.out.println(result.getString("product_name"));
        }
    }

    private static void getAll() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "03042401");
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM shop.products;");
        while (result.next()){
            System.out.print(result.getString("id") + " - ");
            System.out.println(result.getString("product_name"));
        }
    }
}
