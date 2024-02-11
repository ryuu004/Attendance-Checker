package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class SettingsWindow {
    private JFrame frame;

    public SettingsWindow(JFrame mainFrame) {
        // Create the frame
        frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUndecorated(true);
        // Create a custom title bar panel
        JPanel titleBarPanel = new JPanel(new BorderLayout());
        titleBarPanel.setBackground(new Color(0x201a59));
        titleBarPanel.setPreferredSize(new Dimension(frame.getWidth(), 30)); // Set the height as needed

        // Add the title bar panel to the frame's content pane at the top
        frame.getContentPane().add(titleBarPanel, BorderLayout.NORTH);

        // Create a JLabel for the close button
        JLabel closeButton = new JLabel("x", SwingConstants.CENTER);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Add padding
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Close the frame when the close button is clicked
            }
        });

        // Add the close button to the title bar panel on the right side
        titleBarPanel.add(closeButton, BorderLayout.EAST);

        // Create left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0x201a59));
        leftPanel.setPreferredSize(new Dimension(300, 600)); // Same size as the left panel in the student page

        // Create back button panel
        JPanel backButtonPanel = new JPanel(new BorderLayout());
        backButtonPanel.setBackground(new Color(0x201a59));
        backButtonPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding
        backButtonPanel.setPreferredSize(new Dimension(300, 100)); // Increase panel height

        // Load back button image
        BufferedImage backButtonImage = null;
        try {
            backButtonImage = ImageIO.read(getClass().getResource("/Images/backbutton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon backButtonIcon = new ImageIcon(backButtonImage);
        JLabel backButton = new JLabel(backButtonIcon);
        backButton.setPreferredSize(new Dimension(50, 50)); // Adjust button size as needed
        backButton.setHorizontalAlignment(SwingConstants.LEFT); // Align button to the left

        // Add back button to the back button panel
        backButtonPanel.add(backButton, BorderLayout.NORTH);

        // Add text "Personal Information"
        JLabel personalInfoLabel = new JLabel("Settings");
        personalInfoLabel.setForeground(Color.WHITE);
        personalInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        personalInfoLabel.setBorder(new EmptyBorder(100, 0, 10, 0)); // Add border to text

        // Center the text horizontally
        JPanel personalInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center the components horizontally
        personalInfoPanel.setBackground(new Color(0x201a59));
        personalInfoPanel.add(personalInfoLabel);
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Add back button panel to the left panel
        leftPanel.add(backButtonPanel, BorderLayout.NORTH);
        leftPanel.add(personalInfoPanel, BorderLayout.CENTER);

        // Add left panel to the frame
        frame.add(leftPanel, BorderLayout.WEST);

        // Add mouse listener to back button label
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Close the frame when the back button is clicked
                mainFrame.setVisible(true); // Show the main student page window
            }
        });

        // Create center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 0, 20)); // Three rows, one column, with 20px vertical gap
        centerPanel.setBorder(new EmptyBorder(50, 50, 50, 50)); // Add padding
        centerPanel.setBackground(Color.white);

        // Create Account panel
        JPanel accountPanel = new JPanel(new BorderLayout());
        accountPanel.setBackground(Color.WHITE);
        JLabel accountLabel = new JLabel("Account Management");
        accountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        accountLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        accountPanel.add(accountLabel, BorderLayout.NORTH);



        // Create panel for Change Username and Change Password
        JPanel changePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Left-aligned layout
        changePanel.setBackground(Color.WHITE);
        changePanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        // Add Change Username label
        JLabel changeUsernameLabel = new JLabel("Change Username");
        customizeLabel(changeUsernameLabel);
        changePanel.add(changeUsernameLabel);
        changeUsernameLabel.setForeground(Color.BLACK);
        changePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        changeUsernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add Change Password label
        JLabel changePasswordLabel = new JLabel("Change Password");
        customizeLabel(changePasswordLabel);
        changePanel.add(changePasswordLabel);
        changePasswordLabel.setForeground(Color.BLACK);
        changePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));


        // Add change panel to account settings panel
        accountPanel.add(changePanel, BorderLayout.CENTER);

        // Create Deletion panel
        JPanel deletionPanel = new JPanel(new BorderLayout());
        deletionPanel.setBackground(Color.WHITE);
        JLabel deletionLabel = new JLabel("Account Deletion");
        deletionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        deletionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        deletionPanel.add(deletionLabel, BorderLayout.NORTH);

        // Create panel for the delete button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        // Create delete button
        JButton deleteButton = new JButton("Delete Account");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 11));
        deleteButton.setBackground(new Color(0x231b69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setPreferredSize(new Dimension(125, 25)); // Set preferred size directly on the button

        // Add delete button to the button panel
        buttonPanel.add(deleteButton);

        // Add button panel to the deletion panel
        deletionPanel.add(buttonPanel, BorderLayout.CENTER);

        // Create Contact Support panel
        JPanel contactSupportPanel = new JPanel(new BorderLayout());
        contactSupportPanel.setBackground(Color.WHITE);
        JLabel contactSupportLabel = new JLabel("Contact Support");
        contactSupportLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contactSupportLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        contactSupportPanel.add(contactSupportLabel, BorderLayout.NORTH);

        JLabel concernLabel = new JLabel("Do you have any concern?");
        concernLabel.setForeground(new Color(0x800080)); // Purple color
        concernLabel.setBorder(BorderFactory.createEmptyBorder(0, 170, 40, 0));
        contactSupportPanel.add(concernLabel, BorderLayout.CENTER);


        // Add panels to center panel
        centerPanel.add(accountPanel);
        centerPanel.add(deletionPanel);
        centerPanel.add(contactSupportPanel);

        // Add center panel to the frame
        frame.add(centerPanel, BorderLayout.CENTER);

        // Set frame size and make it visible
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void customizeLabel(JLabel label) {
        label.setForeground(Color.BLACK);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(new Color(0x800080));
                label.setFont(new Font("Arial", Font.BOLD, 14));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.BLACK);
                label.setFont(new Font("Arial", Font.PLAIN, 14));

            }
        });
    }
}
