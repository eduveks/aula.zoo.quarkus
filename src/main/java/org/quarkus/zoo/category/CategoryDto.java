package org.quarkus.zoo.category;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class CategoryDto {
    private String uid;

    @NotEmpty(message = "Nome obrigatório.")
    @Length(min = 3, message= "No mínimo 3 caracteres.")
    private String name;
}
