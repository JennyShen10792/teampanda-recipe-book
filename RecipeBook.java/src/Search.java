import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
	
	public static void main(String[] args) {
		
		System.out.println("Search Keyword: ");
		Scanner input = new Scanner(System.in);
		String keyword = input.nextLine();
		ArrayList<Object> output = searchFunction(keyword, recipes);
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		 }
	}
	
	
	public static ArrayList<Object> searchFunction(String word, ArrayList<Object> recipes){
		ArrayList<Object> matches = new ArrayList<Object>();
		 for (int i = 0; i < recipes.size(); i++) {
			 if (recipes.get(i).title.toLowerCase().contains(word.toLowerCase())){
				 matches.add(recipes.get(i));
			 }
		 }
		return matches;
		
	}
	
}