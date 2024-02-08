package Student;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class Main {
    // Define the friend list model globally
    private static DefaultListModel<String> friendListModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Student Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setPreferredSize(new Dimension(200, 600));

        // Middle panel with schedule table
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(Color.WHITE);
        middlePanel.setPreferredSize(new Dimension(500, 600));

        // Panel at the top of the table
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(500, 150)); // Adjust the height as needed

        // Create a label or add components to the top panel as desired
        JLabel titleLabel = new JLabel("Schedule");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Example of setting font and size
        topPanel.add(titleLabel);

        // Add the top panel to the middle panel
        middlePanel.add(topPanel, BorderLayout.NORTH);

        // Right panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 600));

        // Button to modify status
        JButton modifyStatusButton = new JButton("Modify Status");
        modifyStatusButton.setPreferredSize(new Dimension(150, 50)); // Adjust button size as needed
        rightPanel.add(modifyStatusButton, BorderLayout.NORTH);

        // List of friends/teachers and their status
        friendListModel = new DefaultListModel<>();
        JList<String> friendList = new JList<>(friendListModel);
        friendList.setFixedCellHeight(40); // Set the height of each item
        JScrollPane friendScrollPane = new JScrollPane(friendList);
        friendScrollPane.setPreferredSize(new Dimension(150, 500)); // Adjust scroll pane size as needed
        rightPanel.add(friendScrollPane, BorderLayout.CENTER);

        // Load profile icon using getResource
        ImageIcon originalIcon = new ImageIcon(Main.class.getResource("/ProfileIcons/Student1icon.png"));

        // Create the profile icon button as a circle
        JButton profileButton = new JButton() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Create a circular mask
                int diameter = Math.min(getWidth(), getHeight());
                Shape mask = new Ellipse2D.Double(0, 0, diameter, diameter);

                // Set the clip to the circular mask
                g2.clip(mask);

                // Draw the scaled icon
                g2.drawImage(originalIcon.getImage(), 0, 0, diameter, diameter, null);
                g2.dispose();
            }
        };
        profileButton.setPreferredSize(new Dimension(150, 150)); // Adjust the size as needed
        profileButton.setContentAreaFilled(false); // Remove default button background

        // Create buttons for profile, friends, settings, and logout
        JButton profileBtn = new JButton("Profile");
        JButton friendsBtn = new JButton("Friends");
        JButton settingsBtn = new JButton("Settings");
        JButton logoutBtn = new JButton("Logout");

        // Set preferred sizes for the buttons
        Dimension buttonSize = new Dimension(100, 70); // Adjust as needed
        profileBtn.setPreferredSize(buttonSize);
        friendsBtn.setPreferredSize(buttonSize);
        settingsBtn.setPreferredSize(buttonSize);
        logoutBtn.setPreferredSize(buttonSize);

        // Create a panel for the other buttons
        JPanel navBarPanel = new JPanel(new GridLayout(4, 1));
        navBarPanel.add(profileBtn);
        navBarPanel.add(friendsBtn);
        navBarPanel.add(settingsBtn);
        navBarPanel.add(logoutBtn);

        // Create a panel for the profile button
        JPanel profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setPreferredSize(new Dimension(100, 100));
        profilePanel.add(profileButton);

        // Add components to the left panel
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(profilePanel, BorderLayout.CENTER);
        leftPanel.add(navBarPanel, BorderLayout.SOUTH);

        // Create schedule data
        Object[][] scheduleData = {
                {"Mr. Smith", "Math", "8:00 AM"},
                {"Ms. Johnson", "History", "9:30 AM"},
                {"Mr. Brown", "English", "11:00 AM"},
                {"Ms. Davis", "Science", "1:00 PM"},
                {"Mr. Wilson", "Art", "2:30 PM"},
                {"Ms. Lee", "Music", "4:00 PM"},
                {"Mr. Garcia", "Physical Education", "5:30 PM"},
                {"Ms. Martinez", "Computer Science", "7:00 PM"}
        };

        // Table column names
        String[] columnNames = {"Teacher Name", "Subject", "Time"};

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(scheduleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create table
        JTable scheduleTable = new JTable(tableModel);
        scheduleTable.setRowHeight(75); // Set row height

        // Create buttons renderer
        scheduleTable.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(scheduleTable);

        // Add scroll pane to middle panel
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        // Set frame size and make it visible
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add some initial friends
        addFriend("Friend 1 - online");
        addFriend("Friend 2 - online");
        addFriend("Friend 3 - offline");
        addFriend("Friend 4 - offline");
        addFriend("Friend 5 - online");
        addFriend("Friend 6 - offline");
        addFriend("Friend 7 - online");
        addFriend("Friend 8 - offline");
        addFriend("Friend 9 - online");
        addFriend("Friend 10 - offline");
        addFriend("Friend 11 - offline");
        addFriend("Friend 12 - online");
        addFriend("Friend 13 - offline");
        addFriend("Friend 14 - offline");
        addFriend("Friend 15 - offline");
    }

    // Method to add a friend to the list
    private static void addFriend(String friendName) {
        friendListModel.addElement(friendName);
    }

    // Button renderer for table
    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
}
