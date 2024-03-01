package Student;
import Start.Main;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class Student extends  JFrame{
    private static DefaultListModel<String> friendListModel;
    private  JFrame mainFrame;

    public Student(JFrame mainFrame){
        this.mainFrame = mainFrame;
        JFrame frame = new JFrame("Student Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUndecorated(true);
        // Create a custom title bar panel
        JPanel titleBarPanel = new JPanel(new BorderLayout());
        titleBarPanel.setBackground(new Color(0x201a59));
        titleBarPanel.setPreferredSize(new Dimension(frame.getWidth(), 40));

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
                frame.dispose();
            }
        });

        titleBarPanel.add(closeButton, BorderLayout.EAST);

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
        topPanel.setPreferredSize(new Dimension(500, 200));
        topPanel.setLayout(new BorderLayout());

        // Load the cover photo image using getResource
        ImageIcon coverPhotoIcon = new ImageIcon(Student.class.getResource("/Images/Cover.png"));
        JLabel coverPhotoLabel = new JLabel(coverPhotoIcon);
        topPanel.add(coverPhotoLabel);


        // Add the top panel to the middle panel
        middlePanel.add(topPanel, BorderLayout.NORTH);

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 600));
        rightPanel.setLayout(new BorderLayout());

        // Button to modify status
        JButton modifyStatusButton = new JButton("Status");
        modifyStatusButton.setPreferredSize(new Dimension(150, 29));
        rightPanel.add(modifyStatusButton, BorderLayout.NORTH);
        modifyStatusButton.setBackground(new Color(0x2f2678));
        modifyStatusButton.setForeground(Color.WHITE);

        // Create a panel for the inbox button
        JPanel inboxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        inboxPanel.setBackground(new Color(0x201a59));
        inboxPanel.setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0));

        // Button to access inbox
        JButton inboxButton = new JButton("Inbox");
        inboxButton.setPreferredSize(new Dimension(200, 29));
        inboxPanel.add(inboxButton);
        inboxButton.setBackground(new Color(0x2f2678));
        inboxButton.setForeground(Color.WHITE);

        rightPanel.add(inboxPanel, BorderLayout.CENTER);

        // List of friends/teachers and their status
        friendListModel = new DefaultListModel<>();
        JList<String> friendList = new JList<>(friendListModel);
        friendList.setFixedCellHeight(40); // Set the height of each item
        friendList.setBackground(Color.white);
        friendList.setForeground(Color.BLACK);
        friendList.setLayoutOrientation(JList.VERTICAL);
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        friendList.setCellRenderer(new FriendListCellRenderer());

        // Set text alignment to center
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) friendList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        CustomScrollPane friendScrollPane = new CustomScrollPane(friendList);
        friendScrollPane.setPreferredSize(new Dimension(150, 500));
        rightPanel.add(friendScrollPane, BorderLayout.SOUTH);

        // Add right panel to the frame
        frame.add(rightPanel, BorderLayout.EAST);




        // Load profile icon using getResource
        ImageIcon originalIcon = new ImageIcon(Student.class.getResource("/ProfileIcons/Student2icon.png"));

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
        profileButton.setPreferredSize(new Dimension(150, 150));
        profileButton.setContentAreaFilled(false);

        // Create buttons for profile, friends, settings, and logout
        JButton profileBtn = new JButton("Profile");
        JButton friendsBtn = new JButton("Friends");
        JButton settingsBtn = new JButton("Settings");
        JButton logoutBtn = new JButton("Logout");

        // Set background color and font color for buttons
        Color buttonColor = new Color(0x2f2678);
        profileBtn.setBackground(buttonColor);
        friendsBtn.setBackground(buttonColor);
        settingsBtn.setBackground(buttonColor);
        logoutBtn.setBackground(buttonColor);


        // Inside createAndShowGUI() method in Main class
        profileBtn.addActionListener(e -> {

            ProfileWindow profileWindow = new ProfileWindow(frame);

            frame.setVisible(false);

            frame.dispose();
        });

        friendsBtn.addActionListener(e -> {

            FriendsWindow friendsWindow = new FriendsWindow(frame);

            frame.setVisible(false);

            frame.dispose();
        });

        settingsBtn.addActionListener(e -> {

            SettingsWindow settingsWindow = new SettingsWindow(frame);

            frame.setVisible(false);

            frame.dispose();
        });


        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                // Make the main frame (start window) visible again
                mainFrame.setVisible(true);


            }
        });


        profileBtn.setForeground(Color.WHITE);
        friendsBtn.setForeground(Color.WHITE);
        settingsBtn.setForeground(Color.WHITE);
        logoutBtn.setForeground(Color.WHITE);

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
                    scheduleTable.clearSelection();
                    scheduleTable.setRowSelectionInterval(row, row);
                }
            }
        });

        scheduleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                scheduleTable.clearSelection();
            }
        });

        scheduleTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        scheduleTable.getTableHeader().setPreferredSize(new Dimension(500, 40));
        scheduleTable.getTableHeader().setBackground(new Color(0x231b69));
        scheduleTable.getTableHeader().setForeground(Color.white);
        scheduleTable.setRowHeight(40); // Set row height
        scheduleTable.setFont(new Font("Arial", Font.PLAIN, 12));
        ((DefaultTableCellRenderer) scheduleTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        scheduleTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        scheduleTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        scheduleTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        // Add table to scroll pane
        CustomScrollPane scrollPane = new CustomScrollPane(scheduleTable);

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
        frame.setResizable(false);

        // Add some initial friends
        addFriend("John Doe", true);
        addFriend("Alice Smith", false);
        addFriend("Bob Johnson", true);
        addFriend("Emily Davis", false);
        addFriend("Michael Wilson", true);
        addFriend("Sarah Lee", true);
        addFriend("David Garcia", false);
        addFriend("Olivia Martinez", true);
        addFriend("James Brown", false);
        addFriend("Emma Harris", true);
        addFriend("Daniel Clark", false);
        addFriend("Sophia Adams", true);
        addFriend("William Turner", true);
        addFriend("Grace Thomas", false);
        addFriend("Liam White", true);
    }

    // Method to add a friend to the list
    private static void addFriend(String friendName, boolean isActive) {
        String status = isActive ? "Active" : "Offline";
        ImageIcon icon = new ImageIcon(Student.class.getResource("/Images/" + status + ".png"));
        friendListModel.addElement("<html><img src='" + icon + "' width='8' height='8'> &nbsp; " + friendName);
    }
}
