package com.robertomassoni.recipesbrazil.rest.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.List;

@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {
    private Long id;
    private String title;
    private String description;
    private List<IngredientRequest> ingredients;
    private String instructions;
    private Integer preparationTimeInMinutes;
    private Integer numberOfServings;
    private String dietType;
}
