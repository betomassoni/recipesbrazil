package com.robertomassoni.recipesbrazil.service.adapters;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecipeServiceImpl implements RecipeService {

    private RecipePersistence recipePersistence;

    @Override
    public Recipe save(Recipe source) {
        return recipePersistence.save(source);
    }
}
