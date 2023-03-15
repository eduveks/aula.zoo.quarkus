package org.quarkus.zoo.category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CategoryService {
    @Inject
    public CategoryRespository categoryRespository;

    public List<Category> findAll() {
        return categoryRespository.findAll().list();
    }

    public Category findByUid(UUID uuid) {
        return categoryRespository.findByUid(uuid.toString());
    }

    public List<Category> findByName(String name) {
        return categoryRespository.findByName(name);
    }

    @Transactional
    public void create(Category category) {
        category.setUid(UUID.randomUUID().toString());
        categoryRespository.persistAndFlush(category);
    }

    @Transactional
    public void update(Category category) {
        Category categoryBase = findByUid(UUID.fromString(category.getUid()));
        categoryBase.setName(category.getName());
        categoryRespository.persistAndFlush(categoryBase);
    }

    @Transactional
    public void remove(UUID uid) {
        categoryRespository.delete(findByUid(uid));
    }
}
