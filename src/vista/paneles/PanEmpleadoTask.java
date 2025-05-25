package vista.paneles;

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
import modelo.vo.Empleado;
import modelo.vo.Tarea;

public class PanEmpleadoTask extends javax.swing.JPanel {

    private String data;
    private Empleado empleado;
    private String nombrePuesto;
    private CtrlTask ctask = new CtrlTask();
    private String selectedbp;
    private Tarea selectedtsk;

    public PanEmpleadoTask(Empleado empleado, String nombrePuesto) {
        this.empleado = empleado;
        this.nombrePuesto = nombrePuesto;
        initComponents();

        ImageIcon iconReservar = new ImageIcon("src/vista/images/Tareas_titulo.png");
        Image scaledReservar = iconReservar.getImage().getScaledInstance(100, 32, Image.SCALE_SMOOTH);
        lblTituloTareas.setIcon(new ImageIcon(scaledReservar));

        styleTexts(txtTask);
        txtTask.setEditable(false);
        inicioCombos();
    }

    public void inicioCombos() {
        selectedbp = (String) comboBP.getSelectedItem();
        if (selectedbp.equals("buzon")) {
            for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                comboSelectMsj.addItem(tarea);
            }
        } else if (selectedbp.equals("pendiente")) {
            for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                comboSelectMsj.addItem(tarea);
            }
        }
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
        btnSendBuzon = new componentes.RoundedButton();
        lblAsunto = new javax.swing.JLabel();
        lblRemitente = new javax.swing.JLabel();
        comboBP = new componentes.VComboBox();
        comboSelectMsj = new componentes.VComboBox();
        lblAsunto2 = new javax.swing.JLabel();
        lblBandeja = new javax.swing.JLabel();

        pnlFondo.setBackground(new java.awt.Color(1, 74, 173));
        pnlFondo.setForeground(new java.awt.Color(1, 74, 173));
        pnlFondo.setMaximumSize(new java.awt.Dimension(900, 500));
        pnlFondo.setMinimumSize(new java.awt.Dimension(900, 500));
        pnlFondo.setPreferredSize(new java.awt.Dimension(900, 500));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlFondo.add(lblTituloTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 103, 51));

        txtTask.setBackground(new java.awt.Color(1, 74, 173));
        txtTask.setColumns(20);
        txtTask.setForeground(new java.awt.Color(255, 255, 255));
        txtTask.setLineWrap(true);
        txtTask.setRows(5);
        txtTask.setText("Tus tareas se muestran aqui.");
        txtTask.setWrapStyleWord(true);
        txtTask.setMaximumSize(new java.awt.Dimension(232, 84));
        txtTask.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(txtTask);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 295, 680, 170));

        btnSendBuzon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgtareac.png"))); // NOI18N
        btnSendBuzon.setText("");
        btnSendBuzon.setBorderPainted(false);
        btnSendBuzon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendBuzonActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSendBuzon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 250, 50));

        lblAsunto.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblAsunto.setForeground(new java.awt.Color(255, 255, 255));
        lblAsunto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsunto.setText("Asunto del mensaje");
        pnlFondo.add(lblAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 680, 40));

        lblRemitente.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblRemitente.setForeground(new java.awt.Color(255, 255, 255));
        lblRemitente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRemitente.setText("Remitente");
        pnlFondo.add(lblRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 350, 40));

        comboBP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pendiente", "buzon" }));
        comboBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBPActionPerformed(evt);
            }
        });
        pnlFondo.add(comboBP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 220, -1));

        comboSelectMsj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectMsjActionPerformed(evt);
            }
        });
        pnlFondo.add(comboSelectMsj, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 360, -1));

        lblAsunto2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblAsunto2.setForeground(new java.awt.Color(255, 255, 255));
        lblAsunto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsunto2.setText("Registro de tareas:");
        pnlFondo.add(lblAsunto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 220, 40));

        lblBandeja.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblBandeja.setForeground(new java.awt.Color(255, 255, 255));
        lblBandeja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBandeja.setText("Bandeja de tareas:");
        pnlFondo.add(lblBandeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, 40));

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

    private void comboBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBPActionPerformed
        selectedbp = (String) comboBP.getSelectedItem();
        comboSelectMsj.removeAllItems();

        if (selectedbp.equals("buzon")) {
            btnSendBuzon.setEnabled(false);
        } else {
            btnSendBuzon.setEnabled(true);
        }

        if (selectedbp.equals("buzon")) {
            for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                comboSelectMsj.addItem(tarea);
            }
        } else if (selectedbp.equals("pendiente")) {
            for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                comboSelectMsj.addItem(tarea);
            }
        }
    }//GEN-LAST:event_comboBPActionPerformed

    private void comboSelectMsjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectMsjActionPerformed
        selectedtsk = (Tarea) comboSelectMsj.getSelectedItem();
        if (selectedtsk != null) {
            lblRemitente.setText("De: " + ctask.findAdminById(selectedtsk.getId_administrador()));
            lblAsunto.setText(selectedtsk.getAsunto());
            txtTask.setText(selectedtsk.getMensaje());
        } else {
            lblRemitente.setText("Sin remitente");
            lblAsunto.setText("Sin asunto");
            txtTask.setText("No hay ningún mensaje seleccionado");
        }
    }//GEN-LAST:event_comboSelectMsjActionPerformed

    private void btnSendBuzonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendBuzonActionPerformed
        selectedtsk = (Tarea) comboSelectMsj.getSelectedItem();
        if (selectedtsk != null) {
            ctask.updateLectura(selectedtsk);
            if (ctask.updateLectura(selectedtsk)) {
                comboSelectMsj.removeAllItems();
                if (selectedbp.equals("buzon")) {
                    for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                        comboSelectMsj.addItem(tarea);
                    }
                } else if (selectedbp.equals("pendiente")) {
                    for (Tarea tarea : ctask.searchByRegistro(selectedbp, empleado.getId_empleado())) {
                        comboSelectMsj.addItem(tarea);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al marcar la tarea como completada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ningun Mensaje Seleccionado");
        }
    }//GEN-LAST:event_btnSendBuzonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnSendBuzon;
    private componentes.VComboBox comboBP;
    private componentes.VComboBox comboSelectMsj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsunto;
    private javax.swing.JLabel lblAsunto2;
    private javax.swing.JLabel lblBandeja;
    private javax.swing.JLabel lblRemitente;
    private javax.swing.JLabel lblTituloTareas;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextArea txtTask;
    // End of variables declaration//GEN-END:variables
}
