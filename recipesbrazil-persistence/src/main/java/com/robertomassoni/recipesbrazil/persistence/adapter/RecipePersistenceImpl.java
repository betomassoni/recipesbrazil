package com.robertomassoni.recipesbrazil.persistence.adapter;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.persistence.mapper.RecipeEntityMapper;
import com.robertomassoni.recipesbrazil.persistence.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecipePersistenceImpl implements RecipePersistence {

    private RecipeRepository repository;

    @Override
    public Recipe save(final Recipe source) {
        final var entity = RecipeEntityMapper.INSTANCE.mapFrom(source);
        final var result = repository.save(entity);
        return RecipeEntityMapper.INSTANCE.mapFrom(result);
    }

    @Override
    public boolean existsByTitle(final String title) {
        return repository.existsByTitle(title);
    }
}
