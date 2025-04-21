package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Modifier;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class custom_textfield extends JTextField implements FocusListener {

    private final MatteBorder focusedBorder = new MatteBorder(0, 0, 1, 0, Color.orange);
    private final MatteBorder unfocusedBorder = new MatteBorder(0, 0, 1, 0, Color.yellow);

    public custom_textfield() {
        super();
        init();
        initListeners();
    }
    

    private void init() {
        setOpaque(false);
        setBorder(unfocusedBorder);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        setForeground(Color.DARK_GRAY);
        setHorizontalAlignment(CENTER);
        setForeground(Color.BLACK);
        
    }

    private void initListeners() {
        addFocusListener(this);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    transferFocus();
                }
            }
        });
    }
    
    

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(focusedBorder);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(unfocusedBorder);
    }
}
