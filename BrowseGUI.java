import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class BrowseGUI extends JFrame {

	private JPanel contentPane;

	
	public BrowseGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomemsg = new JLabel("Now we have...");
		welcomemsg.setForeground(new Color(240, 128, 128));
		welcomemsg.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		welcomemsg.setBounds(23, 17, 258, 16);
		contentPane.add(welcomemsg);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 40, 371, 187);
		contentPane.add(textArea);
		
		 File sourceFolder = new File("./Recipe/");
		 StringBuilder builder = new StringBuilder();
         for (File f : sourceFolder.listFiles()) {
        	 builder.append(f.getName().substring(0, f.getName().lastIndexOf(".")));
           
	}
         String output = builder.toString();
         textArea.setText(output);
         
         JButton btnNewButton = new JButton("exit");
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		dispose();
         		MainGUI mgui=new MainGUI();
         		mgui.setVisible(true);
         	}
         });
         btnNewButton.setForeground(UIManager.getColor("Button.select"));
         btnNewButton.setBounds(164, 237, 117, 29);
         contentPane.add(btnNewButton);
}
}
