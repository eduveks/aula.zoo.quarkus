package org.quarkus.zoo.animal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<Animal> {
    public List<Animal> findByName(String name) {
        return find("FROM Animal a JOIN FETCH a.category c WHERE a.name LIKE ?1", "%"+ name +"%").list();
    }

    public List<Animal> findByCategory(String name) {
        return find("FROM Animal a JOIN FETCH a.category c WHERE c.name LIKE ?1", "%"+ name +"%").list();
    }
}
