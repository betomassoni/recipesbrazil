package com.robertomassoni.recipesbrazil.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.ArrayList;
import java.util.List;

@With
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "recipe")
    private List<IngredientEntity> ingredients = new ArrayList<>();

    public void setIngredients(List<IngredientEntity> source) {
        source.forEach(element -> element.setRecipe(this));
        this.ingredients = source;
    }
}