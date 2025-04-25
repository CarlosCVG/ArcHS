package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class panel_btn extends JLayeredPane implements MouseListener {

    private JLabel imageLabel;
    private JLabel textLabel;


    // properties
    private Color isNormal = new Color(100, 10, 100); //
    private Color isHover = new Color(10, 10, 10); //
    private Color isClicked = new Color(100, 100, 200); //
    private Color isPressed = new Color(100, 100, 200);
    
    //defaults
    private String url = "vista/images/default.png";
    private String text = "box";

    public panel_btn() {
        int px = 180;
        setPreferredSize(new Dimension(px, px));
        setLayout(null);
        setBackground(isNormal);
        setOpaque(true);
        addMouseListener(this);

        //image setup
        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, px, px);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource(url)));

        //text setup
        textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setFont(this.getFont());
        textLabel.setBounds(0, 0, px, px);
        textLabel.setForeground(Color.BLACK);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);

        //labels
        add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        add(textLabel, JLayeredPane.PALETTE_LAYER);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (textLabel != null) {
            textLabel.setText(text);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        if (imageLabel != null) {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(url));
            Image imagen = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            ImageIcon iconEscalado = new ImageIcon(imagen);
            imageLabel.setIcon(iconEscalado);
        }
    }
    
    public Color getTextForeground(){
        return textLabel.getForeground();
    }
    
    public void setTextForeground(Color color){
        textLabel.setForeground(color);
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

    public void setPressedColor(Color isPressed) {
        this.isPressed = isPressed;
    }

    // MouseListeners
    @Override
    public void mouseClicked(MouseEvent e) {
        setBackground(isClicked);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(isPressed);
    }

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
}
