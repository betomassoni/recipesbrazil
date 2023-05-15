package com.robertomassoni.recipesbrazil.rest.api.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import com.robertomassoni.recipesbrazil.rest.api.response.RecipeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {IngredientMapper.class})
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mapping(target = "id", ignore = true)
    @ValueMapping(source = "dietType", target = MappingConstants.NULL)
    Recipe mapFrom(final RecipeRequest source);

    RecipeResponse mapFrom(final Recipe source);

    List<RecipeResponse> mapFrom(final List<Recipe> source);
}
