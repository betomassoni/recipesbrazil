package com.robertomassoni.recipesbrazil.persistence.adapter;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.domain.filter.RecipeFilter;
import com.robertomassoni.recipesbrazil.persistence.repository.RecipeRepository;
import mock.domain.RecipeMock;
import mock.entity.RecipeEntityMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipePersistenceImplTest {

    private RecipeRepository repository;
    private RecipePersistence persistence;

    @BeforeEach
    public void setUp() {
        repository = mock(RecipeRepository.class);
        persistence = new RecipePersistenceImpl(repository);
    }

    @Test
    public void shouldSaveRecipe() {
        final var actualDomain = RecipeMock.create();
        when(repository.saveAndFlush(any())).thenReturn(RecipeEntityMock.create());

        final var expectedRecipe = persistence.save(actualDomain);

        verify(repository, times(1)).saveAndFlush(any());
        assertThat(expectedRecipe).isNotNull();
    }

    @Test
    public void shouldReturnTrueWhenRecipeTitleAlreadyExists() {
        final var actualTitle = RecipeMock.create().getTitle();
        when(repository.existsByTitle(any())).thenReturn(true);

        final var expectedValue = persistence.existsByTitle(actualTitle);

        verify(repository, times(1)).existsByTitle(any());
        assertThat(expectedValue).isTrue();
    }

    @Test
    public void shouldGetRecipe() {
        when(repository.findAllAndFilter(any(), any(), any(), any(), any())).thenReturn(Arrays.asList(RecipeEntityMock.create(), RecipeEntityMock.create()));

        final var expectedValue = persistence.findAll(new RecipeFilter());

        verify(repository, times(1)).findAllAndFilter(any(), any(), any(), any(), any());
        assertThat(expectedValue).isNotNull();
    }
}