package com.robertomassoni.recipesbrazil.persistence.repository;

import com.robertomassoni.recipesbrazil.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    boolean existsByTitle(final String title);

    @Query(value = "SELECT r.* FROM recipe r "
            + "WHERE (r.diet_type = :diet_type OR :diet_type IS NULL) "
            + "AND (r.number_of_servings = :number_of_servings OR :number_of_servings IS NULL) "
            + "AND (:instructions IS NULL OR r.instructions LIKE %:instructions%) "
            + "AND (EXISTS (SELECT * FROM ingredient i WHERE i.recipe_id = r.id AND i.description LIKE %:include_ingredient%) OR :include_ingredient IS NULL) "
            + "AND (NOT EXISTS (SELECT * FROM ingredient i WHERE i.recipe_id = r.id AND i.description LIKE %:exclude_ingredient%) OR :exclude_ingredient IS NULL)",
            nativeQuery = true)
    List<RecipeEntity> findAllAndFilter(@Param("diet_type") String dietType,
                                        @Param("number_of_servings") String numberOfServings,
                                        @Param("include_ingredient") String includeIngredient,
                                        @Param("exclude_ingredient") String excludeIngredient,
                                        @Param("instructions") String instructions);
}
