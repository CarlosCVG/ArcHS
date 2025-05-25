package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class VComboBox extends JComboBox<Object> {

    public VComboBox() {
        this.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
        this.setForeground(Color.decode("#FFFFFF"));
        this.setBackground(Color.decode("#014AAD"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 3));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.setFocusable(true);
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setForeground(Color.decode("#000000"));
                setBackground(Color.decode("#023E8A"));
                setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 5));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setForeground(Color.decode("#FFFFFF"));
                setBackground(Color.decode("#014AAD"));
                setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFFF"), 3));
            }
        });

        // Mostrar y ocultar el popup al pasar el mouse
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                requestFocus();
                showPopup();
            }
        });
    }
}
