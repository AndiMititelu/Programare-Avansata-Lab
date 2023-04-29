package org.example;

public class Album {
    int releaseYear;
    String title;
    String artist;
    String genres;

    public Album() {
    }

    public Album(int releaseYear, String title, String artist, String genres) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Album - release_year: " + releaseYear + ", title: " + title + ", artist: " + artist + ", genres: " + genres;
    }
}
