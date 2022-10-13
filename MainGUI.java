import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnCreate;
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public void btnc_click() {
		close();
		CreateGUI cgui=new CreateGUI();
		cgui.setVisible(true);
		}
     
	public void btns_click() {
		close();
		SearchGUI sgui=new SearchGUI();
		sgui.setVisible(true);
		}
        
	public void btnb_click() {
		close();
		BrowseGUI bgui=new BrowseGUI();
		bgui.setVisible(true);
		}
	
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreate = new JButton("Create a new recipe");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnc_click();
			}
		});
		btnCreate.setBounds(117, 38, 206, 29);
		contentPane.add(btnCreate);
		
		JButton btnSearch = new JButton("Search a recipe");
		btnSearch.setBounds(117, 108, 206, 29);
		 btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btns_click();
			}
		});
		contentPane.add(btnSearch);
		
		JButton btnBrowse = new JButton("Browse all recipes");
		btnBrowse.setBounds(117, 174, 206, 29);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnb_click();
			}
		});
		contentPane.add(btnBrowse);
		
		
		
	}
}