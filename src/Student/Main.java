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
        leftPanel.setBackground(new Color(0x212894));
        leftPanel.setPreferredSize(new Dimension(200, 600));

        // Middle panel with schedule table
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(new Color(0x121866));
        middlePanel.setPreferredSize(new Dimension(500, 600));

        // Panel at the top of the table
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 200)); // Adjust the height as needed
        topPanel.setLayout(new BorderLayout());

        // Load the cover photo image using getResource
        ImageIcon coverPhotoIcon = new ImageIcon(Main.class.getResource("/Images/Cover.png"));
        JLabel coverPhotoLabel = new JLabel(coverPhotoIcon);
        topPanel.add(coverPhotoLabel);


        // Add the top panel to the middle panel
        middlePanel.add(topPanel, BorderLayout.NORTH);

        // Right panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 600));

        // Button to modify status
        JButton modifyStatusButton = new JButton("Status");
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
        ImageIcon originalIcon = new ImageIcon(Main.class.getResource("/ProfileIcons/Student2icon.png"));

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

        // Set background color and font color for buttons
        Color buttonColor = new Color(0x2f2678); // Hexadecimal color #121866
        profileBtn.setBackground(buttonColor);
        friendsBtn.setBackground(buttonColor);
        settingsBtn.setBackground(buttonColor);
        logoutBtn.setBackground(buttonColor);

        profileBtn.setForeground(Color.WHITE); // Set font color to white
        friendsBtn.setForeground(Color.WHITE); // Set font color to white
        settingsBtn.setForeground(Color.WHITE); // Set font color to white
        logoutBtn.setForeground(Color.WHITE); // Set font color to white

        // Set preferred sizes for the buttons
        Dimension buttonSize = new Dimension(100, 70); // Adjust as needed
        profileBtn.setPreferredSize(buttonSize);
        friendsBtn.setPreferredSize(buttonSize);
        settingsBtn.setPreferredSize(buttonSize);
        logoutBtn.setPreferredSize(buttonSize);

        // Create a panel for the other buttons
        JPanel navBarPanel = new JPanel(new GridLayout(4, 1));
        navBarPanel.setBackground(new Color(0x121866));
        navBarPanel.add(profileBtn);
        navBarPanel.add(friendsBtn);
        navBarPanel.add(settingsBtn);
        navBarPanel.add(logoutBtn);

        // Create a panel for the profile button
        JPanel profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setPreferredSize(new Dimension(100, 100));
        profilePanel.setBackground(new Color(0x201a59));
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
        String[] columnNames = {"Teacher", "Subject", "Time"};

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(scheduleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

// Create table
        JTable scheduleTable = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row)) {
                    component.setBackground(new Color(0x7e40e3));
                    component.setForeground(new Color(0xe1cfff));
                } else {
                    component.setBackground(row % 2 == 0 ? new Color(0xc4a6f5) : Color.WHITE);
                    component.setForeground(Color.BLACK);
                }
                return component;
            }
        };

        // Add mouse listener to handle hover effect
        scheduleTable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = scheduleTable.rowAtPoint(e.getPoint());
                if (row > -1) {
                    scheduleTable.clearSelection(); // Clear previous selection
                    scheduleTable.setRowSelectionInterval(row, row); // Select the current row
                }
            }
        });

        scheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                scheduleTable.clearSelection(); // Clear selection when mouse exits the table
            }
        });

        scheduleTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        scheduleTable.getTableHeader().setPreferredSize(new Dimension(500, 40));
        scheduleTable.getTableHeader().setBackground(new Color(0x231b69));
        scheduleTable.getTableHeader().setForeground(Color.white);
        scheduleTable.setRowHeight(40); // Set row height
        scheduleTable.setFont(new Font("Arial", Font.PLAIN, 12));
        ((DefaultTableCellRenderer) scheduleTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER); // Center align header text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Center align cell text
        scheduleTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        scheduleTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        scheduleTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

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
}
