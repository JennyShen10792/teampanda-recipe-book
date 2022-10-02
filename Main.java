

public class Main {
	public static void main(String []args) {
		Recipe r= new Recipe("Taco", "Flour, protein, veggies", "wrap");
		Save s= new Save();
		s.save(r);
		//finding one specific recipe with inputted title
		System.out.println(s.get_recipe("Taco"));
		//show all the recipes
		System.out.println(s.get_all());

	}
}