package com.robertomassoni.recipesbrazil.rest.api.controller;

import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.rest.api.mapper.RecipeMapper;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

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
}
