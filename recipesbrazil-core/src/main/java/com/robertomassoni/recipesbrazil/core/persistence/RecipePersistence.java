package com.robertomassoni.recipesbrazil.core.persistence;

import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;

import java.util.List;

public interface RecipePersistence {

    Recipe save(final Recipe source);

    boolean existsByTitle(final String title);

    void delete(final Long recipeId);

    List<Recipe> findAll(final RecipeFilter filter);
}
