package com.robertomassoni.recipesbrazil.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty(message = "Field 'title' is required")
    private String title;

    private String description;

    @NotEmpty(message = "At least one ingredient is required")
    private List<IngredientRequest> ingredients;

    @NotEmpty(message = "Field 'instructions' is required")
    private String instructions;

    @NotNull(message = "Field 'preparation_time_in_minutes' is required")
    @JsonProperty("preparation_time_in_minutes")
    private Integer preparationTimeInMinutes;

    @NotNull(message = "Field 'number_of_servings' is required")
    @JsonProperty("number_of_servings")
    private Integer numberOfServings;

    @NotEmpty(message = "Field 'diet_type' is required")
    @JsonProperty("diet_type")
    private String dietType;
}
