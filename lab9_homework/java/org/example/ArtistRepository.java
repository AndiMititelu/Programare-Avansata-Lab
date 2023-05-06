package org.example;

import javax.persistence.*;
import java.util.List;

public class ArtistRepository extends AbstractRepository<Artist>{
    public ArtistRepository() {
        super(Artist.class);
    }
}