import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// IngredientCategory { addINgredient(ingredient, day), getIngredients(count), getCategory(String ), removeIngredients(List<Ingredient>)}
// IngredientCategory[]
// if(IngredientCategory.map(ic -> ic.getIngred(count).count())).filter(c -> c > 0.6 * numberOfIngredients))
// {
//      List<List<Ingredients>> potentialSixtyPercentageItems = IngredientCategory
//              .map(ic -> ic.getIngred(count).count()))
//              .filter(c -> c > 0.6 * numberOfIngredients);
//
// }
public class Chef {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numberOfDays = 5;//in.nextInt();
        int numberOfIngredients = 3;//in.nextInt();
        //in.nextLine();
        List<IngredientCategory> ingredientCategories = new ArrayList<>();
        ingredientCategories.add(new IngredientCategory("FAT"));
        ingredientCategories.add(new IngredientCategory("FIBER"));
        ingredientCategories.add(new IngredientCategory("CARB"));

        List<String> inputs= Arrays.stream(new String[] {"FATOil", "FATCheese", "FATEgg", "FIBERSpinach", "CARBRice", "FIBERBeans"}).collect(Collectors.toList());

        for (int i = 0; i < numberOfDays; i++) {
            String ingredientId = inputs.get(i);

            Ingredient ingredient = new Ingredient(ingredientId, i + 1);
            ingredientCategories
                    .stream()
                    .filter(ic -> ic.category.equals(ingredient.category))
                    .findFirst().get()
                    .addIngredient(ingredient);

            final List<IngredientCategory> potentialSixtyPercentageItems = ingredientCategories
                    .stream()
                    .filter(ic -> ic.getIngredients(numberOfIngredients).size() >= Math.ceil(0.6 * numberOfIngredients))
                    .collect(Collectors.toList());

            List<Ingredient> ingredientsToCookWith = new ArrayList<>();

            if (!potentialSixtyPercentageItems.isEmpty()) {
                final IngredientCategory ingredientCategoryForSixtyPercent = potentialSixtyPercentageItems.stream().findFirst().get();
                ingredientsToCookWith.addAll(ingredientCategoryForSixtyPercent.getIngredients((int) Math.ceil(0.6 * numberOfIngredients)));
                ingredientCategoryForSixtyPercent.removeIngredients(ingredientCategoryForSixtyPercent.getIngredients(numberOfIngredients));
                List<Ingredient> restAllIngredients = getAllIngredients(ingredientCategories);
                restAllIngredients.sort((i1, i2) -> i1.day - i2.day);

                if (numberOfIngredients - ingredientsToCookWith.size() > 0)
                    ingredientsToCookWith.addAll(restAllIngredients.subList(0, numberOfIngredients - ingredientsToCookWith.size()));

                ingredientsToCookWith.sort((i1, i2) -> i1.day - i2.day);
                // remove from other categories
                for (int j = 0; j < numberOfIngredients; j++) {
                    System.out.print(ingredientsToCookWith.get(j).ingredientId);

                    if (j != (numberOfIngredients - 1))
                        System.out.print(":");
                }
            } else {
                System.out.print("-");
            }
        }
    }

    static class Ingredient {
        String ingredientId;
        String category;
        int day;

        public Ingredient(String ingredientId, int day) {
            this.ingredientId = ingredientId;
            this.day = day;
            this.category = getCategory(ingredientId);
        }
    }

    static class IngredientCategory {
        String category;
        List<Ingredient> ingredients = new ArrayList<>();

        public IngredientCategory(String category) {
            this.category = category;
        }

        void addIngredient(Ingredient ingredient) {
            ingredients.add(ingredient);
        }

        List<Ingredient> getIngredients(int count) {
            return ingredients
                    .stream()
                    .sorted((i1, i2) -> i1.day - i2.day)
                    .collect(Collectors.toList())
                    .subList(0, count);
        }

        void removeIngredients(List<Ingredient> ingredientsToRemove) {
            ingredientsToRemove
                    .stream()
                    .filter(i -> i.category != category);

            ingredientsToRemove.forEach(ir -> ingredients.remove(ir));
        }
    }

    static String getCategory(String ingredient) {
        if (ingredient.startsWith("FAT"))
            return "FAT";
        if (ingredient.startsWith("FIBER"))
            return "FAT";
        if (ingredient.startsWith("CARB"))
            return "FAT";

        return null;
    }

    static List<Ingredient> getAllIngredients(List<IngredientCategory> ingredientCategories) {
        return ingredientCategories.stream().flatMap(ic -> ic.ingredients.stream()).collect(Collectors.toList());
    }
}
