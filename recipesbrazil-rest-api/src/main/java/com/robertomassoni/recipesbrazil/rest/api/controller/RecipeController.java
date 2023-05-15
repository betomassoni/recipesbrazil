package com.robertomassoni.recipesbrazil.rest.api.controller;

import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.rest.api.mapper.RecipeMapper;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    private RecipeService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final RecipeRequest request) {
        final var recipe = RecipeMapper.INSTANCE.mapFrom(request);
        final var result = service.save(recipe);
        return ResponseEntity.status(CREATED).body(RecipeMapper.INSTANCE.mapFrom(result));
    }

    @PutMapping("/{recipe_id}")
    public ResponseEntity<?> update(@PathVariable(name = "recipe_id") final Long recipeId, @RequestBody final RecipeRequest request) {
        final var recipe = RecipeMapper.INSTANCE.mapFrom(request).withId(recipeId);
        final var result = service.save(recipe);
        return ResponseEntity.status(OK).body(RecipeMapper.INSTANCE.mapFrom(result));
    }

    @DeleteMapping("/{recipe_id}")
    public ResponseEntity<?> delete(@PathVariable(name = "recipe_id") final Long recipeId) {
        service.delete(recipeId);
        return ResponseEntity.status(OK).build();
    }

    @GetMapping()
    public ResponseEntity<?> get(@RequestParam(name = "instructions", required = false) final String instructions,
                                 @RequestParam(name = "number_of_servings", required = false) final String numberOfServings,
                                 @RequestParam(name = "diet_type", required = false) final String dietType,
                                 @RequestParam(name = "include_ingredient", required = false) final String includeIngredient,
                                 @RequestParam(name = "exclude_ingredient", required = false) final String excludeIngredient) {

        final var filter = new RecipeFilter()
                .withInstructions(instructions)
                .withNumberOfServings(numberOfServings)
                .withDietType(dietType)
                .withIncludeIngredient(includeIngredient)
                .withExcludeIngredient(excludeIngredient);

        final var result = service.findAllAndFilter(filter);
        return ResponseEntity.status(OK).body(RecipeMapper.INSTANCE.mapFrom(result));
    }
}
