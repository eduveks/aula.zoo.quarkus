package org.quarkus.zoo;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.quarkus.zoo.animal.Animal;
import org.quarkus.zoo.animal.AnimalService;
import org.quarkus.zoo.category.Category;
import org.quarkus.zoo.category.CategoryService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class LifecycleBean {

    @Inject
    public CategoryService categoryService;

    @Inject
    public AnimalService animalService;

    private static final Logger LOGGER = Logger.getLogger("MyLifecycleBean");

    public void onStart(@Observes StartupEvent ev) {
        Category category1 = new Category();
        category1.setName("Mamífero");
        categoryService.create(category1);
        Category category2 = new Category();
        category2.setName("Ave");
        categoryService.create(category2);

        Animal animal1 = new Animal();
        animal1.name = "Rinosceronte";
        animal1.category = category1;
        animalService.create(animal1);
        Animal animal2 = new Animal();
        animal2.name = "Urubu";
        animal2.category = category2;
        animalService.create(animal2);
        LOGGER.error("QUARKUS INICIOU!!!");
    }

    public void onStop(@Observes ShutdownEvent ev) {
        LOGGER.fatal("QUARKUS FINALIZOU!!!");
    }

}
