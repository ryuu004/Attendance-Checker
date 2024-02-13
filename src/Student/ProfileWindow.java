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

public class ProfileWindow {
    private JFrame frame;

    public ProfileWindow(JFrame mainFrame) {
        // Create the frame
        frame = new JFrame("Profile");
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
        closeButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
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
        JLabel personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setForeground(Color.WHITE);
        personalInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        personalInfoLabel.setBorder(new EmptyBorder(100, 0, 10, 0)); // Add border to text

        // Center the text horizontally
        JPanel personalInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center the components horizontally
        personalInfoPanel.setBackground(new Color(0x201a59));
        personalInfoPanel.add(personalInfoLabel);
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Add back button panel and centered personal information panel to the left panel
        leftPanel.add(backButtonPanel, BorderLayout.NORTH);
        leftPanel.add(personalInfoPanel, BorderLayout.CENTER);

        // Add left panel to the frame
        frame.add(leftPanel, BorderLayout.WEST);

        // Create panel for student information
        JPanel studentInfoPanel = new JPanel();
        studentInfoPanel.setBackground(Color.WHITE);
        studentInfoPanel.setLayout(new GridLayout(6, 1)); // 6 rows for each information

        // Add student information labels
        String[] labels = {"Student Name:", "Student ID:", "Address:", "Birthday:", "Email:", "Contact No:"};
        String[] info = {"John Doe", "S123456", "123 Main Street", "January 1, 2000", "john.doe@example.com", "+1 (123) 456-7890"};

        for (int i = 0; i < labels.length; i++) {
            JPanel infoPanel = new JPanel(new BorderLayout());
            infoPanel.setBackground(Color.WHITE);

            JLabel label = new JLabel(labels[i]);
            JLabel value = new JLabel(info[i]);

            label.setFont(new Font("Arial", Font.BOLD, 16));
            value.setFont(new Font("Arial", Font.BOLD, 14));

            // Add margin to the left of label
            label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            value.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

            // Add components to infoPanel
            infoPanel.add(label, BorderLayout.WEST);
            infoPanel.add(value, BorderLayout.CENTER);

            // Create edit icon
            BufferedImage editIconImage = null;
            try {
                editIconImage = ImageIO.read(getClass().getResource("/Images/edit.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon editIcon = new ImageIcon(editIconImage);
            JLabel editIconLabel = new JLabel(editIcon);
            editIconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20)); // Add margin to the right of edit icon

            // Add mouse listener to edit icon label
            editIconLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Handle edit icon click
                    String newValue = JOptionPane.showInputDialog(frame, "Enter new value:");
                    if (newValue != null && !newValue.isEmpty()) {
                        // Update the information label with the new value
                        value.setText(newValue);
                    }
                }
            });

            // Add components to infoPanel
            infoPanel.add(editIconLabel, BorderLayout.EAST);

            // Add bottom border to infoPanel
            infoPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

            // Add infoPanel to studentInfoPanel
            studentInfoPanel.add(infoPanel);
        }

        // Add student information panel to the right panel
        frame.add(studentInfoPanel, BorderLayout.CENTER);

        // Add mouse listener to back button label
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                mainFrame.setVisible(true);
            }
        });

        // Set frame size and make it visible
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
