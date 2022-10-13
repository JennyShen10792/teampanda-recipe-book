import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class AllOrStep extends JFrame {

	private JPanel contentPane;
	private JButton readAllBtn;
	private JButton stepBtn;
	private JButton exitBtn;

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	
	
	/**
	 * Create the frame.
	 */
	
	// This is the GUI for readAll or Step through instructions
	public AllOrStep(String fileName,JFrame jf) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		readAllBtn = new JButton("Read Entire Recipe");
		readAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show entire recipe at once!
				dispose();
				RenderGUI ra = new RenderGUI(fileName,true);
				ra.setVisible(true);
			}
		});
		readAllBtn.setBounds(139, 39, 159, 43);
		contentPane.add(readAllBtn);
		
		stepBtn = new JButton("Step Through");
		stepBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//step through the recipe
				dispose();
				RenderGUI ra = new RenderGUI(fileName,false);
				ra.setVisible(true);
			}
		});
		stepBtn.setBounds(152, 106, 133, 49);
		contentPane.add(stepBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				jf.setVisible(true);
			}
		});
		exitBtn.setBounds(162, 177, 117, 43);
		contentPane.add(exitBtn);
		setVisible(true);
	}


}
