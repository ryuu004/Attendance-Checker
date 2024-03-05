package Admin;
import Student.CustomScrollPane;
import com.sun.jdi.ClassObjectReference;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Page");

        frame.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setBackground(new Color(0x201a59));
        leftPanel.setPreferredSize(new Dimension(300, 600));
        frame.add(leftPanel, BorderLayout.WEST);

        JButton inboxBtn = new JButton("Inbox");
        JButton logoutBtn = new JButton("Logout");

        Color buttonColor = new Color(0x2f2678);
        inboxBtn.setBackground(buttonColor);
        logoutBtn.setBackground(buttonColor);

        inboxBtn.setForeground(Color.WHITE);
        logoutBtn.setForeground(Color.WHITE);

        leftPanel.setBorder(new EmptyBorder(180, 0, 0, 0));

        leftPanel.add(inboxBtn);
        leftPanel.add(logoutBtn);

        Dimension buttonSize = new Dimension(300, 100);
        inboxBtn.setPreferredSize(buttonSize);
        logoutBtn.setPreferredSize(buttonSize);

        JPanel middlePanel = new JPanel(new FlowLayout());
        middlePanel.setBackground(new Color(0x121866));
        middlePanel.setPreferredSize(new Dimension(500, 600));
        frame.add(middlePanel, BorderLayout.CENTER);

        JPanel stdTablePanel = new JPanel(new BorderLayout());
        stdTablePanel.setBackground(new Color(0x121866));
        stdTablePanel.setPreferredSize(new Dimension(500, 270));
        middlePanel.add(stdTablePanel);

        JPanel tchTablePanel = new JPanel(new BorderLayout());
        tchTablePanel.setBackground(new Color(0x121866));
        tchTablePanel.setPreferredSize(new Dimension(500, 270));
        middlePanel.add(tchTablePanel);


        Object[][] stdTable = {
                {"1", "John Doe", "john@example.com"},
                {"2", "Alice Smith", "alice@example.com"},
                {"3", "Bob Johnson", "bob@example.com"},
                {"4", "Eve Brown", "eve@example.com"},
                {"5", "Charlie Wilson", "charlie@example.com"},
                {"6", "Emily Davis", "emily@example.com"},
                {"7", "Jack Garcia", "jack@example.com"},
                {"8", "Sophia Martinez", "sophia@example.com"}
        };

        // Table column names
        String[] columnNames = {"Student ID", "FullName", "Email"};

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(stdTable, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create table
        JTable studentTable = new JTable(tableModel) {
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
        studentTable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = studentTable.rowAtPoint(e.getPoint());
                if (row > -1) {
                    studentTable.clearSelection();
                    studentTable.setRowSelectionInterval(row, row);
                }
            }
        });

        studentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                studentTable.clearSelection();
            }
        });

        studentTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        studentTable.getTableHeader().setPreferredSize(new Dimension(500, 30));
        studentTable.getTableHeader().setBackground(new Color(0x231b69));
        studentTable.getTableHeader().setForeground(Color.white);
        studentTable.setRowHeight(30);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 12));
        ((DefaultTableCellRenderer) studentTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        studentTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);


        CustomScrollPane scrollPane = new CustomScrollPane(studentTable);
        scrollPane.setPreferredSize(new Dimension(500, 270));


        stdTablePanel.add(scrollPane, BorderLayout.CENTER);




        Object[][] tchTable = {
                {"1", "John Doe", "john@example.com"},
                {"2", "Alice Smith", "alice@example.com"},
                {"3", "Bob Johnson", "bob@example.com"},
                {"4", "Eve Brown", "eve@example.com"},
                {"5", "Charlie Wilson", "charlie@example.com"},
                {"6", "Emily Davis", "emily@example.com"},
                {"7", "Jack Garcia", "jack@example.com"},
                {"8", "Sophia Martinez", "sophia@example.com"}
        };

        // Table column names
        String[] columnNames1 = {"Teacher ID", "FullName", "Email"};

        // Create table model
        DefaultTableModel tableModel1 = new DefaultTableModel(tchTable, columnNames1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create table
        JTable teacherTable = new JTable(tableModel1) {
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
        teacherTable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = teacherTable.rowAtPoint(e.getPoint());
                if (row > -1) {
                    teacherTable.clearSelection();
                    teacherTable.setRowSelectionInterval(row, row);
                }
            }
        });

        teacherTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                teacherTable.clearSelection();
            }
        });

        teacherTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        teacherTable.getTableHeader().setPreferredSize(new Dimension(500, 30));
        teacherTable.getTableHeader().setBackground(new Color(0x231b69));
        teacherTable.getTableHeader().setForeground(Color.white);
        teacherTable.setRowHeight(30);
        teacherTable.setFont(new Font("Arial", Font.PLAIN, 12));
        ((DefaultTableCellRenderer) teacherTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
        teacherTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer1);
        teacherTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
        teacherTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);


        CustomScrollPane scrollPane1 = new CustomScrollPane(teacherTable);
        scrollPane.setPreferredSize(new Dimension(500, 270));


        tchTablePanel.add(scrollPane1, BorderLayout.CENTER);


        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


