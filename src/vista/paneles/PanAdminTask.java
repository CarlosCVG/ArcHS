package vista.paneles;

import controlador.CtrlAdmin;
import controlador.CtrlTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Tarea;

public class PanAdminTask extends javax.swing.JPanel {

    private CtrlAdmin ctrlad = new CtrlAdmin();
    private String selectedbp, txtToSearch;
    private Tarea selectedtsk;
    private Empleado empleado;
    private String asunto, task;
    private Administrador admin;

    public PanAdminTask(Administrador admin) {
        initComponents();

        ImageIcon iconReservar = new ImageIcon("src/vista/images/Tareas_titulo.png");
        Image scaledReservar = iconReservar.getImage().getScaledInstance(100, 32, Image.SCALE_SMOOTH);
        lblTituloTareas.setIcon(new ImageIcon(scaledReservar));
        this.admin = admin;
        styleTexts(txtTask);
    }

    public void styleTexts(JTextArea tf) {

        //Design
        tf.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        tf.setForeground(Color.decode("#FFFFFF"));
        Border bordeExterno = BorderFactory.createLineBorder(Color.WHITE, 3);
        Border bordeInterno = new EmptyBorder(10, 10, 10, 10);
        tf.setBorder(BorderFactory.createCompoundBorder(bordeExterno, bordeInterno));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblTituloTareas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTask = new javax.swing.JTextArea();
        btnSend = new componentes.RoundedButton();
        lblAsunto = new javax.swing.JLabel();
        lblDestinatario = new javax.swing.JLabel();
        txtBusqueda = new componentes.custom_textfield();
        comboNombres = new componentes.VComboBox();
        txtAsunto = new componentes.custom_textfield();

        pnlFondo.setBackground(new java.awt.Color(1, 74, 173));
        pnlFondo.setForeground(new java.awt.Color(1, 74, 173));
        pnlFondo.setMaximumSize(new java.awt.Dimension(900, 500));
        pnlFondo.setMinimumSize(new java.awt.Dimension(900, 500));
        pnlFondo.setPreferredSize(new java.awt.Dimension(900, 500));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlFondo.add(lblTituloTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 103, 51));

        txtTask.setBackground(new java.awt.Color(1, 74, 173));
        txtTask.setColumns(20);
        txtTask.setForeground(new java.awt.Color(255, 255, 255));
        txtTask.setLineWrap(true);
        txtTask.setRows(5);
        txtTask.setToolTipText("Mensaje a enviar:");
        txtTask.setWrapStyleWord(true);
        txtTask.setMaximumSize(new java.awt.Dimension(232, 84));
        txtTask.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(txtTask);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 295, 680, 170));

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgETad.png"))); // NOI18N
        btnSend.setText("");
        btnSend.setBorderPainted(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 240, 50));

        lblAsunto.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblAsunto.setForeground(new java.awt.Color(255, 255, 255));
        lblAsunto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsunto.setText("Asunto del mensaje");
        lblAsunto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlFondo.add(lblAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 680, 40));

        lblDestinatario.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblDestinatario.setForeground(new java.awt.Color(255, 255, 255));
        lblDestinatario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDestinatario.setText("Elige el destinatario:");
        pnlFondo.add(lblDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 260, 40));

        txtBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        pnlFondo.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 30));

        comboNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNombresActionPerformed(evt);
            }
        });
        pnlFondo.add(comboNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 350, -1));

        txtAsunto.setForeground(new java.awt.Color(255, 255, 255));
        txtAsunto.setToolTipText("Asunto del mensaje:");
        txtAsunto.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtAsunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAsuntoKeyReleased(evt);
            }
        });
        pnlFondo.add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 680, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        if (comboNombres.getSelectedItem() != null) {
            empleado = (Empleado)comboNombres.getSelectedItem();
            asunto = txtAsunto.getText();
            task = txtTask.getText();
            if(ctrlad.sendTask(admin, empleado, asunto, task)){
                JOptionPane.showMessageDialog(null, "Mensaje enviado con exito");
                txtAsunto.setText("");
                txtTask.setText("");
                txtBusqueda.setText("");
            }
        }
//        selectedtsk = (Tarea) comboSelectMsj.getSelectedItem();
//        if (selectedtsk != null) {
//            ctask.updateLectura(selectedtsk);
//            if (ctask.updateLectura(selectedtsk)) {
//                comboSelectMsj.removeAllItems();
//                if (selectedbp.equals("buzon")) {
//                    for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
//                        comboSelectMsj.addItem(tarea);
//                    }
//                } else if (selectedbp.equals("pendiente")) {
//                    for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
//                        comboSelectMsj.addItem(tarea);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Ocurrio un error al marcar la tarea como completada");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Ningun Mensaje Seleccionado");
//        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        txtToSearch = txtBusqueda.getText();
        comboNombres.removeAllItems();
        for (Empleado empleado : ctrlad.searchLikeNombre(txtToSearch)) {
            comboNombres.addItem(empleado);
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void comboNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNombresActionPerformed

    }//GEN-LAST:event_comboNombresActionPerformed

    private void txtAsuntoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsuntoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsuntoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnSend;
    private componentes.VComboBox comboNombres;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsunto;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblTituloTareas;
    private javax.swing.JPanel pnlFondo;
    private componentes.custom_textfield txtAsunto;
    private componentes.custom_textfield txtBusqueda;
    private javax.swing.JTextArea txtTask;
    // End of variables declaration//GEN-END:variables
}
