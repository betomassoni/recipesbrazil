package mock.entity;

import com.robertomassoni.recipesbrazil.persistence.entity.IngredientEntity;

import java.util.Arrays;
import java.util.List;

public class IngredientEntityMock {

    public static IngredientEntity create(final String description) {
        return new IngredientEntity().withDescription(description);
    }

    public static List<IngredientEntity> createList() {
        return Arrays.asList(create("2 cups white sugar"),
                create("1 ¾ cups all-purpose flour"),
                create("1 ½ teaspoons baking powder"),
                create("2 eggs"),
                create("1 cup milk"),
                create("2 teaspoons vanilla extract"),
                create("1 cup boiling water"));
    }
}
