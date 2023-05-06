package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreRepository extends AbstractRepository<Genre>{
    public GenreRepository() {
        super(Genre.class);
    }
}
