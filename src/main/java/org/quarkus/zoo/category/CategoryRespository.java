package org.quarkus.zoo.category;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CategoryRespository implements PanacheRepository<Category> {
    public Category findByUid(String uid) {
        return find("uid = ?1", uid).firstResult();
    }

    public List<Category> findByName(String name) {
        return find("name = ?1", name).list();
    }
}
