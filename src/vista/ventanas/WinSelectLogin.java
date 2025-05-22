package vista.ventanas;

import controlador.CtrlLoginSelect;

public class WinSelectLogin extends javax.swing.JFrame {

    private CtrlLoginSelect ctrlls = new CtrlLoginSelect();
    private int seleccion;

    public WinSelectLogin() {
        this.setUndecorated(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 74, 173));

        jPanel1.setBackground(new java.awt.Color(1, 74, 173));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/LOGO.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 270, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Como.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 160, 80));

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Administrativo.png"))); // NOI18N
        btnAdmin.setBorder(null);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        btnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Empleado.png"))); // NOI18N
        btnEmpleado.setBorder(null);
        btnEmpleado.setContentAreaFilled(false);
        btnEmpleado.setDefaultCapable(false);
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Usuario.png"))); // NOI18N
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        seleccion = 1;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        seleccion = 2;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        seleccion = 3;
        ctrlls.openLogin(seleccion);
        this.dispose();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
