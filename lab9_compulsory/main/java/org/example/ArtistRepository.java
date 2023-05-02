package org.example;

import javax.persistence.*;
import java.util.List;

public class ArtistRepository {

    private EntityManagerFactory emf;

    public ArtistRepository() {
        emf = PersistenceManager.getEntityManagerFactory();
    }

    public void create(Artist artist) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(artist);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Artist findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Artist.class, id);
        } finally {
            em.close();
        }
    }

    public List<Artist> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
            query.setParameter(1, name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}