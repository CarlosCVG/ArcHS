/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.vo.Habitacion;

/**
 *
 * @author edwin
 */
public class PanelHabitacion extends JPanel {

    private static final String IMAGE_FOLDER_PATH = "src/vista/images/habitacionIMG/";
    private static final String IMAGE_PREFIX = "habitacion";

    private Habitacion habitacion;

    public PanelHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        initComponents();
        configurarComponentes();
    }

    private void configurarComponentes() {
        lblIDHabitacion.setText("Habitación #" + habitacion.getId_habitacion() + ".");
        lblPrecio.setText("Precio: " + habitacion.getPrecio() + "$.");
        lblSize.setText("Tamaño: " + habitacion.getTamaño() + "m².");
        lblNumCamas.setText("Numero de camas: " + habitacion.getNum_camas()+ ".");
        lblDescripcion.setText("Descripción:\n" + habitacion.getDescripcion());

        setImageRandom(lblIMG1, 280, 300);
        setImageRandom(lblIMG2, 250, 150);
        setImageRandom(lblIMG3, 250, 150);
    }

    /**
     * Asigna una imagen aleatoria escalada al JLabel recibido.
     */
    private void setImageRandom(JLabel label, int height, int width) {
        int imageCount = countFilesInFolder(IMAGE_FOLDER_PATH);
        if (imageCount == 0) {
            label.setText("Sin imagen");
            return;
        }

        int index = getRandomInt(0, imageCount - 1);
        String imagePath = IMAGE_FOLDER_PATH + IMAGE_PREFIX + index + ".jpg";

        ImageIcon icon = new ImageIcon(imagePath);
        Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaled));
    }

    /**
     * Devuelve un entero aleatorio en el rango [min, max]
     */
    private int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Cuenta la cantidad de archivos en una carpeta.
     */
    private int countFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

        if (files != null) {
            return files.length;
        }

        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelIMG = new javax.swing.JPanel();
        lblIMG1 = new javax.swing.JLabel();
        lblIMG2 = new javax.swing.JLabel();
        lblIMG3 = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        lblIDHabitacion = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblNumCamas = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(1, 74, 173));
        setMinimumSize(new java.awt.Dimension(397, 470));
        setPreferredSize(new java.awt.Dimension(700, 470));
        setLayout(new java.awt.BorderLayout());

        PanelIMG.setBackground(new java.awt.Color(255, 51, 51));
        PanelIMG.setPreferredSize(new java.awt.Dimension(300, 470));
        PanelIMG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIMG1.setBackground(new java.awt.Color(153, 255, 51));
        lblIMG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/habitacionIMG/habitacion0.jpg"))); // NOI18N
        lblIMG1.setOpaque(true);
        PanelIMG.add(lblIMG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 280));

        lblIMG2.setBackground(new java.awt.Color(0, 204, 204));
        lblIMG2.setOpaque(true);
        PanelIMG.add(lblIMG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 250));

        lblIMG3.setBackground(new java.awt.Color(204, 204, 255));
        lblIMG3.setOpaque(true);
        PanelIMG.add(lblIMG3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 150, 250));

        add(PanelIMG, java.awt.BorderLayout.WEST);

        PanelInfo.setBackground(new java.awt.Color(1, 74, 173));
        PanelInfo.setPreferredSize(new java.awt.Dimension(400, 470));
        PanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIDHabitacion.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        lblIDHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblIDHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIDHabitacion.setText("Habitación # ");
        PanelInfo.add(lblIDHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 382, 36));

        lblPrecio.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio.setText("Precio: ");
        PanelInfo.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 382, 23));

        lblSize.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblSize.setForeground(new java.awt.Color(255, 255, 255));
        lblSize.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSize.setText("Tamaño:");
        PanelInfo.add(lblSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 382, 23));

        lblNumCamas.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblNumCamas.setForeground(new java.awt.Color(255, 255, 255));
        lblNumCamas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumCamas.setText("Numero de camas: ");
        PanelInfo.add(lblNumCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 382, 23));

        lblDescripcion.setEditable(false);
        lblDescripcion.setBackground(new java.awt.Color(1, 74, 173));
        lblDescripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblDescripcion.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setFocusable(false);
        PanelInfo.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 382, 220));

        add(PanelInfo, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIMG;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JTextPane lblDescripcion;
    private javax.swing.JLabel lblIDHabitacion;
    private javax.swing.JLabel lblIMG1;
    private javax.swing.JLabel lblIMG2;
    private javax.swing.JLabel lblIMG3;
    private javax.swing.JLabel lblNumCamas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSize;
    // End of variables declaration//GEN-END:variables
}
