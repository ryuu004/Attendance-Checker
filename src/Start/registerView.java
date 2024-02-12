package Start;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.plaf.JCalendarTheme;
import javax.swing.Timer;

public class registerView extends JFrame {

    // Variables
    int width = 900;
    int height = 600;
    Font robotoFont = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    Font robotoFont1 = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    private static final String FILE_PATH = "src\\read\\entryNumber.txt"; //LOAD     
    static JLabel showPassword;    
    static JLabel op02;
    static JLabel op01;    
    static int statusStudentI;
    static int entryNumber = 1; //
    private JDateChooser dateChooser;
    private JPanel contentPane;
    private JTextField userName;
    private JTextField tpPassword;
    private JTextField textField_1;
    private JTextField name;
    private JTextField textField_3;
    private JTextField emailField;
    private JTextField contactField;
    private JTextField mailText;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	registerView frame = new registerView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public registerView() {
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
        formView.setBounds(184, 31, 515, 507);

        contentPane.add(formView);
        formView.setLayout(null);

        JLabel lblNewLabel = new JLabel("Hello, user!");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(robotoFont.deriveFont(Font.BOLD, 20));
        lblNewLabel.setBounds(207, 11, 238, 46);
        formView.add(lblNewLabel);

        
        JLabel lblNewLabel_1 = new JLabel("Register an account");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(robotoFont.deriveFont(Font.BOLD, 15));
        lblNewLabel_1.setBounds(187, 38, 359, 46);
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
    
    
        usernameField.setBounds(55, 400, 173, 30);
        formView.add(usernameField);
        usernameField.setLayout(null);
        
        userName = new JTextField();
        userName.setBounds(10, 0, 153, 31);
        userName.setHorizontalAlignment(JTextField.CENTER); 
        usernameField.add(userName);
        userName.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("CREATE USERNAME:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(null);
        lblNewLabel_1_1.setBounds(85, 360, 331, 46);
        formView.add(lblNewLabel_1_1);
        
        JPanel linear = new JPanel();
        linear.setLayout(null);
        linear.setBounds(0, 80, 515, 2);
        formView.add(linear);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("CREATE PASSWORD");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(null);
        lblNewLabel_1_1_1.setBounds(288, 360, 208, 46);
        formView.add(lblNewLabel_1_1_1);
        
        JPanel passwordField = new JPanel() {
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
        passwordField.setLayout(null);
        passwordField.setBounds(260, 400, 173, 30);
        formView.add(passwordField);
        
        tpPassword = new JPasswordField();
        tpPassword.setColumns(10);
        tpPassword.setBounds(10, 0, 153, 31);
        passwordField.add(tpPassword);

        showPassword = new JLabel("");
        showPassword.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {       		
        		((JPasswordField) tpPassword).setEchoChar((char) 0);
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		((JPasswordField) tpPassword).setEchoChar('•');

        		             		
        	}
        });
        

        showPassword.setIcon(new ImageIcon(loginView.class.getResource("/Images/eye (1) (1).png")));
        showPassword.setBounds(464, 409, 26, 14);
        formView.add(showPassword);
        
        JLabel buttonRegister = new JLabel("");
        buttonRegister.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String get = userName.getText();
                String get01 = name.getText();
                String filePath = "src\\read\\eno.txt"; // RELATIVE PATH
                
                //LOAD NUMBER
                try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                    String line = reader.readLine();
                    if (line != null && !line.isEmpty()) {
                        entryNumber = Integer.parseInt(line.trim());
                    }
                } catch (IOException | NumberFormatException h) {
                    h.printStackTrace();
                    System.err.println("Error loading entryNumber: " + h.getMessage());
                }
                
                //UPLOAD
                try {
                    new File("src\\read\\").mkdirs();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    	writer.write(entryNumber + "  " + get + "  " + get01);
                        writer.newLine();
                        entryNumber++;
                        System.out.println("Data written to the file successfully.");                        
                    }
                    
                    
                    
                    //SAVE NUMBER
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                        writer.write(String.valueOf(entryNumber));
                        System.out.println(entryNumber);
                    } catch (IOException g) {
                        g.printStackTrace();
                        System.err.println("Error saving entryNumber: " + g.getMessage());
                    }
                    
                    
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Error writing to the file: " + ex.getMessage());
                }
            }
        });
        
        buttonRegister.setIcon(new ImageIcon(registerView.class.getResource("/Images/regButton.png")));
        buttonRegister.setBounds(350, 435, 165, 65);
        formView.add(buttonRegister);
        
        
        
        
          
        
        
        JLabel reg = new JLabel("Already have an account? Login");
        reg.setFont(new Font("Tahoma", Font.PLAIN, 11));
        reg.setForeground(new Color(255, 255, 128));
        reg.setBounds(23, 466, 291, 30);
        formView.add(reg);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("FULL NAME");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(null);
        lblNewLabel_1_1_2.setBounds(105, 95, 300, 46);
        formView.add(lblNewLabel_1_1_2);
        
        JPanel usernameField_1 = new JPanel() {
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
        usernameField_1.setLayout(null);
        usernameField_1.setBounds(55, 138, 173, 30);
        formView.add(usernameField_1);
        
        name = new JTextField();
        name.setHorizontalAlignment(JTextField.CENTER); 
        name.setColumns(10);
        name.setBounds(10, 0, 153, 31);
        usernameField_1.add(name);
        
        
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("ADDRESS");
        lblNewLabel_1_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_2_1.setFont(null);
        lblNewLabel_1_1_2_1.setBounds(218, 163, 260, 46);
        formView.add(lblNewLabel_1_1_2_1);
        
        JPanel usernameField_1_1 = new JPanel() {
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
        usernameField_1_1.setLayout(null);
        usernameField_1_1.setBounds(55, 201, 378, 30);
        formView.add(usernameField_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(10, 0, 358, 31);
        usernameField_1_1.add(textField_3);
        
        JPanel usernameField_2 = new JPanel() {
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
        usernameField_2.setLayout(null);
        usernameField_2.setBounds(55, 260, 173, 30);
        formView.add(usernameField_2);
        
        dateChooser = new JDateChooser();
        //dateChooser.setEnabled(false);
        dateChooser.setBounds(10, 0, 160, 31);
        
        // Date chooser text alignment
        IDateEditor dateEditor = dateChooser.getDateEditor();
        if (dateEditor instanceof JTextFieldDateEditor) {
            JTextFieldDateEditor textFieldDateEditor = (JTextFieldDateEditor) dateEditor;
            textFieldDateEditor.setHorizontalAlignment(JTextField.CENTER);
            //
            textFieldDateEditor.setEditable(false);
        }

        usernameField_2.add(dateChooser);
        
        
        
        JLabel bdayText = new JLabel("BIRTHDAY");
        bdayText.setForeground(Color.WHITE);
        bdayText.setFont(null);
        bdayText.setBounds(109, 224, 307, 46);
        formView.add(bdayText);
        
        JLabel lblNewLabel_1_1_1_2 = new JLabel("CONTACT NUMBER");
        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2.setFont(null);
        lblNewLabel_1_1_1_2.setBounds(288, 224, 208, 46);
        formView.add(lblNewLabel_1_1_1_2);
        
        JPanel passwordField_3 = new JPanel() {
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
        passwordField_3.setLayout(null);
        passwordField_3.setBounds(260, 260, 173, 30);
        formView.add(passwordField_3);
        
        contactField = new JTextField();
        contactField.setText("9");
        contactField.setBounds(45, 0, 118, 31);
        passwordField_3.add(contactField);
        contactField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("+63");
        lblNewLabel_3.setBounds(11, 8, 46, 14);
        passwordField_3.add(lblNewLabel_3);
        
        JPanel usernameField_1_1_1 = new JPanel() {
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
        usernameField_1_1_1.setLayout(null);
        usernameField_1_1_1.setBounds(55, 322, 378, 30);
        formView.add(usernameField_1_1_1);
        
        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(10, 0, 242, 31);
        emailField.setHorizontalAlignment(JTextField.CENTER); 
        usernameField_1_1_1.add(emailField);

        
        JLabel lblNewLabel_2 = new JLabel("@");
        lblNewLabel_2.setFont(robotoFont.deriveFont(Font.BOLD, 14));
        lblNewLabel_2.setBounds(254, 0, 25, 31);
        usernameField_1_1_1.add(lblNewLabel_2);
        
        mailText = new JTextField();
        mailText.setBounds(271, 0, 60, 31);
        mailText.setHorizontalAlignment(JTextField.CENTER); 
        usernameField_1_1_1.add(mailText);
        mailText.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel(".com");
        lblNewLabel_2_1.setFont(robotoFont.deriveFont(Font.BOLD, 12));
        lblNewLabel_2_1.setBounds(338, 0, 33, 31);
        usernameField_1_1_1.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_1_1_2_1_1 = new JLabel("EMAIL");
        lblNewLabel_1_1_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_2_1_1.setFont(null);
        lblNewLabel_1_1_2_1_1.setBounds(226, 281, 252, 46);
        formView.add(lblNewLabel_1_1_2_1_1);
        
        op01 = new JLabel("STUDENT");
        op01.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//
        		
        		statusStudentI = 0;
        		if (statusStudentI == 0) {
        			op01.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_ch (3).png")));
        			op02.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_unc (1).png")));
        			op01.setForeground(new Color(255, 255, 128));        	        
        			op02.setForeground(Color.WHITE);
        		} 
        		
        		
        	}
        });
        op01.setForeground(new Color(255, 255, 255));
        op01.setFont(robotoFont.deriveFont(Font.BOLD, 12));
        op01.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_unc (1).png")));
        op01.setBounds(307, 135, 98, 35);
        formView.add(op01);
        
        op02 = new JLabel("TEACHER");
        op02.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		statusStudentI = 1;
        		
        		if (statusStudentI == 1) {
        			op01.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_unc (1).png")));
        			op02.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_ch (3).png")));
        			op02.setForeground(new Color(255, 255, 128));  
        			op01.setForeground(Color.WHITE);
        		}  		
        	}
        });
        op02.setIcon(new ImageIcon(registerView.class.getResource("/Images/radio_unc (1).png")));
        op02.setForeground(Color.WHITE);
        op02.setFont(robotoFont.deriveFont(Font.BOLD, 12));
        op02.setBounds(410, 135, 109, 35);
        formView.add(op02);
        showPassword.setVisible(false);

        // 
        tpPassword.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateVisibility();
            }

            public void removeUpdate(DocumentEvent e) {
                updateVisibility();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateVisibility();
            }

            private void updateVisibility() {
                // 
                boolean hasText = ((JPasswordField) tpPassword).getPassword().length > 0;

                // 
                showPassword.setVisible(hasText);
            }
        
        });
   
                       
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
