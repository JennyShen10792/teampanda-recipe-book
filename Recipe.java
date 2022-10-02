import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Recipe {
    private String name;
    private String descript;
    private ArrayList<String> ingred_list;
    private ArrayList<String> cook_instruct;

    public Recipe(String name, String descript, ArrayList<String> ingred_list, ArrayList<String> cook_instruct) {
        this.name = name;
        this.descript = descript;
        this.ingred_list = ingred_list;
        this.cook_instruct = cook_instruct;

        // create recipe with the name under "Recipe" folder
        String dir = "./Recipe/" + this.name + ".txt";
        File newFile = new File(dir);
        boolean flag = false;

        try {
            flag = newFile.createNewFile();
            if (flag) {
                System.out.println("Recipe created with name " + this.name);
            } else {
                System.out.println("Recipe with name " + this.name + " already exist!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }

        // Write to the recipe file if flag is true.
        if (flag) {
            // write description into the file
            try {
                FileWriter myWriter = new FileWriter(dir, true);
                myWriter.write("Description: \n" + this.descript + "\n");
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote description to the file.");

                // write a list of ingredients into the file

                myWriter.write("Ingredients: \n" + String.join(", ", this.ingred_list) + "\n");
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote a list of ingredients!");

                // write cooking instructions into the file
                myWriter.write("Step-by-step cooking instructions: \n");
                for (int i = 0; i < this.cook_instruct.size(); i++) {
                    myWriter.write((i + 1) + ". " + this.cook_instruct.get(i) + "\n");
                }
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote cooking instructions!");
                myWriter.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("Successfully created and saved a new recipe!");
        }

    }

    // get recipe name
    public String getName() {
        return this.name;
    }
}
