package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private static ComboPooledDataSource dataSource;
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
