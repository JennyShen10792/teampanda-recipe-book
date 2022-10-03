import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main_Prog {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
<<<<<<< HEAD
        System.out.println("Hey there! This is your digital Recipe Book. Press \"c\" to create a recipe, \"s\" to search for a recipe:");
=======
        System.out.println(
                "Hey there! This is your digital Recipe Book. Press \"c\" to create a recipe, \"s\" to search ...:");
>>>>>>> f677f27c8667da00f5e6cb378147ccac09ac4c8b
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

            } else if (option.equals("s")) {
                System.out.println("Search Keyword: ");
				String keyword = in.nextLine();
				ArrayList<Object> output = searchFunction(keyword, ingred_list);
				for (int i = 0; i < output.size(); i++) {
					System.out.println(output.get(i));
				}	
            }
       	 }
       	in.close();
       	public static ArrayList<Object> searchFunction(String word, ArrayList<Object> ingred_list){
			ArrayList<Object> matches = new ArrayList<Object>();
			for (int i = 0; i < ingred_list.size(); i++) {
			 	if (ingred_list.get(i).recipe_name.toLowerCase().contains(word.toLowerCase())){
				 	matches.add(ingred_list.get(i));
			 	}	
		 	}
			return matches;	
		}
    }
}