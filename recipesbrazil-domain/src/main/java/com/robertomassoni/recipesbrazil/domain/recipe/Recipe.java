package com.robertomassoni.recipesbrazil.domain.recipe;

import com.robertomassoni.recipesbrazil.domain.enums.DietType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private Long id;
    private String title;
    private String description;
    private List<Ingredient> ingredients;
    private String instructions;
    private Integer preparationTimeInMinutes;
    private Integer numberOfServings;
    private DietType dietType;
}
