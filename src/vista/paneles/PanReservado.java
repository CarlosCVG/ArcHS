package vista.paneles;

import controlador.CtrlRegistroHab;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import modelo.componentes.mtHabReservadas;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

public class PanReservado extends javax.swing.JPanel {

    CtrlRegistroHab ctrlrh = new CtrlRegistroHab();
    Huesped hincombo;
    String txtToSearch;

    public PanReservado(mtHabReservadas mtrh) {
        initComponents();
        tblReservaciones.setModel(mtrh);
        ctrlrh.styleTableReservaciones(tblReservaciones);

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Reservacion r) {
                    setText("ID: " + r.getId_reservacion()); // Puedes mostrar nombre, fechas, etc.
                }
                return this;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservaciones = new javax.swing.JTable();
        lblTituloEliminar = new javax.swing.JLabel();
        lblTituloTabla1 = new javax.swing.JLabel();
        txtBusqueda = new componentes.custom_textfield();
        lblFechaEntrada = new javax.swing.JLabel();
        lblResultFE = new componentes.custom_textfield();
        lblNombre = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        lblResultFS = new componentes.custom_textfield();
        roundedButton1 = new componentes.RoundedButton();
        combo = new componentes.VComboBox();
        lblSelectReservaID = new javax.swing.JLabel();
        lblNombreEncontrado = new javax.swing.JLabel();
        txtNombreEncontrado = new componentes.custom_textfield();

        setBackground(new java.awt.Color(1, 74, 173));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblReservaciones);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 730, 200));

        lblTituloEliminar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblTituloEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloEliminar.setText("Eliminar reservaciones");
        add(lblTituloEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 770, 40));

        lblTituloTabla1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblTituloTabla1.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTabla1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTabla1.setText("Habitaciones reservadas en alguna fecha");
        add(lblTituloTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 40));

        txtBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 230, -1));

        lblFechaEntrada.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblFechaEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaEntrada.setText("Fecha de entrada:");
        add(lblFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 190, 30));

        lblResultFE.setForeground(new java.awt.Color(255, 255, 255));
        lblResultFE.setEnabled(false);
        lblResultFE.setFocusable(false);
        lblResultFE.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblResultFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblResultFEActionPerformed(evt);
            }
        });
        lblResultFE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblResultFEKeyReleased(evt);
            }
        });
        add(lblResultFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 230, -1));

        lblNombre.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Con Nombre:");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 150, 30));

        lblFechaSalida.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblFechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaSalida.setText("Fecha de salida:");
        add(lblFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 190, 30));

        lblResultFS.setForeground(new java.awt.Color(255, 255, 255));
        lblResultFS.setEnabled(false);
        lblResultFS.setFocusable(false);
        lblResultFS.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblResultFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblResultFSActionPerformed(evt);
            }
        });
        lblResultFS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblResultFSKeyReleased(evt);
            }
        });
        add(lblResultFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 230, -1));

        roundedButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgERjva.png"))); // NOI18N
        roundedButton1.setText("");
        roundedButton1.setBorderPainted(false);
        roundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton1ActionPerformed(evt);
            }
        });
        add(roundedButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 500, 230, 50));

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 240, -1));

        lblSelectReservaID.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblSelectReservaID.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectReservaID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectReservaID.setText("Reservacion:");
        add(lblSelectReservaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 150, 30));

        lblNombreEncontrado.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblNombreEncontrado.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEncontrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreEncontrado.setText("Nombre Encontrado:");
        add(lblNombreEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 250, 30));

        txtNombreEncontrado.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreEncontrado.setEnabled(false);
        txtNombreEncontrado.setFocusable(false);
        txtNombreEncontrado.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtNombreEncontrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEncontradoActionPerformed(evt);
            }
        });
        txtNombreEncontrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEncontradoKeyReleased(evt);
            }
        });
        add(txtNombreEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        txtToSearch = txtBusqueda.getText();
        combo.removeAllItems();
        for (Reservacion reservacion : ctrlrh.searchLikeReservacion(txtToSearch)) {
            combo.addItem(reservacion);
        }

        Reservacion rselected = (Reservacion) combo.getSelectedItem();
        if (rselected != null) {
            hincombo = ctrlrh.getClienteByIdReservacion(rselected.getId_reservacion());
            txtNombreEncontrado.setText(hincombo.getNombre() + " " + hincombo.getAp1() + " " + hincombo.getAp2());
            lblResultFE.setText(rselected.getF_entrada().toString());
            lblResultFS.setText(rselected.getF_salida().toString());
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void lblResultFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblResultFEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblResultFEActionPerformed

    private void lblResultFEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblResultFEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblResultFEKeyReleased

    private void lblResultFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblResultFSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblResultFSActionPerformed

    private void lblResultFSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblResultFSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblResultFSKeyReleased

    private void txtNombreEncontradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEncontradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEncontradoActionPerformed

    private void txtNombreEncontradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEncontradoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEncontradoKeyReleased

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        Reservacion rselected = (Reservacion) combo.getSelectedItem();
        if (rselected != null) {
            hincombo = ctrlrh.getClienteByIdReservacion(rselected.getId_reservacion());
            txtNombreEncontrado.setText(hincombo.getNombre() + " " + hincombo.getAp1() + " " + hincombo.getAp2());
            lblResultFE.setText(rselected.getF_entrada().toString());
            lblResultFS.setText(rselected.getF_salida().toString());
        }
    }//GEN-LAST:event_comboActionPerformed

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed
        Reservacion rselected = (Reservacion) combo.getSelectedItem();
        if (rselected != null) {
            if (ctrlrh.deleteReservation(rselected)) {
                JOptionPane.showMessageDialog(null, "Reservacion eliminada exitosamente");
                txtToSearch = txtBusqueda.getText();
                combo.removeAllItems();
                for (Reservacion reservacion : ctrlrh.searchLikeReservacion(txtToSearch)) {
                    combo.addItem(reservacion);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ninguna reservacion fue eliminada");
            }

        }
    }//GEN-LAST:event_roundedButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.VComboBox combo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaEntrada;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEncontrado;
    private componentes.custom_textfield lblResultFE;
    private componentes.custom_textfield lblResultFS;
    private javax.swing.JLabel lblSelectReservaID;
    private javax.swing.JLabel lblTituloEliminar;
    private javax.swing.JLabel lblTituloTabla1;
    private componentes.RoundedButton roundedButton1;
    private javax.swing.JTable tblReservaciones;
    private componentes.custom_textfield txtBusqueda;
    private componentes.custom_textfield txtNombreEncontrado;
    // End of variables declaration//GEN-END:variables
}
