package vista.paneles;

import controlador.CtrlAdmin;
import modelo.componentes.mtEmpleadosNueva;
import modelo.vo.Empleado;

public class PanAdminCE extends javax.swing.JPanel {
    
    private String txtToSearch;
    private CtrlAdmin ctrlad = new CtrlAdmin();

    public PanAdminCE() {
        initComponents();
        lblResult1.setText(ctrlad.cantRxM(Integer.parseInt((String)comboMeses.getSelectedItem())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblRxMes = new javax.swing.JLabel();
        comboMeses = new componentes.VComboBox();
        lblResult1 = new javax.swing.JLabel();

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setInheritsPopupMenu(true);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Aqui puedes observar las estadisticas del hotel");
        lblTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        body.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 680, 40));

        lblRxMes.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblRxMes.setForeground(new java.awt.Color(255, 255, 255));
        lblRxMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRxMes.setText("Reservaciones asignadas para el mes:");
        body.add(lblRxMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 410, 30));

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        comboMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesesActionPerformed(evt);
            }
        });
        body.add(comboMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 80, -1));

        lblResult1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lblResult1.setForeground(new java.awt.Color(255, 255, 255));
        lblResult1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResult1.setText("...");
        body.add(lblResult1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesesActionPerformed
        lblResult1.setText(ctrlad.cantRxM(Integer.parseInt((String)comboMeses.getSelectedItem())));
    }//GEN-LAST:event_comboMesesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.VComboBox comboMeses;
    private javax.swing.JLabel lblResult1;
    private javax.swing.JLabel lblRxMes;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
