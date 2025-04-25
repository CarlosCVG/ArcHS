package vista.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import modelo.vo.Empleado;

public class Tareas_Empleados extends javax.swing.JPanel {

    private String data;
    private Empleado empleado;
    private String nombrePuesto;

    public Tareas_Empleados(Empleado empleado, String nombrePuesto) {
        this.empleado = empleado;
        this.nombrePuesto = nombrePuesto;
        initComponents();
        
        ImageIcon iconReservar = new ImageIcon("src/vista/images/Tareas_titulo.png");
        Image scaledReservar = iconReservar.getImage().getScaledInstance(100, 32, Image.SCALE_SMOOTH);
        lblTituloTareas.setIcon(new ImageIcon(scaledReservar));
        
        addData(jTextArea1);
    }

    public void addData(JTextArea tf) {

        //Design
        tf.setFont(new java.awt.Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
        tf.setForeground(Color.decode("#FFFFFF"));
        Border bordeExterno = BorderFactory.createLineBorder(Color.WHITE, 3);
        Border bordeInterno = new EmptyBorder(10, 10, 10, 10);
        tf.setBorder(BorderFactory.createCompoundBorder(bordeExterno, bordeInterno));

        if(nombrePuesto.equals("Camarero")){
            data = "Camarero";
        } else if(nombrePuesto.equals("Limpieza")){
            data = "Limpieza";
        }
        tf.setText(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblTituloTareas = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(1, 74, 173));
        jPanel1.setForeground(new java.awt.Color(1, 74, 173));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jTextArea1.setBackground(new java.awt.Color(1, 74, 173));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea1.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(lblTituloTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTituloTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblTituloTareas;
    // End of variables declaration//GEN-END:variables
}
