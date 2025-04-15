package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControladorV1 {

    public JLabel lblFormatter(JLabel lbl, String texto, String letra, int letraM, int lsize, Color color){
        lbl = new JLabel(texto);
        lbl.setFont(new Font(letra, letraM, lsize));
        lbl.setForeground(color);
        return lbl;
    }
    
    public void btnFormatter(JButton botonRandom, String bgColor, String bdrColor) {
        botonRandom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonRandom.setOpaque(true);
        botonRandom.setBackground(Color.decode(bgColor));
        botonRandom.setForeground(Color.WHITE);
        botonRandom.setFont(new Font("Arial", Font.BOLD, 14));
        botonRandom.setBorder(BorderFactory.createLineBorder(Color.decode(bdrColor), 4, false));
        Dimension buttonSize = new Dimension(180, 80);
        botonRandom.setPreferredSize(buttonSize);
        botonRandom.setMaximumSize(buttonSize);
        botonRandom.setAlignmentX(JButton.CENTER_ALIGNMENT);
    }
    
    public void incrustVs(JPanel panel, JPanel pnl_inCenter) {
        panel.setSize(720, 480);
        panel.setLocation(0, 0);
        pnl_inCenter.removeAll();
        pnl_inCenter.add(panel, BorderLayout.CENTER);
        pnl_inCenter.revalidate();
        pnl_inCenter.repaint();
    }
}
