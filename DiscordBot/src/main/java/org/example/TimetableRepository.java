package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class TimetableRepository {
    protected final EntityManagerFactory emf;

    public TimetableRepository() {
        emf = PersistenceManager.getEntityManagerFactory();
    }

    public void create(Timetable timetable) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(timetable);
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

    public void update(Timetable timetable) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(timetable);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public List<Timetable> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Timetable> query = em.createNamedQuery("Timetable.findAll", Timetable.class);
        return query.getResultList();
    }

    public Timetable findBySubject(String subject) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Timetable> query = em.createNamedQuery("Timetable.findBySubject", Timetable.class);
            query.setParameter(1, subject);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Timetable> findByLocation(String location) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Timetable> query = em.createNamedQuery("Timetable.findByLocation", Timetable.class);
            query.setParameter(1, location);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Timetable> findByDay(Date day) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Timetable> query = em.createNamedQuery("Timetable.findByDay", Timetable.class);
            query.setParameter(1, day);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}

