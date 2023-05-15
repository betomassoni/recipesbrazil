package com.robertomassoni.recipesbrazil.core.service;

import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save(final Recipe source);

    void delete(final Long recipeId);

    List<Recipe> findAllAndFilter(final RecipeFilter filter);
}
