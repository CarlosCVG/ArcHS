package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JPanel;

/**
 * Custom toggle field with password visibility toggle.
 * @author karlo
 */
public class PasswordField extends JPanel {

    private boolean state = false;

    private static final String EYE_OPEN = "🔓";
    private static final String EYE_CLOSED = "🔒";

    private JPasswordField field;
    private JToggleButton btn;

    public PasswordField() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        initComponents();
        add(field, BorderLayout.CENTER);
        add(btn, BorderLayout.EAST);
    }

    private void initComponents() {
        Color azul = Color.decode("#014AAD");
        Font fuente = new Font("Monospaced", Font.PLAIN, 14);
        field = new JPasswordField();
        field.setFont(fuente);
        field.setForeground(Color.BLACK);
        field.setBackground(Color.WHITE);
        field.setCaretColor(azul);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(azul),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        
        btn = new JToggleButton(EYE_CLOSED);
        btn.setFont(fuente);
        btn.setFocusPainted(false);
        btn.setForeground(azul);
        btn.setBackground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(azul));
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleVisibility();
            }
        });
    }

    private void toggleVisibility() {
        if (state) {
            field.setEchoChar('•');
            btn.setText(EYE_CLOSED);
        } else {
            field.setEchoChar((char) 0);
            btn.setText(EYE_OPEN);
        }
        state = !state;
    }

    public String getText() {
        return new String(field.getPassword());
    }

    public void setText(String text) {
        field.setText(text);
    }

    public JPasswordField getField() {
        return field;
    }

    public void setEditable(boolean editable) {
        field.setEditable(editable);
    }
}
