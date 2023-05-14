package mock.request;

import com.robertomassoni.recipesbrazil.domain.enums.DietType;
import com.robertomassoni.recipesbrazil.rest.api.request.RecipeRequest;

public class RecipeRequestMock {

    private static final String INSTRUCTIONS = "Preheat oven to 350 degrees F (175 degrees C). Grease and flour two nine inch round pans.." +
            "In a large bowl, stir together the sugar, flour, cocoa, baking powder, baking soda and salt." +
            "Stir in the boiling water last. Batter will be thin." +
            "Bake 30 to 35 minutes in the preheated oven, until the cake tests done with " +
            "a toothpick. Cool in the pans for 10 minutes, then remove to a wire rack to cool completely";
    private static final String TITLE = "One Bowl Chocolate Cake";
    private static final String DESCRIPTION = "This is a rich and moist one bowl chocolate cake";

    public static RecipeRequest create() {
        return new RecipeRequest()
                .withId(1L)
                .withTitle(TITLE)
                .withDescription(DESCRIPTION)
                .withNumberOfServings(4)
                .withPreparationTimeInMinutes(30)
                .withInstructions(INSTRUCTIONS)
                .withDietType(DietType.NONE.name())
                .withIngredients(IngredientRequestMock.createList());
    }
}
