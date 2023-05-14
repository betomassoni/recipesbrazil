package com.robertomassoni.recipesbrazil.persistence.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CommonsMapper.class, IngredientEntityMapper.class})
public interface RecipeEntityMapper {
    RecipeEntityMapper INSTANCE = Mappers.getMapper(RecipeEntityMapper.class);

    Recipe mapFrom(final RecipeEntity source);

    RecipeEntity mapFrom(final Recipe source);
}

