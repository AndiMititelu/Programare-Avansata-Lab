package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    public void create(String name) {

        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into genre (name) values (?)")){
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
    public List<Genre> findAll() {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from genre")){
            try(ResultSet resultSet = pstmt.executeQuery()) {
                List<Genre> genreList = new ArrayList<>();
                while (resultSet.next()) {
                    Genre genre = new Genre();
                    genre.setName(resultSet.getString("name"));
                    genreList.add(genre);
                }
                if(genreList.isEmpty())
                    return null;
                else
                    return genreList;
            }
        } catch (SQLException e) {
            System.err.println("SQL error in findAll: " + e.getMessage());
            return null;
        }
    }
    public List<Genre> findById(int id) {
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from genre where id='"+ id + "'")) {
            List<Genre> genreList = new ArrayList<>();
            while(resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("name"));
                genreList.add(genre);
                resultSet.next();
            }
            return genreList;
        }
        catch (SQLException e) {
            System.err.println("SQL error in findById: " + e.getMessage());
            return null;
        }
    }
    public List<Genre> findByName(String name) {
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from genre where name='"+ name + "'")) {
            List<Genre> genreList = new ArrayList<>();
            while(resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("name"));
                genreList.add(genre);
                resultSet.next();
            }
            return genreList;
        }
        catch (SQLException e) {
            System.err.println("SQL error in findByName: " + e.getMessage());
            return null;
        }
    }

}
