package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class panel_btn extends JPanel implements MouseListener {

     private JLabel label;
    private Color isNormal = new Color(100, 10, 100);
    private Color isHover = new Color(10, 10, 10);
    private Color isClicked = new Color(100, 100, 200);

    public panel_btn() {
        this("Botón");
    }

    public panel_btn(String text) {
        super();
        label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        setBackground(isNormal);
        add(label, BorderLayout.CENTER);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setBackground(isClicked);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(isHover);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(isHover);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(isNormal);
    }

    public void setIcon(ImageIcon icon) {
        label.setIcon(icon);
        label.setText("");
    }

    public void setText(String text) {
        label.setIcon(null);
        label.setText(text);
    }

    public void setNormalColor(Color color) {
        this.isNormal = color;
        setBackground(isNormal); 
    }

    public void setHoverColor(Color color) {
        this.isHover = color;
    }

    public void setClickedColor(Color color) {
        this.isClicked = color;
    }
    
    public void changeText(String text){
        label.setText(text);
    }
}
