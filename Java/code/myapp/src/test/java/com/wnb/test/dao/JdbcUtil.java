package com.wnb.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil {

    public static Connection getConnection(){
        Connection conn = null;
        ResourceBundle rs = ResourceBundle.getBundle("dbunit");
        try {
            Class.forName(rs.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        try {
            conn = DriverManager.getConnection(rs.getString("url"), rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conn;
    }
}
