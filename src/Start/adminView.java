package Start;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JCalendarBeanInfo;

public class adminView extends JFrame {

    // Variables
    int width = 900;
    int height = 600;
    Font robotoFont = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);
    Font robotoFont1 = loadFont("/resources/font/Roboto-Regular.ttf").deriveFont(Font.BOLD, 14);    
    
    
    private JPanel contentPane;
    private JTextField textField_1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	adminView frame = new adminView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public adminView() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, width, height);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(0x2f2678));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel horiz = new JPanel();
        horiz.setBackground(new Color(0x201a59));
        horiz.setBounds(0, 0, 300, 561);
        contentPane.add(horiz);
        horiz.setLayout(null);
        
        JPanel inboxLin = new JPanel();
        inboxLin.setBounds(10, 132, 280, 60);
        inboxLin.setBackground(new Color(0x2f2678));
        horiz.add(inboxLin);
        inboxLin.setLayout(null);
        
        JLabel inboxTxt = new JLabel("INBOX");
        inboxTxt.setFont(robotoFont.deriveFont(Font.BOLD, 15));
        inboxTxt.setForeground(new Color(255, 255, 255));
        inboxTxt.setHorizontalAlignment(SwingConstants.CENTER);
        inboxTxt.setHorizontalTextPosition(SwingConstants.CENTER);
        inboxTxt.setBounds(0, 0, 280, 60);
        inboxLin.add(inboxTxt);
        
        JPanel logoutIn = new JPanel();
        logoutIn.setBackground(new Color(0x2f2678));
        logoutIn.setBounds(10, 205, 280, 60);
        horiz.add(logoutIn);
        logoutIn.setLayout(null);
        
        JLabel logoutTxt = new JLabel("LOGOUT");
        logoutTxt.setHorizontalAlignment(SwingConstants.CENTER);
        logoutTxt.setFont(robotoFont.deriveFont(Font.BOLD, 15));
        logoutTxt.setForeground(new Color(255, 255, 255));
        logoutTxt.setBounds(0, 0, 280, 60);
        logoutIn.add(logoutTxt);
        
        ///
        

        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.addColumn("NO");
        tableModel1.addColumn("USERNAME");
        tableModel1.addColumn("STUDENT NAME");
        tableModel1.addColumn("STUDENT ID");

        // READ DATAS
        //String url = "https://firebasestorage.googleapis.com/v0/b/enodd-fs01.appspot.com/o/eno.txt?alt=media&token=d2f6cdc7-1e45-4943-8c17-5f4b3a4b39f9";

        //try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            //String line;
            //while ((line = br.readLine()) != null) {
                //String[] data = line.split("\\s{2}");
                //tableModel1.addRow(data);
            //}
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        
        // READ DATAS
        String filePath = "src\\read\\eno.txt";

        // 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 
                //String[] data = line.split("\\s+"); // 
            	String[] data = line.split("\\s{2}");
                
                // 
                tableModel1.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        JTable table = new JTable(tableModel1);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        
        int[] columnWidths = { 50, 90, 160, 140 };
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Center-align the text in all cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(361, 50, 458, 200); 
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);     
        contentPane.add(scrollPane);
        
        
        
   
 
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
