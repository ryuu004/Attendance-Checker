package Start;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class loginView extends JFrame {

    // Variables
    int width = 900;
    int height = 600;
    Font robotoFont = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    Font robotoFont1 = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    
    
    private JPanel contentPane;
    private JTextField textField;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginView frame = new loginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginView() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, width, height);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(0x201a59));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel formView = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 13, 13));
                g2.dispose();
                super.paintComponent(g2);
            }
        };
        formView.setFont(new Font("Tahoma", Font.PLAIN, 12));
        formView.setBackground(new Color(0x2f2678));
        formView.setBounds(184, 31, 515, 494);

        contentPane.add(formView);
        formView.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome back!");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(robotoFont.deriveFont(Font.BOLD, 20));
        lblNewLabel.setBounds(22, 11, 238, 46);
        formView.add(lblNewLabel);

        
        JLabel lblNewLabel_1 = new JLabel("Please sign-in to access your account.");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(robotoFont.deriveFont(Font.BOLD, 15));
        lblNewLabel_1.setBounds(45, 53, 359, 46);
        formView.add(lblNewLabel_1);
        
        JPanel usernameField = new JPanel() {
        	
        	@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 5, 5));
                g2.dispose();
                super.paintComponent(g2);
        	
        }
        };
    
    
        usernameField.setBounds(55, 158, 173, 30);
        formView.add(usernameField);
        usernameField.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(10, 0, 153, 31);
        usernameField.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("ENTER USERNAME:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(null);
        lblNewLabel_1_1.setBounds(55, 110, 359, 46);
        formView.add(lblNewLabel_1_1);
        
        JPanel linear = new JPanel();
        linear.setLayout(null);
        linear.setBounds(0, 95, 515, 2);
        formView.add(linear);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBounds(55, 270, 405, 20);
        formView.add(panel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("ENTER USERNAME:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(null);
        lblNewLabel_1_1_1.setBounds(55, 199, 359, 46);
        formView.add(lblNewLabel_1_1_1);

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
