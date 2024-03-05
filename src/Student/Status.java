package Student;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Status extends JFrame {

	private JPanel contentPane;

	private static final String ON_BUTTON_PATH = "/Images/on-button.png";
    private static final String OFF_BUTTON_PATH = "/Images/off-button (4).png";

    // Track the state of the switch
    private boolean isSwitchOn = false;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Status frame = new Status();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Status() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 244, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 207, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACTIVE STATUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 0, 121, 38);
		panel.add(lblNewLabel);
		
		JLabel switch00 = new JLabel("New label");
		switch00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//		
				
				// Toggle the state
                isSwitchOn = !isSwitchOn;

                // Update the icon based on the new state
                if (isSwitchOn) {
                    ImageIcon iconOn = new ImageIcon(getClass().getResource(ON_BUTTON_PATH));
                    switch00.setIcon(iconOn);
                } else {
                    ImageIcon iconOff = new ImageIcon(getClass().getResource(OFF_BUTTON_PATH));
                    switch00.setIcon(iconOff);
                }        
		        			
			}
		});
		switch00.setBounds(161, 0, 55, 42);
		switch00.setText("");
		panel.add(switch00);
		
		try {            
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/off-button (4).png"));
            switch00.setIcon(icon);            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or error loading image");
        }

		
		
		//Auto Center
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-getWidth())/2);
		int y=(int)((d.getHeight()-getHeight())/2);
		setLocation(x, y);

				
	}
}
