package com.robertomassoni.recipesbrazil.persistence.adapter;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.persistence.mapper.RecipeEntityMapper;
import com.robertomassoni.recipesbrazil.persistence.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Recipe> findAll(final RecipeFilter filter) {
        final var result = repository.findAllAndFilter(filter.getDietType(),
                filter.getNumberOfServings(),
                filter.getIncludeIngredient(),
                filter.getExcludeIngredient(),
                filter.getInstructions());
        return RecipeEntityMapper.INSTANCE.mapFrom(result);
    }
}
