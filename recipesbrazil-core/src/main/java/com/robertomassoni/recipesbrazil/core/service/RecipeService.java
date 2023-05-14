package com.robertomassoni.recipesbrazil.core.service;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;

public interface RecipeService {

    Recipe save(final Recipe source);

    void delete(final Long recipeId);
}
