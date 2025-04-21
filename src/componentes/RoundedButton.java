package componentes;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoundedButton extends JButton {

    private Color bgColor = new Color(70, 130, 180);
    private Color fgColor = Color.WHITE;
    private int cornerRadius = 20;

    public RoundedButton() {
        super("boton");
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setForeground(fgColor);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setBackgroundColor(Color bgColor) {
        this.bgColor = bgColor;
        repaint();
    }

    public void setTextColor(Color fgColor) {
        this.fgColor = fgColor;
        setForeground(fgColor);
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
    }
}
