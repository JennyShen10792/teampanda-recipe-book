import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CreateGUI extends JFrame {

	private JPanel contentPane;

	
	public CreateGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomemsg = new JLabel("Create a new recipe!");
		welcomemsg.setForeground(new Color(240, 128, 128));
		welcomemsg.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		welcomemsg.setBounds(6, 6, 258, 16);
		contentPane.add(welcomemsg);
		
		JLabel lbl1 = new JLabel("title");
		lbl1.setForeground(Color.BLACK);
		lbl1.setBounds(6, 34, 93, 21);
		contentPane.add(lbl1);
		
	
		JLabel topmsg = new JLabel("description");
		topmsg.setForeground(Color.BLACK);
		topmsg.setBounds(6, 67, 84, 16);
		contentPane.add(topmsg);
		
		
		
		JLabel lbl2 = new JLabel("instructions");
		lbl2.setForeground(Color.BLACK);
		lbl2.setBounds(6, 157, 93, 16);
		contentPane.add(lbl2);
		
		
		JLabel lbl3 = new JLabel("ingredients");
		lbl3.setForeground(Color.BLACK);
		lbl3.setBounds(6, 100, 100, 16);
		contentPane.add(lbl3);
		
		
		JTextField title = new JTextField();
		title.setBounds(102, 34, 130, 26);
		contentPane.add(title);
		title.setColumns(10);

		
		JTextField descript = new JTextField();
		descript.setBounds(102, 62, 235, 26);
		contentPane.add(descript);
		descript.setColumns(10);
		
		JTextArea ingredients = new JTextArea();
		ingredients.setBounds(102, 100, 247, 34);
		contentPane.add(ingredients);
		
		JTextArea instructions = new JTextArea();
		instructions.setBounds(102, 139, 280, 71);

		
		
		contentPane.add(instructions);
		
		JButton btnSave = new JButton("save");
		
		btnSave.setForeground(new Color(250, 128, 114));
		btnSave.setBounds(64, 220, 117, 29);
		contentPane.add(btnSave);

		JLabel successmsg = new JLabel("  ");
		
		successmsg.setBounds(77, 250, 304, 16);
		contentPane.add(successmsg);
		
		JButton btnReturn = new JButton("exit");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainGUI mgui=new MainGUI();
				mgui.setVisible(true);
			}
		});
		btnReturn.setForeground(new Color(250, 128, 114));
		btnReturn.setBounds(228, 222, 117, 29);
		contentPane.add(btnReturn);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String recipe_title=title.getText();
                String recipe_descript=descript.getText();
                String recipe_ingredient=ingredients.getText();
                String instruct=instructions.getText();
		        ArrayList<String> recipe_instruct = new ArrayList<>(Arrays.asList(instruct.split("\n")));
				Recipe newRecipe = new Recipe(recipe_title, recipe_descript, recipe_ingredient, recipe_instruct);

        // create recipe with the name under "Recipe" folder
        String dir = "./Recipe/" + recipe_title + ".txt";
        File newFile = new File(dir);
        boolean flag = false;
     

        try {
            flag = newFile.createNewFile();
            if (flag) {
                successmsg.setText("Recipe created with name " + recipe_title+"!");
            
            } else {
                successmsg.setText("Recipe with name " + recipe_title + " already exist!");
            }
        } catch (IOException error) {
            successmsg.setText("An error occurred!");
            error.printStackTrace();
        }

        // Write to the recipe file if flag is true.
        if (flag) {
            // write description into the file
            try {
                FileWriter myWriter = new FileWriter(dir, true);
                myWriter.write("Description: \n" + recipe_descript + "\n");
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote description to the file.");

                // write a list of ingredients into the file

                myWriter.write("Ingredients: \n" + String.join(", ", recipe_ingredient + "\n"));
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote a list of ingredients!");

                // write cooking instructions into the file
                myWriter.write("Step-by-step cooking instructions: \n");
                for (int i = 0; i < recipe_instruct.size(); i++) {
                    myWriter.write((i + 1) + ". " + recipe_instruct.get(i) + "\n");
                }
                myWriter.write(System.getProperty("line.separator"));
                System.out.println("Successfully wrote cooking instructions!");
                myWriter.close();

            } catch (final IOException error) {
                System.out.println("An error occurred.");
                error.printStackTrace();
            }
            System.out.println("Successfully created and saved a new recipe!");
        }
				
					
				
			}
		});
		
		
	}
}
