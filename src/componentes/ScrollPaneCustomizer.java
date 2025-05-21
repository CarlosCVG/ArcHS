/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

/**
 *
 * @author edwin
 */


import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class ScrollPaneCustomizer {

    public static void customizeScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(null); // Quitar bordes del JScrollPane
        scrollPane.getViewport().setBackground(new Color(1, 74, 173)); // Fondo del contenido
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostrar barra horizontal

        // Personalizar barra vertical
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setUI(new CustomScrollBarUI());
        verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE)); // ancho personalizado
        verticalBar.setUnitIncrement(10); // desplazamiento más rápido

        // Ocultar completamente la barra horizontal (no necesaria ya)
        scrollPane.setHorizontalScrollBar(null);
    }

    private static class CustomScrollBarUI extends BasicScrollBarUI {
        private final Color thumbColor = new Color(255, 204, 0);
        private final Color trackColor = new Color(1, 74, 173);

        @Override
        protected void configureScrollBarColors() {
            thumbHighlightColor = thumbColor;
            thumbDarkShadowColor = thumbColor;
            thumbLightShadowColor = thumbColor;
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(trackColor);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if (!scrollbar.isEnabled()) return;
            g.setColor(thumbColor);
            g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }
}

