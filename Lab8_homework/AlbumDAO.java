package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    public void create(Album album) {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into albums (release_year, title, artist, genre) values (?, ?, ?, ?)")){
            pstmt.setInt(1, album.getReleaseYear());
            pstmt.setString(2, album.getTitle());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getGenres());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
        //cpds.close();
    }
    public List<Album> findAll() {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from albums")){
            try(ResultSet resultSet = pstmt.executeQuery()) {
                List<Album> albumList = new ArrayList<>();
                while (resultSet.next()) {
                    Album album = new Album();
                    album.setArtist(resultSet.getString("artist"));
                    album.setGenres(resultSet.getString("genre"));
                    album.setTitle(resultSet.getString("title"));
                    album.setReleaseYear(resultSet.getInt("release_year"));
                    albumList.add(album);
                }
                if(albumList.isEmpty())
                    return null;
                else
                    return albumList;
            }
        } catch (SQLException e) {
            System.err.println("SQL error in findAll: " + e.getMessage());
            return null;
        }
    }
    public List<Album> findByReleaseYear(int releaseYear) {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from albums where release_year = ?")){
            pstmt.setInt(1, releaseYear);
            try(ResultSet resultSet = pstmt.executeQuery()) {
                List<Album> albumList = new ArrayList<>();
                while (resultSet.next()) {
                    Album album = new Album();
                    album.setArtist(resultSet.getString("artist"));
                    album.setGenres(resultSet.getString("genre"));
                    album.setTitle(resultSet.getString("title"));
                    album.setReleaseYear(resultSet.getInt("release_year"));
                    albumList.add(album);
                }
                if(albumList.isEmpty())
                    return null;
                else
                    return albumList;
            }
        } catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
    }

    public List<Album> findById(int id) {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from albums where id = ?")){
            pstmt.setInt(1, id);
            try(ResultSet resultSet = pstmt.executeQuery()) {
                List<Album> albumList = new ArrayList<>();
                while (resultSet.next()) {
                    Album album = new Album();
                    album.setArtist(resultSet.getString("artist"));
                    album.setGenres(resultSet.getString("genre"));
                    album.setTitle(resultSet.getString("title"));
                    album.setReleaseYear(resultSet.getInt("release_year"));
                    albumList.add(album);
                }
                return albumList;
            }
        } catch (SQLException e) {
            System.err.println("SQL error in findById: " + e.getMessage());
            return null;
        }
    }
    public List<Album> findByTitle(String title){
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where title='"+ title + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genre"));
                album.setTitle(resultSet.getString("title"));
                album.setReleaseYear(Integer.parseInt(resultSet.getString("release_year")));
                albumList.add(album);
                resultSet.next();
            }
            return albumList;
            //return resultSet.next() ? resultSet.getString("title") : null;

        } catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
    }
    public List<Album> findByArtist(String artist){
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where artist='"+ artist + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genre"));
                album.setTitle(resultSet.getString("title"));
                album.setReleaseYear(Integer.parseInt(resultSet.getString("release_year")));
                albumList.add(album);
                resultSet.next();
            }
            return albumList;
            //return resultSet.next() ? resultSet.getString("title") : null;

        } catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
    }
    public List<Album> findByGenre(String genre){
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where genre='"+ genre + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genre"));
                album.setTitle(resultSet.getString("title"));
                album.setReleaseYear(Integer.parseInt(resultSet.getString("release_year")));
                albumList.add(album);
                resultSet.next();
            }
            return albumList;
            //return resultSet.next() ? resultSet.getString("title") : null;

        } catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
    }
}
