package mock.domain;

import com.robertomassoni.recipesbrazil.domain.recipe.Ingredient;

import java.util.Arrays;
import java.util.List;

public class IngredientMock {

    public static Ingredient create(final String description) {
        return new Ingredient().withDescription(description);
    }

    public static List<Ingredient> createList() {
        return Arrays.asList(create("2 cups white sugar"),
                create("1 ¾ cups all-purpose flour"),
                create("1 ½ teaspoons baking powder"),
                create("2 eggs"),
                create("1 cup milk"),
                create("2 teaspoons vanilla extract"),
                create("1 cup boiling water"));
    }
}
