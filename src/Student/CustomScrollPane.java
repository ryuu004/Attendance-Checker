package Student;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollPane extends JScrollPane {
    public CustomScrollPane(Component view) {
        super(view);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder()); // Remove the border
        getVerticalScrollBar().setUI(new CustomScrollBarUI()); // Customize the vertical scroll bar
        getHorizontalScrollBar().setUI(new CustomScrollBarUI()); // Customize the horizontal scroll bar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE); // Set the background color of the scroll pane
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }

    // Custom UI for the scroll bar
    private static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            // Set colors for thumb, track, and buttons
            thumbColor = new Color(0x2f2678); // Change color as needed
            trackColor = new Color(0xa3a3a3); // Change color as needed
            thumbDarkShadowColor = Color.GREEN; // Change color as needed
            thumbHighlightColor = Color.ORANGE; // Change color as needed
            thumbLightShadowColor = Color.MAGENTA; // Change color as needed
            trackHighlightColor = Color.CYAN; // Change color as needed
        }
    }
}
