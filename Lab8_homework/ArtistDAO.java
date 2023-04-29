package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();
    public void create(Artist artist) {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into artists (name) values (?)")){
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
    public List<Artist> findAll() {
        try(Connection connection = cpds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from artists")){
            try(ResultSet resultSet = pstmt.executeQuery()) {
                List<Artist> artistList = new ArrayList<>();
                while (resultSet.next()) {
                    Artist artist = new Artist();
                    artist.setName(resultSet.getString("name"));
                    artistList.add(artist);
                }
                if(artistList.isEmpty())
                    return null;
                else
                    return artistList;
            }
        } catch (SQLException e) {
            System.err.println("SQL error in findAll: " + e.getMessage());
            return null;
        }
    }
    public List<Artist> findById(int id) {
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from artists where id='"+ id + "'")) {
            List<Artist> artistList = new ArrayList<>();
            while(resultSet.next()) {
                Artist artist = new Artist();
                artist.setName(resultSet.getString("name"));
                artistList.add(artist);
                resultSet.next();
            }
            return artistList;
        }
        catch (SQLException e) {
            System.err.println("SQL error in findById: " + e.getMessage());
            return null;
        }
    }
    public List<Artist> findByName(String name) {
        try(Connection connection = cpds.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from artists where name='"+ name + "'")) {
            List<Artist> artistList = new ArrayList<>();
            while(resultSet.next()) {
                Artist artist = new Artist();
                artist.setName(resultSet.getString("name"));
                artistList.add(artist);
                resultSet.next();
            }
            return artistList;
        }
        catch (SQLException e) {
            System.err.println("SQL error in findByName: " + e.getMessage());
            return null;
        }
    }
}
