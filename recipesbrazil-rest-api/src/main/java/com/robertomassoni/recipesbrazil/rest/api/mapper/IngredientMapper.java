package com.robertomassoni.recipesbrazil.rest.api.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Ingredient;
import com.robertomassoni.recipesbrazil.rest.api.request.IngredientRequest;
import com.robertomassoni.recipesbrazil.rest.api.response.IngredientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    Ingredient mapFrom(final IngredientRequest source);

    IngredientResponse mapFrom(final Ingredient source);
}
