package org.quarkus.zoo.animal;

import org.quarkus.zoo.category.CategoryMapper;

public class AnimalMapper {
    public static Animal dtoToEntity(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.name = animalDto.getName();
        if (animalDto.getCategory() != null) {
            animal.category = CategoryMapper.dtoToEntity(animalDto.getCategory());
        }
        return animal;
    }

    public static AnimalDto entityToDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(animal.name);
        if (animal.category != null) {
            animalDto.setCategory(
                    CategoryMapper.entityToDto(animal.category)
            );
        }
        return animalDto;
    }
}
