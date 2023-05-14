package com.robertomassoni.recipesbrazil.rest.api.controller;

import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.rest.api.mapper.RecipeMapper;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    private RecipeService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RecipeRequest request) {
        final var recipe = RecipeMapper.INSTANCE.mapFrom(request);
        final var result = service.save(recipe);
        return ResponseEntity.status(CREATED).body(RecipeMapper.INSTANCE.mapFrom(result));
    }

    @PutMapping("/{recipe_id}")
    public ResponseEntity<?> update(@PathVariable(name = "recipe_id") Long recipeId, @RequestBody RecipeRequest request) {
        final var recipe = RecipeMapper.INSTANCE.mapFrom(request).withId(recipeId);
        final var result = service.save(recipe);
        return ResponseEntity.status(OK).body(RecipeMapper.INSTANCE.mapFrom(result));
    }

    @DeleteMapping("/{recipe_id}")
    public ResponseEntity<?> delete(@PathVariable(name = "recipe_id") Long recipeId) {
        service.delete(recipeId);
        return ResponseEntity.status(OK).build();
    }
}
