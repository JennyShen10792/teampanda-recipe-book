import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnCreate;
	
	public void btnc_click() {
		CreateGUI cgui=new CreateGUI();
		cgui.show();
		}
     
	public void btns_click() {
	  SearchGUI sgui=new SearchGUI();
		sgui.show();
		}
        
	public void btnb_click() {
		BrowseGUI bgui=new BrowseGUI();
		bgui.show();
		}
	
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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