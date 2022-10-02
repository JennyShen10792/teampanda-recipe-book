import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main_Prog {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hey there! This is your digital Recipe Book. Press \"c\" to create a recipe, ...:");
        String option;

        while (!(option = in.nextLine()).equals("q")) {
            if (option.equals("c")) {
                System.out.println("Enter a recipe name: ");
                String recipe_name = in.nextLine();
                System.out.println();

                System.out.println("Enter a description of the recipe: ");
                String descript = in.nextLine();
                System.out.println();

                System.out.println("Enter a list of ingredients needed (enter \"end\" to quit): ");
                ArrayList<String> ingred_list = new ArrayList<>();
                String new_ingred;
                while ((new_ingred = in.nextLine()).equals("end") == false) {
                    ingred_list.add(new_ingred);
                }
                System.out.println();

                System.out.println("Enter step-by-step cooking instructions (enter \"end\" to quit): ");
                ArrayList<String> instructs = new ArrayList<>();
                String new_instruc;
                while ((new_instruc = in.nextLine()).equals("end") == false) {
                    instructs.add(new_instruc);
                }
                System.out.println();

                Recipe newRecipe = new Recipe(recipe_name, descript, ingred_list, instructs);
                System.out.println(newRecipe.getName());
            }
        }
        in.close();
    }
}