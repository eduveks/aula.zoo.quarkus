package org.quarkus.zoo.category;

public class CategoryMapper {
    public static Category dtoToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setUid(categoryDto.getUid());
        category.setName(categoryDto.getName());
        return category;
    }

    public static CategoryDto entityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setUid(category.getUid());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
