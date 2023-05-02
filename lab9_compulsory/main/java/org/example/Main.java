package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        ArtistRepository artistRepository = new ArtistRepository();

        Artist artist1 = new Artist("Optimus Prime");
        Artist artist2 = new Artist("Chat GPT");
        artistRepository.create(artist1);
        artistRepository.create(artist2);

        List<Artist> artists = artistRepository.findByName("Chat GPT");
        System.out.println(artists);
        System.out.println(artistRepository.findById(2));

    }
}