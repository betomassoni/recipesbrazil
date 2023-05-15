package com.robertomassoni.recipesbrazil.rest.api.controller;

import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.rest.api.response.RecipeResponse;
import mock.domain.RecipeMock;
import mock.request.RecipeRequestMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeControllerTest {

    private RecipeController controller;
    private RecipeService service;

    @BeforeEach
    public void setUp() {
        service = mock(RecipeService.class);
        controller = new RecipeController(service);
    }

    @Test
    public void shouldCreateRecipeWithTheSameTitle() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getTitle()).isEqualTo(expectedRecipe.getBody().getTitle());
    }

    @Test
    public void shouldCreateRecipeWithTheSameDescription() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getDescription()).isEqualTo(expectedRecipe.getBody().getDescription());
    }

    @Test
    public void shouldCreateRecipeWithTheSameDietType() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getDietType()).isEqualTo(expectedRecipe.getBody().getDietType());
    }

    @Test
    public void shouldCreateRecipeWithTheSameNumberOfServings() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getNumberOfServings()).isEqualTo(expectedRecipe.getBody().getNumberOfServings());
    }

    @Test
    public void shouldCreateRecipeWithTheSameInstructions() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getInstructions()).isEqualTo(expectedRecipe.getBody().getInstructions());
    }

    @Test
    public void shouldCreateRecipeWithTheSameNumberOfIngredients() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.create(actualRequest);

        verify(service, times(1)).save(any());
        assertThat(actualRequest.getIngredients().size()).isEqualTo(expectedRecipe.getBody().getIngredients().size());
    }

    @Test
    public void shouldUpdateRecipe() {
        final var actualRequest = RecipeRequestMock.create();
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.update(1L, actualRequest);

        verify(service, times(1)).save(any());
        assertThat(expectedRecipe).isNotNull();
    }

    @Test
    public void shouldDeleteRecipe() {
        when(service.save(any())).thenReturn(RecipeMock.create());

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.delete(1L);

        verify(service, times(1)).delete(any());
        assertThat(expectedRecipe).isNotNull();
    }

    @Test
    public void shouldGetRecipe() {
        when(service.findAllAndFilter(any())).thenReturn(Arrays.asList(RecipeMock.create(), RecipeMock.create()));

        final var expectedRecipe = (ResponseEntity<RecipeResponse>) controller.get(null, null, null, null, null);

        verify(service, times(1)).findAllAndFilter(any());
        assertThat(expectedRecipe).isNotNull();
    }
}