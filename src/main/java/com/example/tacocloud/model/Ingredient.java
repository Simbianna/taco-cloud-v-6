package com.example.tacocloud.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
// Book page 87. JPA requires that entities have a no-arguments constructor, so Lombok’s @NoArgsConstructor does that for you.
// You don’t want to be able to use it, though, so you make it private by setting the access attribute to AccessLevel.PRIVATE.
// And because you must set final properties, you also set the force attribute to true,
// which results in the Lombok-generated constructor setting them to a default value of null, 0, or false, depending on the property type.
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient {

    @Id
    private String id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}