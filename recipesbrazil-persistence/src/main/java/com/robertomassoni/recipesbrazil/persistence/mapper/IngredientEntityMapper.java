package com.robertomassoni.recipesbrazil.persistence.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Ingredient;
import com.robertomassoni.recipesbrazil.persistence.entity.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientEntityMapper {
    IngredientEntityMapper INSTANCE = Mappers.getMapper(IngredientEntityMapper.class);

    Ingredient mapFrom(final IngredientEntity source);

    IngredientEntity mapFrom(final Ingredient source);
}
