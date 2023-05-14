package com.robertomassoni.recipesbrazil.rest.api.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Ingredient;
import com.robertomassoni.recipesbrazil.rest.api.request.IngredientRequest;
import mock.domain.IngredientMock;
import mock.request.IngredientRequestMock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IngredientMapperTest {

    private IngredientMapper mapper = IngredientMapper.INSTANCE;

    @Test
    void shouldMapIngredientDomainToResponse() {
        final var actualDomain = IngredientMock.create("Ingredient xyz");

        final var expectedResponse = mapper.mapFrom(actualDomain);

        assertThat(actualDomain.getDescription()).isEqualTo(expectedResponse.getDescription());
    }

    @Test
    void shouldNotMapIngredientDomainToResponseWhenDomainIsNull() {
        final var expectedResponse = mapper.mapFrom((Ingredient) null);

        assertThat(expectedResponse).isNull();
    }

    @Test
    void shouldMapIngredientRequestToDomain() {
        final var actualRequest = IngredientRequestMock.create("Ingredient xyz");

        final var expectedDomain = mapper.mapFrom(actualRequest);

        assertThat(actualRequest.getDescription()).isEqualTo(expectedDomain.getDescription());
    }

    @Test
    void shouldNotMapIngredientRequestToDomainWhenRequestIsNull() {
        final var expectedDomain = mapper.mapFrom((IngredientRequest) null);

        assertThat(expectedDomain).isNull();
    }
}