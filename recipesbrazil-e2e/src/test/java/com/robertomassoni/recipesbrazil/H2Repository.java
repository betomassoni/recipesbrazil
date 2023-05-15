package com.robertomassoni.recipesbrazil;

import com.robertomassoni.recipesbrazil.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2Repository  extends JpaRepository<RecipeEntity, Integer> {
}
