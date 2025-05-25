package vista.paneles;

import controlador.CtrlAdmin;
import modelo.componentes.mtEmpleadosNueva;
import modelo.vo.Empleado;

public class PanAdminEmpleados extends javax.swing.JPanel {
    
    private String txtToSearch;
    private CtrlAdmin ctrlad = new CtrlAdmin();

    public PanAdminEmpleados(mtEmpleadosNueva mten) {
        initComponents();
        tblEmpleados.setModel(mten);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        roundedButton3 = new componentes.RoundedButton();
        roundedButton5 = new componentes.RoundedButton();
        roundedButton6 = new componentes.RoundedButton();
        txtBusqueda = new componentes.custom_textfield();
        txtID = new javax.swing.JLabel();
        comboNombres = new componentes.VComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setInheritsPopupMenu(true);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(250, 10));
        Left.setPreferredSize(new java.awt.Dimension(250, 10));
        Left.setLayout(new java.awt.GridLayout(1, 3));

        roundedButton3.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton3.setForeground(new java.awt.Color(1, 74, 173));
        roundedButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgNuevo.png"))); // NOI18N
        roundedButton3.setText("");
        roundedButton3.setBorderPainted(false);
        roundedButton3.setContentAreaFilled(true);
        roundedButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton3ActionPerformed(evt);
            }
        });
        Left.add(roundedButton3);

        roundedButton5.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgBaja.png"))); // NOI18N
        roundedButton5.setText("");
        roundedButton5.setBorderPainted(false);
        roundedButton5.setContentAreaFilled(true);
        Left.add(roundedButton5);

        roundedButton6.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton6.setBorder(null);
        roundedButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgModificar.png"))); // NOI18N
        roundedButton6.setText("");
        roundedButton6.setBorderPainted(false);
        roundedButton6.setContentAreaFilled(true);
        roundedButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton6ActionPerformed(evt);
            }
        });
        Left.add(roundedButton6);

        body.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 780, 40));

        txtBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        body.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 220, 30));

        txtID.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 204, 0));
        txtID.setText("Buscar por nombre:");
        body.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 180, 40));

        comboNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNombresActionPerformed(evt);
            }
        });
        body.add(comboNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 350, -1));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmpleados);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 780, 180));

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

    private void roundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedButton3ActionPerformed

    private void roundedButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedButton6ActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        txtToSearch = txtBusqueda.getText();
        comboNombres.removeAllItems();
        for (Empleado empleado : ctrlad.searchLikeNombre(txtToSearch)) {
            comboNombres.addItem(empleado);
        }

    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void comboNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNombresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel body;
    private componentes.VComboBox comboNombres;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.RoundedButton roundedButton3;
    private componentes.RoundedButton roundedButton5;
    private componentes.RoundedButton roundedButton6;
    private javax.swing.JTable tblEmpleados;
    private componentes.custom_textfield txtBusqueda;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables
}
