package componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.*;

public class DateSelector extends JPanel {

    private final JLabel dayLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel yearLabel = new JLabel("", SwingConstants.CENTER);

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

        setDefaultDate();
    }

    private void setDefaultDate() {
        LocalDate today = LocalDate.now();
        dayLabel.setText(String.format("%02d", today.getDayOfMonth()));
        monthLabel.setText(MONTHS[today.getMonthValue() - 1]);
        yearLabel.setText(String.valueOf(today.getYear()));
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Monospace", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(new Color(1, 74, 173));
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
                applyOptionPaneStyle();

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
                                int maxDay = (monthIndex >= 0 && monthIndex < 12) ? DAYS_IN_MONTH[monthIndex] : 31;

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
                            try {
                                int monthNum = Integer.parseInt(newValue);
                                if (monthNum >= 1 && monthNum <= 12) {
                                    label.setText(MONTHS[monthNum - 1]);
                                } else {
                                    showError("Mes inválido. Introduce un número entre 1 y 12 o una abreviación válida (Jan, Feb, ...).");
                                }
                            } catch (NumberFormatException ex) {
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
                                    StringBuilder error = new StringBuilder("Mes inválido. Usa un número del 1 al 12 o abreviaciones como: ");
                                    for (String m : MONTHS) {
                                        error.append(m).append(", ");
                                    }
                                    showError(error.toString());
                                }
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
        applyOptionPaneStyle();
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void applyOptionPaneStyle() {
        Color fondo = new Color(1, 74, 173);
        UIManager.put("OptionPane.background", fondo);
        UIManager.put("Panel.background", fondo);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 13));
        UIManager.put("Button.background", new Color(255, 255, 255));
        UIManager.put("Button.foreground", new Color(1, 74, 173));
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
    }

    private String capitalizeAbbr(String input) {
        if (input.length() < 3) {
            return input;
        }
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

        try {
            int monthNum = Integer.parseInt(monthText);
            if (monthNum >= 1 && monthNum <= 12) {
                return monthNum;
            }
        } catch (NumberFormatException ex) {

            for (int i = 0; i < MONTHS.length; i++) {
                if (MONTHS[i].equals(monthText)) {
                    return i + 1;
                }
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

    public void setDate(LocalDate date) {
        yearLabel.setText(String.valueOf(date.getYear()));
        dayLabel.setText(String.valueOf(date.getDayOfMonth()));
        monthLabel.setText(String.valueOf(date.getMonthValue()));
    }

}
