
import java.util.ArrayList;

public class Recipe {
    private String name;
    private String descript;
    private String ingred_list;
    private ArrayList<String> cook_instruct;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public String getDescript() {
        return descript;
    }



    public void setDescript(String descript) {
        this.descript = descript;
    }



    public String getIngred_list() {
        return ingred_list;
    }



    public void setIngred_list(String ingred_list) {
        this.ingred_list = ingred_list;
    }



    public ArrayList<String> getCook_instruct() {
        return cook_instruct;
    }



    public void setCook_instruct(ArrayList<String> cook_instruct) {
        this.cook_instruct = cook_instruct;
    }



    public Recipe(String name, String descript, String ingred_list, ArrayList<String> cook_instruct) {
        this.name = name;
        this.descript = descript;
        this.ingred_list = ingred_list;
        this.cook_instruct = cook_instruct;
        
        

    }

   
    
}
