package componentes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        initComponents();
        add(field, BorderLayout.CENTER);
        add(btn, BorderLayout.EAST);
    }

    private void initComponents() {
        field = new JPasswordField();
        btn = new JToggleButton(EYE_CLOSED);

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
