package Start;
import Student.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame();
            frame.setSize(900, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(0x201a59));


            JPanel middlePanel = new JPanel();
            middlePanel.setPreferredSize(new Dimension(700, 500));
            middlePanel.setBackground(new Color(0x2f2678));
            middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

            JPanel greetPanel = new JPanel();
            greetPanel.setBackground(new Color(0x2f2678));
            greetPanel.setPreferredSize(new Dimension(700, 100));
            middlePanel.add(greetPanel);
            greetPanel.setLayout(new BorderLayout());

            JLabel welcomeLabel = new JLabel("Welcome User");
            welcomeLabel.setForeground(Color.WHITE);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            welcomeLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
            greetPanel.add(welcomeLabel, BorderLayout.NORTH);

            JLabel signInLabel = new JLabel("Please sign in to access your account");
            signInLabel.setForeground(Color.WHITE);
            signInLabel.setFont(new Font("Arial", Font.BOLD, 14));
            signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
            greetPanel.add(signInLabel, BorderLayout.CENTER);
            greetPanel.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));

            JPanel userInputPanel = new JPanel();
            userInputPanel.setBackground(new Color(0x2f2678));
            userInputPanel.setPreferredSize(new Dimension(700, 200));
            userInputPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
            userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));
            middlePanel.add(userInputPanel);

            JPanel userLabelPanel = new JPanel();
            userLabelPanel.setBackground(new Color(0x2f2678));
            userLabelPanel.setPreferredSize(new Dimension(700, 100));
            userInputPanel.add(userLabelPanel);
            userLabelPanel.setLayout(new BorderLayout());

            JLabel userLabel = new JLabel("ENTER USERNAME:");
            userLabel.setForeground(Color.WHITE);
            userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            userLabel.setHorizontalAlignment(SwingConstants.LEFT);
            userLabel.setBorder(new EmptyBorder(0, 40, 0, 0));
            userLabelPanel.add(userLabel);


            JPanel enterUserPanel = new JPanel();
            enterUserPanel.setBackground(new Color(0x2f2678));
            enterUserPanel.setPreferredSize(new Dimension(700, 100));
            userInputPanel.add(enterUserPanel);

            JTextField userField = new JTextField();
            userField.setPreferredSize(new Dimension(150,40));
            userField.setFont(new Font("Arial", Font.PLAIN, 14));
            userField.setBorder(new EmptyBorder(0, 20, 0, 0));
            enterUserPanel.add(userField);

            JPanel passLabelPanel = new JPanel();
            passLabelPanel.setBackground(new Color(0x2f2678));
            passLabelPanel.setPreferredSize(new Dimension(700, 100));
            userInputPanel.add(passLabelPanel);
            passLabelPanel.setLayout(new BorderLayout());

            JLabel passLabel = new JLabel("ENTER PASSWORD:");
            passLabel.setForeground(Color.WHITE);
            passLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            passLabel.setHorizontalAlignment(SwingConstants.LEFT);
            passLabel.setBorder(new EmptyBorder(0, 40, 0, 0));
            passLabelPanel.add(passLabel);

            JPanel enterPassPanel = new JPanel();
            enterPassPanel.setBackground(new Color(0x2f2678));
            enterPassPanel.setPreferredSize(new Dimension(700, 100));
            userInputPanel.add(enterPassPanel);

            JPasswordField passField = new JPasswordField();
            passField.setPreferredSize(new Dimension(150,40));
            passField.setFont(new Font("Arial", Font.PLAIN, 14));
            passField.setBorder(new EmptyBorder(0, 20, 0, 0));
            enterPassPanel.add(passField);


            JPanel clickPanel = new JPanel();
            clickPanel.setBackground(new Color(0x2f2678));
            clickPanel.setPreferredSize(new Dimension(700, 200));
            middlePanel.add(clickPanel);
            clickPanel.setLayout(new BorderLayout());

            JPanel BtnPanel = new JPanel();
            BtnPanel.setBackground(new Color(0x2f2678));
            BtnPanel.setPreferredSize(new Dimension(220, 50));
            BtnPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
            clickPanel.add(BtnPanel, BorderLayout.EAST);
            BtnPanel.setLayout(new BoxLayout(BtnPanel, BoxLayout.Y_AXIS));


            JLabel reghere = new JLabel("Don't have an account? Register here");
            reghere.setFont(new Font("Arial", Font.PLAIN, 11));
            reghere.setForeground(Color.white);
            reghere.setBorder(new EmptyBorder(20, 0, 0, 20));

            reghere.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    reghere.setForeground(new Color(0xe1cfff));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    reghere.setForeground(Color.WHITE);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    Register registerWindow = new Register(frame);

                    frame.setVisible(false);
                    frame.dispose();
                }
            });


            ImageIcon login = new ImageIcon("src/Images/button (1).png");
            JButton loginBtn = new JButton(login);
            loginBtn.setBackground(new Color(0x2f2678));
            loginBtn.setBorder(new EmptyBorder(0, 40, 0, 0));
            loginBtn.setBorderPainted(false);
            loginBtn.setContentAreaFilled(false);
            loginBtn.setFocusPainted(false);

            BtnPanel.add(loginBtn);
            BtnPanel.add(reghere);

            loginBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Student student = new Student();

                    frame.dispose();

                }
            });


            JPanel topPanel = new JPanel();
            topPanel.setBackground(new Color(0x201a59));
            topPanel.setPreferredSize(new Dimension(900, 30));

            JPanel bottomPanel = new JPanel();
            bottomPanel.setBackground(new Color(0x201a59));
            bottomPanel.setPreferredSize(new Dimension(900, 30));

            JPanel rightPanel = new JPanel();
            rightPanel.setBackground(new Color(0x201a59));
            rightPanel.setPreferredSize(new Dimension(200, 600));

            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(new Color(0x201a59));
            leftPanel.setPreferredSize(new Dimension(200, 600));

            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.add(leftPanel, BorderLayout.WEST);
            frame.add(rightPanel, BorderLayout.EAST);
            frame.add(middlePanel, BorderLayout.CENTER);


            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

        });
    }
}

