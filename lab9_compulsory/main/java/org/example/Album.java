package org.example;

import javax.persistence.*;
import java.io.Serializable;
/*
@Entity
@Table(name = "albums")
@NamedQueries({
    @NamedQuery(name = "Album.findAll",
            query = "select e from Album e order by e.release_year"),
})

 */

public class Album{
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    private Integer id;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "genres")
    private String genres;
    public Album() {}
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

     */


}
