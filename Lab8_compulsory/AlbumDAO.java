package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//albums: id, release year, title, artist, genre(s)
public class AlbumDAO {
    public AlbumDAO() {}
   public void create(int releaseYear, String title, String artist, String genres) {
       Connection connection = Database.getConnection();
       try(PreparedStatement pstmt = connection.prepareStatement("insert into albums (release_year, title, artist, genres) values (?, ?, ?, ?)")){
           pstmt.setInt(1, releaseYear);
           pstmt.setString(2, title);
           pstmt.setString(3, artist);
          // StringBuilder genresString = new StringBuilder();
           pstmt.setString(4, genres);
           pstmt.executeUpdate();
       } catch (SQLException e) {
           System.err.println("SQL error: " + e.getMessage());
       }
   }
   public List<Album> findByReleaseYear(int releaseYear){
        Connection connection = Database.getConnection();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where release_year='"+ releaseYear + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genres"));
                album.setTitle(resultSet.getString("title"));
                album.setRelease_year(Integer.parseInt(resultSet.getString("release_year")));
                albumList.add(album);
                resultSet.next();
            }
            if(albumList.isEmpty())
                return null;
            else
                return albumList;
            //return resultSet.next() ? resultSet.getString("title") : null;

        } catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
   }

   public List<Album> findById(int id) {
        Connection connection = Database.getConnection();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where id='"+ id + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genres"));
                album.setTitle(resultSet.getString("title"));
                album.setRelease_year(Integer.parseInt(resultSet.getString("release_year")));
                albumList.add(album);
                resultSet.next();
            }
            return albumList;
        }
        catch (SQLException e) {
            System.err.println("SQL error in findByReleaseYear: " + e.getMessage());
            return null;
        }
   }

    public List<Album> findByTitle(String title){
        Connection connection = Database.getConnection();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where title='"+ title + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genres"));
                album.setTitle(resultSet.getString("title"));
                album.setRelease_year(Integer.parseInt(resultSet.getString("release_year")));
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
        Connection connection = Database.getConnection();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where artist='"+ artist + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genres"));
                album.setTitle(resultSet.getString("title"));
                album.setRelease_year(Integer.parseInt(resultSet.getString("release_year")));
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
        Connection connection = Database.getConnection();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from albums where genres='"+ genre + "'")) {
            List<Album> albumList = new ArrayList<>();
            while(resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString("artist"));
                album.setGenres(resultSet.getString("genres"));
                album.setTitle(resultSet.getString("title"));
                album.setRelease_year(Integer.parseInt(resultSet.getString("release_year")));
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
