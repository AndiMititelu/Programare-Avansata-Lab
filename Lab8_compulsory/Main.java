package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database.createConnection();
        Database.createTables();
        AlbumDAO albumDao = new AlbumDAO();
        //albumDao.create(2010, "Teoria Grafurilor Muzicale", "ACF", "Jazz");
        //albumDao.create(2010, "Java How to Pass", "ChatGPT", "Rock");
        System.out.println(albumDao.findByReleaseYear(2010));
        System.out.println(albumDao.findByArtist("ACF"));
        System.out.println(albumDao.findByTitle("Teoria Grafurilor Muzicale"));



    }
}