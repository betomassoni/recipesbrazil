package com.robertomassoni.recipesbrazil.core.persistence;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;

public interface RecipePersistence {

    Recipe save(final Recipe source);

    boolean existsByTitle(final String title);
}
