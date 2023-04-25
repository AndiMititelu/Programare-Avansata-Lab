package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumDAOtest {
    private static AlbumDAO albumDao;
    @BeforeAll
    public static void setUp() {
        albumDao = new AlbumDAO();
    }

    @AfterAll
    public static void tearDown() {
        Database.closeConnection();
        //albumDao.close();
    }
    @Test
    public void testFindByReleaseYear() {
        AlbumDAO albumDao = new AlbumDAO();
        albumDao.create(2000, "Sample title", "CuteArtist", "Rap");
        List<Album> albumFound = new ArrayList<>();
        albumFound = albumDao.findByReleaseYear(2000);
        for(Album album : albumFound){
            assertNotNull(album);
            assertEquals("Sample title", album.getTitle());
            assertEquals("CuteArtist", album.getArtist());
            assertEquals("Rap", album.getGenres());
        }
        assertNull(this.albumDao.findByReleaseYear(2022));

    }
}
