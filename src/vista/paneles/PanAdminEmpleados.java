package vista.paneles;

import controlador.CtrlAdmin;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.componentes.mtEmpleadosNueva;
import modelo.util.ScrollPaneCustomizer;
import modelo.util.TableCustomizer;
import modelo.vo.Empleado;
import vista.ventanas.WinRegistroEmp;

public class PanAdminEmpleados extends javax.swing.JPanel {

    private String txtToSearch;
    private CtrlAdmin ctrlad = new CtrlAdmin();
    private JFrame ventanaAnterior;

    public PanAdminEmpleados(mtEmpleadosNueva mten, JFrame ventanaAnterior) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        tblEmpleados.setModel(mten);
        ScrollPaneCustomizer.customizeScrollPane(jScrollPane1);
        TableCustomizer.customizeTable(tblEmpleados);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        body.setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 530;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 20, 0, 18);
        body.add(Left, gridBagConstraints);

        txtBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 0, 0);
        body.add(txtBusqueda, gridBagConstraints);

        txtID.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 204, 0));
        txtID.setText("Buscar por nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 30, 147, 0);
        body.add(txtID, gridBagConstraints);

        comboNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNombresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 278;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 20, 0, 18);
        body.add(comboNombres, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 18);
        body.add(jScrollPane1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ventanaAnterior.setVisible(false);
        WinRegistroEmp wremp = new WinRegistroEmp(ventanaAnterior);
        wremp.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        Empleado EmpleadoToModify = (Empleado) comboNombres.getSelectedItem();
        if (EmpleadoToModify != null) {
            ventanaAnterior.setVisible(false);
            WinRegistroEmp wremp = new WinRegistroEmp(ventanaAnterior, (Empleado) comboNombres.getSelectedItem(), 2);
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
