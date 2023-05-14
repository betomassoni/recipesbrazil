package com.robertomassoni.recipesbrazil.rest.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeResponse {
    private Long id;
    private String title;
    private String description;
    private List<IngredientResponse> ingredients;
    private String instructions;
    private Integer preparationTimeInMinutes;
    private Integer numberOfServings;
    private String dietType;
}
