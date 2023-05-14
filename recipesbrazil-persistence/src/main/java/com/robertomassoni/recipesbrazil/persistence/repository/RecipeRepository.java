package com.robertomassoni.recipesbrazil.persistence.repository;

import com.robertomassoni.recipesbrazil.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    boolean existsByTitle(final String title);
}
