package com.robertomassoni.recipesbrazil.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instructions", nullable = false)
    private byte[] instructions;

    @Column(name = "preparation_time_in_minutes", nullable = false)
    private Integer preparationTimeInMinutes;

    @Column(name = "number_of_servings", nullable = false)
    private Integer numberOfServings;

    @Column(name = "diet_type", nullable = false, length = 20)
    private String dietType;

}