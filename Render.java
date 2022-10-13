import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Render extends JFrame {

	private JPanel contentPaneA;	//panel for readAll
	private JPanel contentPaneS;	//panel for stepThrough
	
	private JTextArea textArea;
	private JButton nextStep;
	private File sourceFolder;
	private String descript;
	private String ingreds;
	private JSONArray instr_json;
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	
	public void showAll(String FileName) throws ParseException {
		sourceFolder = new File("./Recipe/" + FileName + ".json");
		
		// Read file
		//
		String fileContent = "";
		JSONParser jsonParser = new JSONParser();
		try {
            //Read JSON file
			FileReader reader = new FileReader(sourceFolder);
            JSONObject recipe_obj = (JSONObject)jsonParser.parse(reader);
			descript = (String) recipe_obj.get("descript");
			ingreds = (String)recipe_obj.get("ingredients");
			instr_json = (JSONArray)recipe_obj.get("instructions");
			ArrayList<String> instr_al = new ArrayList<>();
			
			fileContent += "Description:\n" + descript + "\n";
			fileContent += "Ingredients:\n" + ingreds + "\n";
			for (int i = 0; i < instr_json.size(); i++) {
				instr_al.add((String) instr_json.get(i));
			}
			fileContent += "Instructions:\n";
			for (int i = 0; i < instr_al.size(); i++) {
				fileContent += (i+1) + ". " + instr_al.get(i) + "\n";
			}
			textArea.setText(fileContent);
			contentPaneA.repaint();
        }
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stepThrough(String FileName) {
		
		
	}
	
	public Render(String FileName,boolean readAll){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		if (readAll) {
			contentPaneA = new JPanel();
			contentPaneA.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPaneA);
			contentPaneA.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			scrollPane.setBounds(0, 0, 450, 300);
			contentPaneA.add(scrollPane);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			try {
				showAll(FileName);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setVisible(true);
		}
		else {
			contentPaneS = new JPanel();
			contentPaneS.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPaneS);
			contentPaneS.setLayout(null);
			
			nextStep = new JButton("Next Step...");
			nextStep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stepThrough(FileName);
				}
			});
			nextStep.setBounds(160,240,117,29);
			contentPaneS.add(nextStep);
			
		}
		
		
		
	}
	
	public void getDescript(File f) {
		
	}
}
