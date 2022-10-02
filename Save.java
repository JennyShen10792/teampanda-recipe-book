import java.io.*;
import java.util.Scanner;

public class Save{

	public void save(Recipe r) {
		try {
			FileWriter fw=new FileWriter(r.getTitle() + ".txt");
            fw.write("Title: "+r.getTitle()+"\n" +"Ingredients: "+r.getIngredient()+'\n'+"Instructions: "+r.getInstrcution());
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get_recipe(String t) {
		Scanner scanner;
		String result = "";
		try {
			scanner = new Scanner(new File(t+".txt"));
			while(scanner.hasNextLine())
			{
				result+= scanner.nextLine()+"\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String get_all(){
		 String results="";
		  File a= new File(".");
          for( File f : a.listFiles()){
			if(f.getName().endsWith(".txt")){
				results+=f.getName()+"\n";
            }
	}
	return results;
	
}
}