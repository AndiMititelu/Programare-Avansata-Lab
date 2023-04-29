package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/lab8";
    private static final String username = "postgres";
    private static final String password = "admin";
    private static Connection connection = null;

    private Database() {
    }
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public static void createTables() {
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            String albumsTable = "CREATE TABLE IF NOT EXISTS albums (id SERIAL PRIMARY KEY, release_year INTEGER, title TEXT, artist TEXT, genres TEXT)";
            String artistsTable = "CREATE TABLE IF NOT EXISTS artists (id SERIAL PRIMARY KEY, name TEXT)";
            String genresTable = "CREATE TABLE IF NOT EXISTS genre (id SERIAL PRIMARY KEY, name TEXT)";
            stmt.executeUpdate(albumsTable);
            stmt.executeUpdate(artistsTable);
            stmt.executeUpdate(genresTable);
            System.out.println("Tables created successfully");

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}
