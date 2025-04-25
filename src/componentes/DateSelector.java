package componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class DateSelector extends JPanel {

    private final JLabel dayLabel = new JLabel("01", SwingConstants.CENTER);
    private final JLabel monthLabel = new JLabel("Jan", SwingConstants.CENTER);
    private final JLabel yearLabel = new JLabel("2024", SwingConstants.CENTER);

    //Arreglos de dias y meses, sin considerar años bisiestos
    private static final String[] MONTHS = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private static final int[] DAYS_IN_MONTH = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

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
        label.setFont(new Font("Monospace", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
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

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String newValue = JOptionPane.showInputDialog(
                        DateSelector.this,
                        "Enter " + type + ":",
                        label.getText()
                );
                if (newValue != null && !newValue.trim().isEmpty()) {
                    newValue = newValue.trim();

                    switch (type) {
                        case "day":
                            try {
                                int day = Integer.parseInt(newValue);
                                int monthIndex = getMonth() - 1;
                                int maxDay;

                                if (monthIndex >= 0 && monthIndex < 12) {
                                    maxDay = DAYS_IN_MONTH[monthIndex];
                                } else {
                                    maxDay = 31;
                                }
                                
                                if (day >= 1 && day <= maxDay) {
                                    label.setText(String.format("%02d", day));
                                } else {
                                    showError("El día debe estar entre 1 y " + maxDay + " para " + monthLabel.getText() + ".");
                                }
                            } catch (NumberFormatException ex) {
                                showError("Día inválido. Usa un número entre 1 y 31.");
                            }
                            break;

                        case "month":
                            String monthAbbr = capitalizeAbbr(newValue);
                            boolean validMonth = false;
                            for (String m : MONTHS) {
                                if (m.equals(monthAbbr)) {
                                    validMonth = true;
                                    break;
                                }
                            }

                            if (validMonth) {
                                label.setText(monthAbbr);
                            } else {
                                String error = "Mes invalido. Usa abreviaciones como ";
                                for (int i = 0; i < MONTHS.length; i++) {
                                    error+=  MONTHS[i] + ", ";
                                }
                                
                                showError(error);
                            }
                            break;

                        case "year":
                            try {
                                Integer.parseInt(newValue);
                                label.setText(newValue);
                            } catch (NumberFormatException ex) {
                                showError("Año inválido. Usa solo números.");
                            }
                            break;
                    }
                }
            }
        });

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private String capitalizeAbbr(String input) {
        if (input.length() < 3) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1, 3).toLowerCase();
    }

    public int getDay() {
        try {
            return Integer.parseInt(dayLabel.getText());
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public int getMonth() {
        String monthText = monthLabel.getText();
        for (int i = 0; i < MONTHS.length; i++) {
            if (MONTHS[i].equals(monthText)) {
                return i + 1;
            }
        }
        return 1;
    }

    public int getYear() {
        try {
            return Integer.parseInt(yearLabel.getText());
        } catch (NumberFormatException e) {
            return 2024;
        }
    }

    public String getFormattedDate() {
        return String.format("%02d-%02d-%04d", getDay(), getMonth(), getYear());
    }
}
