<<<<<<< Updated upstream

package vista.ventanas;

import controlador.CtrlLoginSelect;

public class SelectLogin extends javax.swing.JFrame {
    private CtrlLoginSelect ctrlls = new CtrlLoginSelect();
    private int seleccion;
=======
package vista.ventanas;

import controlador.ControladorSelectLogin;

public class SelectLogin extends javax.swing.JFrame {
    private int seleccion;
    Login login;
    ControladorSelectLogin csl = new ControladorSelectLogin();
>>>>>>> Stashed changes
    public SelectLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< Updated upstream
        btnAdministrador = new componentes.RoundedButton();
        btnEmpleado = new componentes.RoundedButton();
        btnHuesped = new componentes.RoundedButton();
=======
        btnAdmin = new componentes.RoundedButton();
        btnEmpleado = new componentes.RoundedButton();
        btnUsuario = new componentes.RoundedButton();
>>>>>>> Stashed changes
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

<<<<<<< Updated upstream
        btnAdministrador.setText("Adminsitrador");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
=======
        btnAdmin.setText("Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
>>>>>>> Stashed changes
            }
        });

        btnEmpleado.setText("Empleado");
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        btnHuesped.setText("Huesped");
        btnHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuespedActionPerformed(evt);
=======
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
>>>>>>> Stashed changes
            }
        });

        jLabel1.setText("LOGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< Updated upstream
                .addGap(35, 35, 35)
                .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addGap(114, 114, 114)
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Stashed changes
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< Updated upstream
                    .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                    .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> Stashed changes
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< Updated upstream
    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        seleccion = 1;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        seleccion = 2;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuespedActionPerformed
        seleccion = 3;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnHuespedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnAdministrador;
    private componentes.RoundedButton btnEmpleado;
    private componentes.RoundedButton btnHuesped;
=======
    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        seleccion = 1;
        csl.selectLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        seleccion = 2;
        csl.selectLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        seleccion = 3;
        csl.selectLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnAdmin;
    private componentes.RoundedButton btnEmpleado;
    private componentes.RoundedButton btnUsuario;
>>>>>>> Stashed changes
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
