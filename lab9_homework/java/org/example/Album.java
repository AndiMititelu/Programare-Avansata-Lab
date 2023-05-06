package org.example;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "albums")
@NamedQueries({
    @NamedQuery(name = "Album.findAll",
            query = "select e from Album e order by e.title"),
    @NamedQuery(name = "Album.findByTitle",
            query = "select a from Album a where a.title = ?1"),
    @NamedQuery(name = "Album.findByReleaseYear",
            query = "select a from Album a where a.releaseYear = ?1"),
    @NamedQuery(name = "Album.findByArtist",
            query = "select a from Album a where a.artist = ?1"),
    @NamedQuery(name = "Album.findByGenre",
            query = "select a from Album a where a.genres = ?1"),
})
public class Album implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    private Integer id;
    @Column(name = "releaseYear")
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
}
