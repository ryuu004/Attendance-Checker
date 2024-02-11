package Start;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class studentOrTeacher extends JFrame {

    // Variables
    int width = 900;
    int height = 600;
    Font robotoFont = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    Font robotoFont1 = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    
    
    private JPanel contentPane;
    private JTextField textField_1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    studentOrTeacher frame = new studentOrTeacher();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public studentOrTeacher() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, width, height);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(0x201a59));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel formView = new JPanel();
        formView.setOpaque(false);
            
        formView.setFont(new Font("Tahoma", Font.PLAIN, 12));
        formView.setBackground(new Color(0x2f2678));
        formView.setBounds(184, 31, 515, 494);

        contentPane.add(formView);
        formView.setLayout(null);
        
        JLabel teacher = new JLabel("");
        teacher.setIcon(new ImageIcon(studentOrTeacher.class.getResource("/Images/teacher.png")));
        teacher.setBounds(150, 98, 216, 102);
        formView.add(teacher);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 138, 136, 5);
        formView.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(379, 138, 136, 5);
        formView.add(panel_1);
        
        JLabel teacher_1 = new JLabel("");
        teacher_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//
        		
        	}
        });
        teacher_1.setIcon(new ImageIcon(studentOrTeacher.class.getResource("/Images/student.png")));
        teacher_1.setBounds(150, 270, 216, 102);
        formView.add(teacher_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 312, 136, 5);
        formView.add(panel_2);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(379, 312, 136, 5);
        formView.add(panel_1_1);
        
        JPanel viewCover = new JPanel() {
        	@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 12, 12));
                g2.dispose();
                super.paintComponent(g2);
        	
        }
        };
        
        viewCover.setBackground(new Color(0x2f2678));
        viewCover.setBounds(0, 37, 224, 50);
        formView.add(viewCover);
        viewCover.setLayout(null);
        
        JLabel text00 = new JLabel("WHAT ARE YOU?");
        text00.setHorizontalAlignment(SwingConstants.CENTER);
        text00.setHorizontalTextPosition(SwingConstants.CENTER);
        text00.setBounds(0, 0, 224, 50);
        viewCover.add(text00);
        text00.setForeground(new Color(255, 255, 255));
        text00.setFont(robotoFont.deriveFont(Font.BOLD, 18));
   
 
        // Auto Center
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((d.getWidth() - getWidth()) / 2);
        int y = (int) ((d.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private Font loadFont(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            if (is == null) {
                throw new IOException("Font file not found: " + path);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
