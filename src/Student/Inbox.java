package Student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Inbox extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inbox frame = new Inbox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Inbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 783, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 747, 39);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LUCIFER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 0, 121, 38);
		panel.add(lblNewLabel);
		
		JLabel lblLoremIpsumDolor = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		lblLoremIpsumDolor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLoremIpsumDolor.setBounds(132, 0, 498, 38);
		panel.add(lblLoremIpsumDolor);
		
		JPanel cov00 = new JPanel();
		cov00.setBackground(new Color(0, 0, 0));
		cov00.setBounds(105, 0, 17, 39);
		panel.add(cov00);
		
		JPanel cov01 = new JPanel();
		cov01.setBackground(new Color(0, 0, 0));
		cov01.setBounds(640, 0, 10, 39);
		panel.add(cov01);
		
		JLabel lblNewLabel_1 = new JLabel("03/05/2024");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(657, 0, 90, 38);
		panel.add(lblNewLabel_1);
		
	

		
		
		//Auto Center
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-getWidth())/2);
		int y=(int)((d.getHeight()-getHeight())/2);
		setLocation(x, y);

				
	}

}
