import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
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
		welcomemsg.setBounds(23, 17, 258, 16);
		contentPane.add(welcomemsg);
		
		JLabel lbl1 = new JLabel("title");
		lbl1.setForeground(Color.BLACK);
		lbl1.setBounds(46, 45, 93, 21);
		contentPane.add(lbl1);
		
	
		JLabel topmsg = new JLabel("description");
		topmsg.setForeground(Color.BLACK);
		topmsg.setBounds(46, 78, 84, 16);
		contentPane.add(topmsg);
		
		
		
		JLabel lbl2 = new JLabel("instructions");
		lbl2.setForeground(Color.BLACK);
		lbl2.setBounds(46, 157, 93, 16);
		contentPane.add(lbl2);
		
		
		JLabel lbl3 = new JLabel("ingredients");
		lbl3.setForeground(Color.BLACK);
		lbl3.setBounds(46, 111, 100, 16);
		contentPane.add(lbl3);
		
		
		JTextField title = new JTextField();
		title.setBounds(151, 45, 130, 26);
		contentPane.add(title);
		title.setColumns(10);

		
		JTextField descript = new JTextField();
		descript.setBounds(151, 73, 235, 26);
		contentPane.add(descript);
		descript.setColumns(10);
		
		JTextArea ingredients = new JTextArea();
		ingredients.setBounds(151, 111, 235, 34);
		contentPane.add(ingredients);
		
		JTextArea instructions = new JTextArea();
		instructions.setBounds(151, 157, 280, 71);

		
		
		contentPane.add(instructions);
		
		JButton btnSave = new JButton("save");
		
		btnSave.setForeground(new Color(250, 128, 114));
		btnSave.setBounds(149, 229, 117, 29);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String recipe_title=title.getText();
                String recipe_descript=descript.getText();
                String recipe_ingredient=ingredients.getText();
                String instruct=instructions.getText();
		        ArrayList<String> recipe_instruct = new ArrayList<>(Arrays.asList(instruct.split("\n")));
				Recipe newRecipe = new Recipe(recipe_title, recipe_descript, recipe_ingredient, recipe_instruct);
			}
		});
		
		
	}
}
