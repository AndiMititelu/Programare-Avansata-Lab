package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private LocalDateTime creationTime;
    private List<Album> albumList;

    public Playlist(String name) {
        this.name = name;
        this.creationTime = LocalDateTime.now();
        albumList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }
    public void addAlbum(Album album) {
        albumList.add(album);
    }
    public void removeAlbum(Album album) {
        albumList.remove(album);
    }
}
