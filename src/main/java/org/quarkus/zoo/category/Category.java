package org.quarkus.zoo.category;


import lombok.Data;
import org.quarkus.zoo.animal.Animal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false, unique = true, nullable = false)
    private String uid;

    @NotEmpty
    @Column(name = "title")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Animal> animals;
}
