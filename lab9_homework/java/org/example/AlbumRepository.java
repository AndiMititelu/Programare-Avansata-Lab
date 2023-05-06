package org.example;

import org.hibernate.loader.plan.build.internal.AbstractLoadPlanBuildingAssociationVisitationStrategy;

import javax.persistence.*;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album> {

    public AlbumRepository() {
        super(Album.class);
    }

    public List<Album> findByReleaseYear(Integer releaseYear) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Album> query = em.createNamedQuery("Album.findByReleaseYear", Album.class);
            query.setParameter(1, releaseYear);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Album> findByArtist(String artist) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Album> query = em.createNamedQuery("Album.findByArtist", Album.class);
            query.setParameter(1, artist);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Album> findByTitle(String title) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Album> query = em.createNamedQuery("Album.findByTitle", Album.class);
            query.setParameter(1, title);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Album> findByGenre(String genre) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Album> query = em.createNamedQuery("Album.findByGenre", Album.class);
            query.setParameter(1, genre);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


}