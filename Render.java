import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Render extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	/**
	 * Create the frame.
	 */
	
	public void showAll(String FileName) {
		File sourceFolder = new File("./Recipe/" + FileName + ".txt");
		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileContent);
		textArea.setText(fileContent);
		contentPane.repaint();
	}
	
	public void stepThrough(String FileName) {
		
	}
	
	public Render(String FileName){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(0, 0, 450, 278);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		showAll(FileName);
		setVisible(true);
	}

}
