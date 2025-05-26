package vista.paneles;

import controlador.CtrlAdmin;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.componentes.mtEmpleadosNueva;
import modelo.vo.Empleado;
import vista.ventanas.WinRegistroEmp;

public class PanAdminEmpleados extends javax.swing.JPanel {

    private String txtToSearch;
    private CtrlAdmin ctrlad = new CtrlAdmin();
    private JFrame ventanaAnterior;

    public PanAdminEmpleados(mtEmpleadosNueva mten, JFrame ventanaAnterior) {
        initComponents();
        tblEmpleados.setModel(mten);
        this.ventanaAnterior = ventanaAnterior;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        btnNuevo = new componentes.RoundedButton();
        btnDelete = new componentes.RoundedButton();
        btnMod = new componentes.RoundedButton();
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

        btnNuevo.setBackground(new java.awt.Color(1, 74, 173));
        btnNuevo.setForeground(new java.awt.Color(1, 74, 173));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgNuevo.png"))); // NOI18N
        btnNuevo.setText("");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(true);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        Left.add(btnNuevo);

        btnDelete.setBackground(new java.awt.Color(1, 74, 173));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgBaja.png"))); // NOI18N
        btnDelete.setText("");
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(true);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        Left.add(btnDelete);

        btnMod.setBackground(new java.awt.Color(1, 74, 173));
        btnMod.setBorder(null);
        btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/imgModificar.png"))); // NOI18N
        btnMod.setText("");
        btnMod.setBorderPainted(false);
        btnMod.setContentAreaFilled(true);
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });
        Left.add(btnMod);

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ventanaAnterior.setVisible(false);
        WinRegistroEmp wremp = new WinRegistroEmp(ventanaAnterior);
        wremp.setBounds(200, 100, wremp.getWidth(), wremp.getHeight());
        wremp.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        Empleado EmpleadoToModify = (Empleado) comboNombres.getSelectedItem();
        if (EmpleadoToModify != null) {
            ventanaAnterior.setVisible(false);
            WinRegistroEmp wremp = new WinRegistroEmp(ventanaAnterior, (Empleado) comboNombres.getSelectedItem(), 2);
            wremp.setBounds(200, 100, wremp.getWidth(), wremp.getHeight());
            wremp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado");
        }

    }//GEN-LAST:event_btnModActionPerformed

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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        Empleado empleadoSelected = (Empleado) comboNombres.getSelectedItem();
        if (empleadoSelected != null) {
            if (ctrlad.deleteEmpleado(empleadoSelected)) {
                JOptionPane.showMessageDialog(null, "Empleado eliminada exitosamente");
                txtToSearch = txtBusqueda.getText();
                comboNombres.removeAllItems();
                for (Empleado empleado : ctrlad.searchLikeNombre(txtToSearch)) {
                    comboNombres.addItem(empleado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ningun empleado fue eliminado");
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel body;
    private componentes.RoundedButton btnDelete;
    private componentes.RoundedButton btnMod;
    private componentes.RoundedButton btnNuevo;
    private componentes.VComboBox comboNombres;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private componentes.custom_textfield txtBusqueda;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables
}
