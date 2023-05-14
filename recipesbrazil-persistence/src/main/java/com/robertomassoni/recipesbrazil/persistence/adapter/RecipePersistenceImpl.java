package com.robertomassoni.recipesbrazil.persistence.adapter;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.persistence.mapper.RecipeEntityMapper;
import com.robertomassoni.recipesbrazil.persistence.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class RecipePersistenceImpl implements RecipePersistence {

    private RecipeRepository repository;

    @Override
    @Transactional
    public Recipe save(final Recipe source) {
        final var entity = RecipeEntityMapper.INSTANCE.mapFrom(source);
        final var result = repository.saveAndFlush(entity);
        return RecipeEntityMapper.INSTANCE.mapFrom(result);
    }

    @Override
    public boolean existsByTitle(final String title) {
        return repository.existsByTitle(title);
    }

    @Override
    public void delete(Long recipeId) {
        repository.deleteById(recipeId.intValue());
    }
}
