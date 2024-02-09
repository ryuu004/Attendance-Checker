package Student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FriendListCellRenderer extends DefaultListCellRenderer {
    private static final Border BORDER = BorderFactory.createLineBorder(Color.BLACK); // Border color

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setBorder(BORDER); // Set border for each cell
        return label;
    }
}
