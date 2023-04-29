package org.example;

public class Main {
    public static void main(String[] args) {

        //Database.createConnection();
        //Database.createTables();
        AlbumDAO albumDAO = new AlbumDAO();
        Album album = new Album(2000, "Sample Title", "NewArtist", "Reggae");
        //albumDAO.create(album);
        System.out.println(albumDAO.findByReleaseYear(1982));
        //AlbumImporter.importAlbum();

        //TODO: Playlist: name, creation timestamp and a set of albums
    }
}