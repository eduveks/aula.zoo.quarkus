package org.quarkus.zoo.animal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository animalRepository;

    public List<Animal> findByName(String name) {
        return animalRepository.findByName(name);
    }

    @Transactional
    public Animal create(Animal animal) {
        animal.persistAndFlush();
        return animal;
    }

}
