package com.robertomassoni.recipesbrazil.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RecipeFilter {
    private String dietType;
    private String instructions;
    private String numberOfServings;
    private String includeIngredient;
    private String excludeIngredient;
}
