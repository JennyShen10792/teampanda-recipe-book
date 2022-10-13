import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

public class RenderGUI extends JFrame {

	private JPanel contentPaneA;	//panel for readAll
	private JPanel contentPaneS;	//panel for stepThrough
	private JTextArea textArea;
	private JButton nextStepBtn;
	private JButton exitBtn;
	private JScrollPane sp;
	private File sourceFolder;
	private String descript;
	private String ingreds;
	private JSONArray instr_json;
	private JSONParser jsonParser;
	private FileReader reader;
	private ArrayList<String> instr_al;
	//private Map<Integer,String> map;
	private int counter;
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	
	public void showAll(){
		String fileContent = "";
		fileContent += "Description:\n" + descript + "\r\n";
		fileContent += "Ingredients:\n" + ingreds + "\r\n";
			
		fileContent += "Instructions:\n";
		for (int i = 0; i < instr_al.size(); i++) {
			fileContent += (i+1) + ". " + instr_al.get(i) + "\n";
		}
		textArea.setText(fileContent);
		contentPaneA.repaint();
	}
	
	
	public void stepThrough(int count) {
		String addOn = "";
		if (count == 0) {
			addOn = "Description:\n" + descript + "\r\n";
		}
		else if (count == 1) {
			addOn = "Ingredients:\n" + ingreds + "\r\n";
		}
		else {
			if (count - 2 == 0) {
				addOn = "Instructions:\n1. " + instr_al.get(count-2) + "\r\n";
			}
			else if (count - 2 < instr_al.size()){
				addOn = (count - 1) + ". " + instr_al.get(count-2) + "\n"; 
			}
			
		}
		textArea.append(addOn);
		
	}
	
	public RenderGUI(String FileName,boolean readAll){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		try {
			getContents(FileName);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (readAll) {
			contentPaneA = new JPanel();
			contentPaneA.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPaneA);
			contentPaneA.setLayout(null);
			
			sp = new JScrollPane();
			sp.setBorder(new EmptyBorder(0, 0, 0, 0));
			sp.setBounds(0, 0, 450, 250);
			contentPaneA.add(sp);
			
			exitBtn = new JButton("Exit");
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MainGUI mgi = new MainGUI();
					mgi.setVisible(true);
				}
			});
			exitBtn.setBounds(160,250,117,29);
			contentPaneA.add(exitBtn);		
			
			textArea = new JTextArea();
			sp.setViewportView(textArea);
			showAll();
			setVisible(true);
		}
		else {
			counter = 0;
			contentPaneS = new JPanel();
			contentPaneS.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPaneS);
			contentPaneS.setLayout(null);
			
			sp = new JScrollPane();
			sp.setBounds(0,0,450,250);
			sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_AS_NEEDED);
			sp.setHorizontalScrollBarPolicy(sp.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			contentPaneS.add(sp);
			
			textArea = new JTextArea();
			sp.setViewportView(textArea);
			
			nextStepBtn = new JButton("Next Step...");
			nextStepBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stepThrough(counter);
					counter += 1;
					if (counter - 2 == instr_al.size()) {
						nextStepBtn.setEnabled(false);
					}
				}
			});
			nextStepBtn.setBounds(160,250,117,29);
			contentPaneS.add(nextStepBtn);
			
			exitBtn = new JButton("Exit");
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MainGUI mgi = new MainGUI();
					mgi.setVisible(true);
				}
				
			});
			exitBtn.setBounds(300,250,117,29);
			contentPaneS.add(exitBtn);
			
			
		}
		
		
		
	}
	
	public void getContents(String FileName) throws ParseException {
		sourceFolder = new File("./Recipe/" + FileName + ".json");
		jsonParser = new JSONParser();
		try{
			reader = new FileReader(sourceFolder);
			JSONObject recipe_obj = (JSONObject)jsonParser.parse(reader);
			descript = (String) recipe_obj.get("descript");
			ingreds = (String)recipe_obj.get("ingredients");
			instr_json = (JSONArray)recipe_obj.get("instructions");
			instr_al = new ArrayList<>();
			for (int i = 0; i < instr_json.size(); i++) {
				instr_al.add((String) instr_json.get(i));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
