package org.quarkus.zoo.animal;

import lombok.Data;
import org.quarkus.zoo.category.CategoryDto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class AnimalDto {

    @NotEmpty(message = "Nome obrigatório.")
    @Length(min = 3, message= "No mínimo 3 caracteres.")
    private String name;

    @Min(value = 10, message = "A idade mínima é de 10 anos.")
    @Max(value = 150, message = "A idade máxima é de 150 anos.")
    private int age;

    private CategoryDto category;
}
