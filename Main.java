

public class Main {
	public static void main(String []args) {
		Recipe r= new Recipe("Taco", "Flour, protein, veggies", "wrap");
		Save s= new Save();
		s.save(r);
		//printing the recipe with the title inputted
		System.out.println(s.get_recipe("Taco"));

	}
}