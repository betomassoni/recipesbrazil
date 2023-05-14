package com.robertomassoni.recipesbrazil.rest.api.request;

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
public class IngredientRequest {
    private String description;
}
