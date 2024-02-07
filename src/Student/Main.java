package Student;
import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Page");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setBackground(Color.LIGHT_GRAY);
        middlePanel.setBackground(Color.WHITE);
        rightPanel.setBackground(Color.LIGHT_GRAY);

        middlePanel.setPreferredSize(new Dimension(600, 300));
        rightPanel.setPreferredSize(new Dimension(200, 300));
        leftPanel.setPreferredSize(new Dimension(200, 300));


        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add panels to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        // Add main panel to the frame
        frame.getContentPane().add(mainPanel);


        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
