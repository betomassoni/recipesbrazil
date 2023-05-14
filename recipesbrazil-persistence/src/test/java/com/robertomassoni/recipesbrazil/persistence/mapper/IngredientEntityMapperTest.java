package com.robertomassoni.recipesbrazil.persistence.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Ingredient;
import com.robertomassoni.recipesbrazil.persistence.entity.IngredientEntity;
import mock.domain.IngredientMock;
import mock.entity.IngredientEntityMock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IngredientEntityMapperTest {

    private IngredientEntityMapper mapper = IngredientEntityMapper.INSTANCE;

    @Test
    void shouldMapIngredientDomainToEntity() {
        final var actualDomain = IngredientMock.create("Ingredient xyz");

        final var expectedEntity = mapper.mapFrom(actualDomain);

        assertThat(actualDomain.getDescription()).isEqualTo(expectedEntity.getDescription());
    }

    @Test
    void shouldNotMapIngredientDomainToEntityWhenDomainIsNull() {
        final var expectedEntity = mapper.mapFrom((Ingredient) null);

        assertThat(expectedEntity).isNull();
    }

    @Test
    void shouldMapIngredientEntityToDomain() {
        final var actualEntity = IngredientEntityMock.create("Ingredient xyz");

        final var expectedDomain = mapper.mapFrom(actualEntity);

        assertThat(actualEntity.getDescription()).isEqualTo(expectedDomain.getDescription());
    }

    @Test
    void shouldNotMapIngredientEntityToDomainWhenEntityIsNull() {
        final var expectedDomain = mapper.mapFrom((IngredientEntity) null);

        assertThat(expectedDomain).isNull();
    }
}