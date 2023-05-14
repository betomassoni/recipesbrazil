package com.robertomassoni.recipesbrazil.rest.api.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;
import mock.domain.RecipeMock;
import mock.request.RecipeRequestMock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeMapperTest {

    private RecipeMapper mapper = RecipeMapper.INSTANCE;

    @Test
    void shouldMapRecipeDomainToResponse() {
        final var actualDomain = RecipeMock.create();

        final var expectedResponse = mapper.mapFrom(actualDomain);

        assertThat(actualDomain.getTitle()).isEqualTo(expectedResponse.getTitle());
        assertThat(actualDomain.getDescription()).isEqualTo(expectedResponse.getDescription());
        assertThat(actualDomain.getPreparationTimeInMinutes()).isEqualTo(expectedResponse.getPreparationTimeInMinutes());
        assertThat(actualDomain.getNumberOfServings()).isEqualTo(expectedResponse.getNumberOfServings());
        assertThat(actualDomain.getDietType().name()).isEqualTo(expectedResponse.getDietType());
        assertThat(actualDomain.getInstructions()).isEqualTo(expectedResponse.getInstructions());
        assertThat(actualDomain.getIngredients().size()).isEqualTo(expectedResponse.getIngredients().size());
    }

    @Test
    void shouldNotMapRecipeDomainToResponseWhenDomainIsNull() {
        final var expectedResponse = mapper.mapFrom((Recipe) null);

        assertThat(expectedResponse).isNull();
    }

    @Test
    void shouldMapRecipeRequestToDomain() {
        final var actualRequest = RecipeRequestMock.create();

        final var expectedDomain = mapper.mapFrom(actualRequest);

        assertThat(actualRequest.getTitle()).isEqualTo(expectedDomain.getTitle());
        assertThat(actualRequest.getDescription()).isEqualTo(expectedDomain.getDescription());
        assertThat(actualRequest.getPreparationTimeInMinutes()).isEqualTo(expectedDomain.getPreparationTimeInMinutes());
        assertThat(actualRequest.getNumberOfServings()).isEqualTo(expectedDomain.getNumberOfServings());
        assertThat(actualRequest.getDietType()).isEqualTo(expectedDomain.getDietType().name());
        assertThat(actualRequest.getInstructions()).isEqualTo(expectedDomain.getInstructions());
        assertThat(actualRequest.getIngredients().size()).isEqualTo(expectedDomain.getIngredients().size());
    }

    @Test
    void shouldNotMapRecipeRequestToDomainWhenRequestIsNull() {
        final var expectedDomain = mapper.mapFrom((RecipeRequest) null);

        assertThat(expectedDomain).isNull();
    }
}