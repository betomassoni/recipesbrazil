package com.robertomassoni.recipesbrazil.service.adapters;

import com.robertomassoni.recipesbrazil.core.exception.ResourceAlreadyExistsException;
import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RecipeServiceImpl implements RecipeService {

    public static final String RECIPE_ALREADY_EXISTS_MESSAGE = "Recipe with title '%s' already exists.";
    private RecipePersistence recipePersistence;

    @Override
    public Recipe save(Recipe source) {
        if (recipePersistence.existsByTitle(source.getTitle())) {
            throw new ResourceAlreadyExistsException(String.format(RECIPE_ALREADY_EXISTS_MESSAGE, source.getTitle()));
        }
        return recipePersistence.save(source);
    }

    @Override
    public void delete(Long recipeId) {
        recipePersistence.delete(recipeId);
    }

    @Override
    public List<Recipe> findAllAndFilter(final RecipeFilter filter) {
        return recipePersistence.findAll(filter);
    }
}
