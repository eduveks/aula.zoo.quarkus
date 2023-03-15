package org.quarkus.zoo.animal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.quarkus.zoo.category.Category;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal extends PanacheEntity {
    public String name;
    public int age;

    @ManyToOne
    public Category category;
}
