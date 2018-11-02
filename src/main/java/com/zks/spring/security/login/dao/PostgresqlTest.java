package com.zks.spring.security.login.dao;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by Administrator on 2018/11/1.
 */
public class PostgresqlTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.4:5432/sc",
                    "postgres", "admin");
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_authorities;");
            while (rs.next()) {
                String name = rs.getString("username");
                String type = rs.getString("authority");
                System.out.println("NAME = " + name);
                System.out.println("TYPE = " + type);
                System.out.println();
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
