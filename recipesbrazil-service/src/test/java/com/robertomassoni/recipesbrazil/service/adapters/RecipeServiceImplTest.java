package com.robertomassoni.recipesbrazil.service.adapters;

import com.robertomassoni.recipesbrazil.core.exception.ResourceAlreadyExistsException;
import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import mock.domain.RecipeMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    private RecipeService service;
    private RecipePersistence persistence;

    @BeforeEach
    public void setUp() {
        persistence = mock(RecipePersistence.class);
        service = new RecipeServiceImpl(persistence);
    }

    @Test
    public void shouldSaveRecipe() {
        final var actualDomain = RecipeMock.create();
        when(persistence.save(any())).thenReturn(actualDomain);

        final var expectedRecipe = service.save(actualDomain);

        verify(persistence, times(1)).save(any());
        assertThat(expectedRecipe).isNotNull();
    }

    @Test
    public void shouldThrowExceptionWhenRecipeAlreadyExists() {
        final var actualDomain = RecipeMock.create();
        when(persistence.existsByTitle(any())).thenReturn(true);
        when(persistence.save(any())).thenReturn(actualDomain);

        assertThatThrownBy(() -> service.save(actualDomain))
                .isInstanceOf(ResourceAlreadyExistsException.class)
                .hasMessage(String.format("Recipe with title '%s' already exists.", actualDomain.getTitle()));
        verify(persistence, times(1)).existsByTitle(any());
        verify(persistence, never()).save(any());
    }

    @Test
    public void shouldDeleteRecipe() {
        service.delete(1L);

        verify(persistence, times(1)).delete(any());
    }

    @Test
    public void shouldFindAllRecipes() {
        final var filter = new RecipeFilter()
                .withDietType("VEGETARIAN");
        when(persistence.findAll(any())).thenReturn(Arrays.asList(RecipeMock.create(), RecipeMock.create()));

        final var expectedRecipes = service.findAllAndFilter(filter);

        verify(persistence, times(1)).findAll(any());
        assertThat(expectedRecipes.size()).isEqualTo(2);
    }

}