package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<T> {

    protected final EntityManagerFactory emf;
    private final Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.emf = PersistenceManager.getEntityManagerFactory();
        this.entityClass = entityClass;
    }
    protected EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }


    public void create(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
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

    public T findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<T> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<T> query = em.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
            query.setParameter(1, name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
