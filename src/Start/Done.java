package Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Done extends JFrame {
    private JFrame mainFrame;
    private JFrame registerFrame;

    public Done(JFrame mainFrame, JFrame registerFrame) {
        this.mainFrame = mainFrame;
        this.registerFrame = registerFrame;

        setTitle("Registration Successful");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Registration Successful!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Dispose of the register frame when DoneFrame is closed
                registerFrame.dispose();
                // Make main frame visible
                mainFrame.setVisible(true);
            }
        });
    }
}

