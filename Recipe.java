
import java.util.ArrayList;



public class Recipe {

    private String title;
	private String ingredient;
	private String instruction;
	public static ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	
	
	//constructor
	public Recipe(String title, String ingredient, String instruction) {
		this.title=title;
        this.ingredient=ingredient;
        this.instruction=instruction;
	}
	
	
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
     public String getInstrcution() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	

	//return string representation
	public String toString() {
		return title+ "\n"+ ingredient + "\n" + instruction;
	}
}
