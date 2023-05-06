package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        //ArtistRepository artistRepository = new ArtistRepository();
        //AlbumRepository albumRepository = new AlbumRepository();

        //Artist artist1 = new Artist("Optimus Prime");
        //Artist artist2 = new Artist("Chat GPT");
        //artistRepository.create(artist1);
        //artistRepository.create(artist2);

        //List<Artist> artists = artistRepository.findByName("Chat GPT");
        //System.out.println(artists);
        //System.out.println(artistRepository.findById(2));

        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            Artist artist = new Artist("Fake Artist " + i);
            artistRepository.create(artist);

            Album album = new Album(2000 + i % 20, "Fake Album " + i, artist.getName(), "Fake Genre");
            albumRepository.create(album);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + "ms");
    }
}
