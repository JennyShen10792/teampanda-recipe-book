import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Recipe {
    private String name;
    private String descript;
    private String[] ingred_list;
    private String[] cook_instruct;

    public Recipe(String name, String descript, String[] ingred_list, String[] cook_instruct) {
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
                myWriter.write(this.descript + "\n");
                System.out.println("Successfully wrote description to the file.");

                // write a list of ingredients into the file

                for (int i = 0; i < this.ingred_list.length; i++) {
                    myWriter.write(this.ingred_list[i] + " ");
                }
                System.out.println("Successfully wrote a list of ingredients!");

                // write cooking instructions into the file
                for (int i = 0; i < this.cook_instruct.length; i++) {
                    myWriter.write((i + 1) + " " + this.cook_instruct[i] + "\n");
                }
                System.out.println("Successfully wrote cooking instructions!");
                myWriter.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("Successfully created and saved a new recipe!");
        }

    }
}
