package com.robertomassoni.recipesbrazil.rest.api.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import com.robertomassoni.recipesbrazil.rest.api.response.RecipeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IngredientMapper.class})
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe mapFrom(final RecipeRequest source);

    RecipeResponse mapFrom(final Recipe source);
}
