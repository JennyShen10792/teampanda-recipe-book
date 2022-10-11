import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AllOrStep extends JFrame {

	private JPanel contentPane;
	private JButton readAllBtn;
	private JButton stepBtn;
	private JButton exitBtn;

	/**
	 * Launch the application.
	 */
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllOrStep frame = new AllOrStep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllOrStep() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		readAllBtn = new JButton("Read Entire Recipe");
		readAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		readAllBtn.setBounds(139, 39, 159, 43);
		contentPane.add(readAllBtn);
		
		stepBtn = new JButton("Step Through");
		stepBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//To Do
			}
		});
		stepBtn.setBounds(152, 106, 133, 49);
		contentPane.add(stepBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				BrowseGUI bgui = new BrowseGUI();
				bgui.setVisible(true);
			}
		});
		exitBtn.setBounds(162, 177, 117, 43);
		contentPane.add(exitBtn);
	}

}
