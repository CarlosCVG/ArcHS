package componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class DateSelector extends JPanel {

    private final JLabel dayLabel = new JLabel("01", SwingConstants.CENTER);
    private final JLabel monthLabel = new JLabel("Jan", SwingConstants.CENTER);
    private final JLabel yearLabel = new JLabel("2024", SwingConstants.CENTER);

    public DateSelector() {
        setLayout(new GridLayout(2, 3, 10, 5));
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        add(createHeaderLabel("DD"));
        add(createHeaderLabel("MM"));
        add(createHeaderLabel("YY"));

        add(wrapInteractiveLabel(dayLabel, "day"));
        add(wrapInteractiveLabel(monthLabel, "month"));
        add(wrapInteractiveLabel(yearLabel, "year"));
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(Color.DARK_GRAY);
        return label;
    }

    private JPanel wrapInteractiveLabel(JLabel label, String type) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Dummy popup simulation
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newValue = JOptionPane.showInputDialog(
                    DateSelector.this,
                    "Enter " + type + ":",
                    label.getText()
                );
                if (newValue != null && !newValue.trim().isEmpty()) {
                    label.setText(newValue);
                }
            }
        });

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Accessor Methods
    public String getDay() {
        return dayLabel.getText();
    }

    public String getMonth() {
        return monthLabel.getText();
    }

    public String getYear() {
        return yearLabel.getText();
    }

    public String getFormattedDate() {
        return String.format("%s-%s-%s", getDay(), getMonth(), getYear());
    }
}
