package Teacher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Main extends JFrame {
    private final Color backgroundColor = new Color(18, 18, 18);
    private final Color overlayColor = new Color(255, 255, 255, 18); // White color with 7% transparency
    private final int elevation = 2; // 2dp elevation

    private JPanel contentPane;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 1180, 756);
        contentPane = new ColorOverlayPanel(); // Use the ColorOverlayPanel here
        contentPane.setBorder(new LineBorder(Color.RED)); // Set a red border
        contentPane.setLayout(null);
        setContentPane(contentPane);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Enable anti-aliasing for smoother graphics
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the background color
                g2d.setColor(backgroundColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Apply elevation effect
                for (int i = 0; i < elevation; i++) {
                    Color shadowColor = new Color(0, 0, 0, 13 * (i + 1)); // Shadow color with increasing transparency
                    g2d.setColor(shadowColor);
                    g2d.fillRoundRect(i, i, getWidth() - 2 * i, getHeight() - 2 * i, 10, 10);
                }

                // Apply color overlay
                g2d.setColor(overlayColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                g2d.dispose();
            }
        };

        // panel.setBorder(new LineBorder(Color.WHITE, 1)); //
        panel.setBounds(10, 11, 1160, 38);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("ENODD TRADING SYSTEM");
        lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
        lblNewLabel.setBounds(21, 11, 213, 14);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Enable anti-aliasing for smoother graphics
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the background color
                g2d.setColor(backgroundColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Apply elevation effect
                for (int i = 0; i < elevation; i++) {
                    Color shadowColor = new Color(0, 0, 0, 13 * (i + 1)); // Shadow color with increasing transparency
                    g2d.setColor(shadowColor);
                    g2d.fillRoundRect(i, i, getWidth() - 2 * i, getHeight() - 2 * i, 10, 10);
                }

                // Apply color overlay
                g2d.setColor(overlayColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Draw a red border
                g2d.setColor(Color.RED);
                g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

                g2d.dispose();
            }
        };

        // Set the thinner yellow border
        panel_1.setBorder(new LineBorder(Color.YELLOW, 1)); // 2 is the thickness

        panel_1.setBounds(10, 60, 1160, 38);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblConfluences = new JLabel("CONFLUENCES");
        lblConfluences.setForeground(Color.WHITE);
        lblConfluences.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));

        // Center the label within panel_1
        int labelWidth = lblConfluences.getPreferredSize().width;
        int panelWidth = panel_1.getWidth();
        int x = (panelWidth - labelWidth) / 2;
        lblConfluences.setBounds(x, 11, labelWidth, 20);

        panel_1.add(lblConfluences);

        // Auto Center
        centerFrame();
    }

    // Auto Center method
    private void centerFrame() {
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int a = (int) ((d.getWidth() - getWidth()) / 2);
        int b = (int) ((d.getHeight() - getHeight()) / 2);
        setLocation(a, b);
    }

    private class ColorOverlayPanel extends JPanel {
        private final Color backgroundColor = new Color(18, 18, 18);
        private final Color overlayColor = new Color(255, 255, 255, 1); // White color with 5% transparency
        private final int elevation = 1; // 1dp elevation

        public ColorOverlayPanel() {
            setPreferredSize(new Dimension(1180, 756));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Enable anti-aliasing for smoother graphics
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the background color
            g2d.setColor(backgroundColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Apply elevation effect
            for (int i = 0; i < elevation; i++) {
                Color shadowColor = new Color(0, 0, 0, 13 * (i + 1)); // Shadow color with increasing transparency
                g2d.setColor(shadowColor);
                g2d.fillRoundRect(i, i, getWidth() - 2 * i, getHeight() - 2 * i, 10, 10);
            }

            // Apply color overlay
            g2d.setColor(overlayColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Draw a red border
            g2d.setColor(Color.RED);
            g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

            g2d.dispose();
        }
    }
}
