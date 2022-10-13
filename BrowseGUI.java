import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import java.awt.SystemColor;

public class BrowseGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<JButton> allFilesBtn;
	private JLabel welcomemsg;

	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public BrowseGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		welcomemsg = new JLabel("Now we have...");
		welcomemsg.setForeground(new Color(240, 128, 128));
		welcomemsg.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		welcomemsg.setBounds(23, 17, 258, 16);
		contentPane.add(welcomemsg);
		
		File sourceFolder = new File("./Recipe/");
		
//		 StringBuilder builder = new StringBuilder();
//         for (File f : sourceFolder.listFiles()) {
//        	 builder.append(f.getName().substring(0, f.getName().lastIndexOf("."))+"\n");
//           
//	}
//         String output = builder.toString();

		int fileCnt = sourceFolder.list().length;
		int y = 45;
		int x = 23;
		for (File f : sourceFolder.listFiles()) {
			String file_name = f.getName();
			if (!file_name.contains(".json") || file_name.charAt(0) == '.') continue;
			int pos = file_name.lastIndexOf('.');
			assert(pos != -1);
			final String fn_noExt = file_name.substring(0,pos);
			JButton listFileBtn = new JButton(fn_noExt);
	        listFileBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		AllOrStep aos = new AllOrStep(fn_noExt,new BrowseGUI());
	        		aos.setVisible(true);
	        	}
	        });
	        
	        
	        Dimension btnSize = listFileBtn.getPreferredSize();
	        int width,height;
	        width = btnSize.width;
	        height = btnSize.height;
	        if (x > 450 || x + width > 450) {
	        	x = 23;
	        	y += height;
	        }
	        listFileBtn.setBounds(x,y,width,height);
	        x += width;
	        contentPane.add(listFileBtn);
		}
		
         
        
        
        
        
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
