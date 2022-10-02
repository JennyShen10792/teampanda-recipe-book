

public class Main {
	public static void main(String []args) {
		Recipe r= new Recipe("proteins", "beef", "cook");
		Save s= new Save();
		s.save(r);
		System.out.println(s.get_recipe("proteins"));

		
	}
}