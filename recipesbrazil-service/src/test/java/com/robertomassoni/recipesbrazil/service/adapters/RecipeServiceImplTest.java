package com.robertomassoni.recipesbrazil.service.adapters;

import com.robertomassoni.recipesbrazil.core.persistence.RecipePersistence;
import com.robertomassoni.recipesbrazil.core.service.RecipeService;
import mock.domain.RecipeMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
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
}