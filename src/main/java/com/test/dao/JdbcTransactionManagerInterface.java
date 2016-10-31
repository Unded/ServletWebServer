package com.test.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.activation.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JdbcTransactionManagerInterface {

    ResultSet selectOne(MysqlDataSource dataSource, int id) throws SQLException;

    ResultSet selectAll(DataSource dataSource) throws SQLException;
}
