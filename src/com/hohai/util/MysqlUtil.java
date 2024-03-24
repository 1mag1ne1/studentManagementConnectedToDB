package com.hohai.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlUtil {
    public static String url;
    public static String user;
    public static String password;
    static {
        try {
            InputStream inputStream =ClassLoader.getSystemResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnectionMine() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void closeMysql(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        if(connection != null){
            connection.close();
        }
        if(preparedStatement !=null){
            preparedStatement.close();
        }
    }
}
