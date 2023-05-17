package com.robertomassoni.recipesbrazil;

import com.robertomassoni.recipesbrazil.rest.api.response.RecipeResponse;
import mock.request.IngredientRequestMock;
import mock.request.RecipeRequestMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationIntegratedTests.class)
@ActiveProfiles("test")
public class IntegrationTest {
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private H2Repository h2Repository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        h2Repository.deleteAll();
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/recipes");
    }

    @Test
    public void shouldCreateRecipe() {
        final var actualRequest = RecipeRequestMock.create();

        final var expectedResponse = restTemplate.postForObject(baseUrl, actualRequest, RecipeResponse.class);

        assertThat(expectedResponse.getId()).isNotNull();
    }

    @Test
    public void shouldDeleteRecipe() {
        final var actualRequest = RecipeRequestMock.create();

        final var recipeCreated = restTemplate.postForObject(baseUrl, actualRequest, RecipeResponse.class);
        restTemplate.delete(baseUrl + "/" + recipeCreated.getId());
        final var expectedRecipes = restTemplate.getForObject(baseUrl, List.class);

        assertThat(expectedRecipes.size()).isEqualTo(0);
    }

    @Test
    public void shouldGetOneRecipe() {
        final var actualRequest = RecipeRequestMock.create();

        restTemplate.postForObject(baseUrl, actualRequest, RecipeResponse.class);
        final var expectedRecipes = (List<RecipeResponse>) restTemplate.getForObject(baseUrl, List.class);

        assertThat(expectedRecipes.size()).isEqualTo(1);
    }

    @Test
    public void shouldGetMoreThanOneRecipe() {
        final var actualRequest = RecipeRequestMock.create();

        restTemplate.postForObject(baseUrl, actualRequest.withTitle("title 1"), RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequest.withTitle("title 2"), RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequest.withTitle("title 3"), RecipeResponse.class);
        final var expectedRecipes = (List<RecipeResponse>) restTemplate.getForObject(baseUrl, List.class);

        assertThat(expectedRecipes.size()).isEqualTo(3);
    }

    @Test
    public void shouldGetOnlyVegetarianRecipes() {
        final var actualRequest = RecipeRequestMock.create();

        restTemplate.postForObject(baseUrl, actualRequest.withDietType("VEGAN").withTitle("title 1"), RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequest.withDietType("PLANT_BASED").withTitle("title 2"), RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequest.withDietType("VEGETARIAN").withTitle("title 3"), RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequest.withDietType("VEGETARIAN").withTitle("title 4"), RecipeResponse.class);

        final var expectedRecipes = (List<RecipeResponse>) restTemplate.getForObject(baseUrl + "?diet_type=VEGETARIAN", List.class);

        assertThat(expectedRecipes.size()).isEqualTo(2);
    }

    @Test
    public void shouldGetRecipesWithPotatoesAndServesFour() {
        final var actualRequest = RecipeRequestMock.create()
                .withNumberOfServings(4)
                .withIngredients(Collections.singletonList(IngredientRequestMock.create("Mashed potatoes")));

        restTemplate.postForObject(baseUrl, actualRequest, RecipeResponse.class);

        final var expectedRecipes = (List<RecipeResponse>) restTemplate.getForObject(baseUrl + "?number_of_servings=4&include_ingredient=potatoes", List.class);

        assertThat(expectedRecipes.size()).isEqualTo(1);
    }

    @Test
    public void shouldGetRecipesWithoutSalmonAndThereIsNotOvenOnInstructions() {
        final var actualRequestRecipe1 = RecipeRequestMock.create()
                .withTitle("Baked salmon")
                .withIngredients(Collections.singletonList(IngredientRequestMock.create("1kg salmon")))
                .withInstructions("Bake the fish in the oven");
        final var actualRequestRecipe2 = RecipeRequestMock.create()
                .withTitle("Baked tuna")
                .withIngredients(Collections.singletonList(IngredientRequestMock.create("1kg Tuna")))
                .withInstructions("Bake the fish in the oven");

        restTemplate.postForObject(baseUrl, actualRequestRecipe1, RecipeResponse.class);
        restTemplate.postForObject(baseUrl, actualRequestRecipe2, RecipeResponse.class);

        final var expectedRecipes = (List<RecipeResponse>) restTemplate.getForObject(baseUrl + "?instructions=oven&exclude_ingredient=salmon", List.class);

        assertThat(expectedRecipes.size()).isEqualTo(1);
    }
}
