package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class FriendsWindow {
    private JFrame frame;

    public FriendsWindow(JFrame mainFrame) {
        // Create the frame
        frame = new JFrame("Friends");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0x201a59));
        leftPanel.setPreferredSize(new Dimension(200, 600)); // Same size as the left panel in the student page

        // Create back button panel
        JPanel backButtonPanel = new JPanel(new BorderLayout());
        backButtonPanel.setBackground(new Color(0x201a59));
        backButtonPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding
        backButtonPanel.setPreferredSize(new Dimension(200, 100)); // Increase panel height

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
        JLabel personalInfoLabel = new JLabel("Friends");
        personalInfoLabel.setForeground(Color.WHITE);
        personalInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        personalInfoLabel.setBorder(new EmptyBorder(100, 0, 10, 0)); // Add border to text

        // Center the text horizontally
        JPanel personalInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center the components horizontally
        personalInfoPanel.setBackground(new Color(0x201a59));
        personalInfoPanel.add(personalInfoLabel);
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Add back button panel and centered personal information panel to the left panel
        leftPanel.add(backButtonPanel, BorderLayout.NORTH);
        leftPanel.add(personalInfoPanel, BorderLayout.CENTER);

        // Add left panel to the frame
        frame.add(leftPanel, BorderLayout.WEST);

        // Add mouse listener to back button label
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle back button click event here
                // For example, you can hide the profile window
                frame.dispose(); // Close the profile window
                // You can also show the main student page window here if it's already created
                mainFrame.setVisible(true); // Show the main student page window
            }
        });

        // Set frame size and make it visible
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
