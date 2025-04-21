package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

public class web_label extends JLabel implements MouseListener{

    private String url;

    public web_label() {
        setText("New Label");
        setHorizontalAlignment(CENTER);
        addMouseListener(this);
        setPreferredSize(new Dimension(100, 50));
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (url == null) {
            JOptionPane.showMessageDialog(labelFor, "error");
        }else if (!url.isEmpty()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace(); 
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBorder(new MatteBorder(0, 0, 2, 0, Color.BLUE));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(getFont().deriveFont(Font.BOLD));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(null);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setFont(getFont().deriveFont(Font.PLAIN));
    }

}
