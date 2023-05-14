package com.robertomassoni.recipesbrazil.persistence.mapper;

import com.robertomassoni.recipesbrazil.domain.recipe.Recipe;
import com.robertomassoni.recipesbrazil.persistence.entity.RecipeEntity;
import mock.domain.RecipeMock;
import mock.entity.RecipeEntityMock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeEntityMapperTest {

    private RecipeEntityMapper mapper = RecipeEntityMapper.INSTANCE;

    @Test
    void shouldMapRecipeDomainToEntity() {
        final var actualDomain = RecipeMock.create();

        final var expectedEntity = mapper.mapFrom(actualDomain);

        assertThat(actualDomain.getTitle()).isEqualTo(expectedEntity.getTitle());
        assertThat(actualDomain.getDescription()).isEqualTo(expectedEntity.getDescription());
        assertThat(actualDomain.getPreparationTimeInMinutes()).isEqualTo(expectedEntity.getPreparationTimeInMinutes());
        assertThat(actualDomain.getNumberOfServings()).isEqualTo(expectedEntity.getNumberOfServings());
        assertThat(actualDomain.getDietType().name()).isEqualTo(expectedEntity.getDietType());
        assertThat(actualDomain.getInstructions()).isEqualTo(CommonsMapper.INSTANCE.byteToString(expectedEntity.getInstructions()));
        assertThat(actualDomain.getIngredients().size()).isEqualTo(expectedEntity.getIngredients().size());
    }

    @Test
    void shouldNotMapRecipeDomainToEntityWhenDomainIsNull() {
        final var expectedEntity = mapper.mapFrom((Recipe) null);

        assertThat(expectedEntity).isNull();
    }

    @Test
    void shouldMapRecipeEntityToDomain() {
        final var actualEntity = RecipeEntityMock.create();

        final var expectedDomain = mapper.mapFrom(actualEntity);

        assertThat(actualEntity.getTitle()).isEqualTo(expectedDomain.getTitle());
        assertThat(actualEntity.getDescription()).isEqualTo(expectedDomain.getDescription());
        assertThat(actualEntity.getPreparationTimeInMinutes()).isEqualTo(expectedDomain.getPreparationTimeInMinutes());
        assertThat(actualEntity.getNumberOfServings()).isEqualTo(expectedDomain.getNumberOfServings());
        assertThat(actualEntity.getDietType()).isEqualTo(expectedDomain.getDietType().name());
        assertThat(CommonsMapper.INSTANCE.byteToString(actualEntity.getInstructions())).isEqualTo(expectedDomain.getInstructions());
        assertThat(actualEntity.getIngredients().size()).isEqualTo(expectedDomain.getIngredients().size());
    }

    @Test
    void shouldNotMapRecipeEntityToDomainWhenEntityIsNull() {
        final var expectedDomain = mapper.mapFrom((RecipeEntity) null);

        assertThat(expectedDomain).isNull();
    }
}