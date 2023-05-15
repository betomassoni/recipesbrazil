package mock.request;

import com.robertomassoni.recipesbrazil.rest.api.request.IngredientRequest;

import java.util.Arrays;
import java.util.List;

public class IngredientRequestMock {

    public static IngredientRequest create(final String description) {
        return new IngredientRequest().withDescription(description);
    }

    public static List<IngredientRequest> createList() {
        return Arrays.asList(create("2 cups white sugar"),
                create("1 ¾ cups all-purpose flour"),
                create("1 ½ teaspoons baking powder"),
                create("2 eggs"),
                create("1 cup milk"),
                create("2 teaspoons vanilla extract"),
                create("1 cup boiling water"));
    }
}
