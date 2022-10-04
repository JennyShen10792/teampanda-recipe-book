import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Main_Prog {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean flag=true;
        String option;

        while (flag) {
            System.out.println(
                "Hey there! This is your digital Recipe Book. Press \"c\" to create a recipe, \"s\" to search for a recipe, \"b\" to browse all existing recipes, \"q\" to quit:");
            option=in.nextLine();
            if(option.equals("q")){
                flag=false;
                System.out.println("EXIT PROGRAM");
            }
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
     

            } else if (option.equals("s")) {
                System.out.println("Search Keyword: ");
                String keyword = in.nextLine();
                ArrayList<Object> output = search(keyword);
                if(output.size()>0){
                	System.out.println("Recipes found: ");
                    for (int i = 0; i < output.size(); i++) {
                        System.out.println(output.get(i));}
                }else{
                    System.out.println("No Matching results");
                }
            }else if (option.equals("b")){
                File sourceFolder = new File("./Recipe/");
                for(File f: sourceFolder.listFiles()){
                    System.out.println(f.getName().substring(0, f.getName().lastIndexOf(".")));
            }
        }
            }

        }
    public static ArrayList<Object> search(String word){
        ArrayList<Object> matches = new ArrayList<Object>();
        try{
        File sourceFolder = new File("./Recipe/");
        for(File f: sourceFolder.listFiles()){
            if(f.getName().toLowerCase().contains(word.toLowerCase())){
                matches.add(f.getName().substring(0, f.getName().lastIndexOf(".")));
            }
        }
        }catch(Exception e){
            System.out.println("error with searching");
            e.printStackTrace();
    }
    return matches;

    }

}