import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.*;

public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	private JButton searchButton;
	private List<JButton> recipeButtons;
	private JTextArea recipeArea;
	
	private ArrayList<String> search(String word) {
        ArrayList<String> matches = new ArrayList<String>();
        try {
            File sourceFolder = new File("./Recipe/");
            for (File f : sourceFolder.listFiles()) {
                if (f.getName().toLowerCase().contains(word.toLowerCase())) {
                    matches.add(f.getName().substring(0, f.getName().lastIndexOf(".")));
                }
            }
        } catch (Exception e) {
            System.out.println("error with searching");
            e.printStackTrace();
        }
        return matches;

    }
	
	private void recipeBtnClick(String fileName) throws IOException {
		
		if (recipeArea == null) {
			recipeArea = new JTextArea();
			recipeArea.setBounds(20, 500, 775, 600);
			recipeArea.setLineWrap(true);
			// add recipeArea to contentPane
			contentPane.add(recipeArea);
		}
		
		
		
		File sourceFolder = new File("./Recipe/" + fileName + ".txt");
		
		// Read file
		//
		String fileContent = "";
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFolder))) {
		    String line;
		    StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters   
		    while((line=br.readLine())!=null)  
		    {  
		    sb.append(line);      //appends line to string buffer  
		    sb.append("\n");     //line feed   
		    }  
		    fileContent = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileContent);
		recipeArea.setText(fileContent);
		contentPane.repaint();
	}
	
	private void searchBtnClick() {
		
		for (int i = 0; i < recipeButtons.size(); i++) {
			
			contentPane.remove(recipeButtons.get(i));
		}

		System.out.println(searchField);
		String searchWords = searchField.getText();
		
		System.out.println(searchWords);
		ArrayList<String> searchResults = search(searchWords);
		System.out.println(searchResults);
		
		if (! searchResults.isEmpty()) {
			int y = 100;
			for (int i = 0; i < searchResults.size(); i++) {
				
				final String searchResult = searchResults.get(i);
				JButton recipeBtn = new JButton(searchResult);
				System.out.println(recipeBtn);
				recipeButtons.add(recipeBtn);
				
				recipeBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							recipeBtnClick(searchResult);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				recipeBtn.setBounds(50, y, 400, 29);
				contentPane.add(recipeBtn);
				y = y + 25;		
			}
			
		}
		contentPane.repaint();	
				
		
	}
	
	
	
	public SearchGUI() {
		
		recipeButtons = new ArrayList<JButton>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomemsg = new JLabel("Search for a Recipe");
		welcomemsg.setForeground(new Color(240, 128, 128));
		welcomemsg.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		welcomemsg.setBounds(23, 17, 258, 16);
		contentPane.add(welcomemsg);
		
		searchField = new JTextField();
		searchField.setBounds(52, 50, 300, 50);
		contentPane.add(searchField);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(400, 108, 206, 29);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBtnClick();
			}
			
			
		});
		
		contentPane.add(searchButton);
		

//		 File sourceFolder = new File("./Recipe/");
//		 StringBuilder builder = new StringBuilder();
//         for (File f : sourceFolder.listFiles()) {
//        	 String fileName = f.getName().substring(0, f.getName().lastIndexOf("."));
//        	 if (fileName.toLowerCase().contains(searchWords.toLowerCase())
//        	 
//
//
//        	 builder.append(f.getName().substring(0, f.getName().lastIndexOf(".")));
//             builder.append("\n");
//	}
 
}
}