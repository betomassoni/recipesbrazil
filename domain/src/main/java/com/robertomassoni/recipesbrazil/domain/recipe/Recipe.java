package com.robertomassoni.recipesbrazil.domain.recipe;

import com.robertomassoni.recipesbrazil.domain.enums.DietType;

import java.util.List;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private List<Ingredient> ingredientList;
    private String instructions;
    private Integer preparetionTimeInMinutes;
    private Integer numberOfServings;
    private DietType dietType;
}
