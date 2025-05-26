package vista.ventanas;

public class WinAdministrador extends javax.swing.JFrame {
//    private CtrlAdministrador controlador;

    public WinAdministrador() {
        this.setUndecorated(true);
        initComponents();
//        this.controlador = new CtrlAdministrador(this);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Rigth = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDatosEmp = new javax.swing.JTable();
        Left = new javax.swing.JPanel();
        btnVolver = new componentes.RoundedButton();
        btnNewEmpleado = new componentes.RoundedButton();
        btnModifOcupa = new componentes.RoundedButton();
        btnEliminarEmp = new componentes.RoundedButton();
        btnModiEmplea = new componentes.RoundedButton();
        header = new javax.swing.JPanel();
        usuarioLabel = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        down = new javax.swing.JPanel();
        txtBuscaEmple = new componentes.custom_textfield();
        btnBuscar = new componentes.RoundedButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        padding = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setInheritsPopupMenu(true);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rigth.setLayout(new java.awt.BorderLayout());

        tabDatosEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id empleado", "curp", "telefono", "email", "id_puesto", "nombre", "ap1"
            }
        ));
        jScrollPane1.setViewportView(tabDatosEmp);

        Rigth.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        body.add(Rigth, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 9, 590, 440));

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(250, 10));
        Left.setPreferredSize(new java.awt.Dimension(250, 10));
        Left.setLayout(new java.awt.GridLayout(5, 0, 30, 10));

        btnVolver.setBackground(new java.awt.Color(1, 74, 173));
        btnVolver.setBorder(null);
        btnVolver.setForeground(new java.awt.Color(1, 74, 173));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Screenshot 2025-04-23 211513 (1).png"))); // NOI18N
        btnVolver.setText("");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        Left.add(btnVolver);

        btnNewEmpleado.setBackground(new java.awt.Color(1, 74, 173));
        btnNewEmpleado.setForeground(new java.awt.Color(1, 74, 173));
        btnNewEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/nuevo_btn (1).png"))); // NOI18N
        btnNewEmpleado.setText("");
        btnNewEmpleado.setBorderPainted(false);
        btnNewEmpleado.setContentAreaFilled(true);
        btnNewEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEmpleadoActionPerformed(evt);
            }
        });
        Left.add(btnNewEmpleado);

        btnModifOcupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/btn_modificacion.png"))); // NOI18N
        btnModifOcupa.setText("");
        Left.add(btnModifOcupa);

        btnEliminarEmp.setBackground(new java.awt.Color(1, 74, 173));
        btnEliminarEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/btn_Dar_Baja.png"))); // NOI18N
        btnEliminarEmp.setText("");
        btnEliminarEmp.setBorderPainted(false);
        btnEliminarEmp.setContentAreaFilled(true);
        btnEliminarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpActionPerformed(evt);
            }
        });
        Left.add(btnEliminarEmp);

        btnModiEmplea.setBackground(new java.awt.Color(1, 74, 173));
        btnModiEmplea.setBorder(null);
        btnModiEmplea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/btn_modificar_datos.png"))); // NOI18N
        btnModiEmplea.setText("");
        btnModiEmplea.setBorderPainted(false);
        btnModiEmplea.setContentAreaFilled(true);
        btnModiEmplea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiEmpleaActionPerformed(evt);
            }
        });
        Left.add(btnModiEmplea);

        body.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 449));

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/ADMIN_TITULO.png"))); // NOI18N
        header.add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footer.setForeground(new java.awt.Color(1, 74, 173));
        footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        down.setBackground(new java.awt.Color(1, 74, 173));
        down.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        down.add(txtBuscaEmple, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 670, 40));

        btnBuscar.setBackground(new java.awt.Color(1, 74, 173));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flecha.png"))); // NOI18N
        btnBuscar.setText("");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(true);
        down.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, -20, -1, -1));

        jPanel6.setBackground(new java.awt.Color(1, 74, 173));
        jPanel6.setForeground(new java.awt.Color(1, 74, 173));
        jPanel6.setMinimumSize(new java.awt.Dimension(30, 10));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 30));
        down.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("ID:");
        down.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        footer.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        padding.setBackground(new java.awt.Color(1, 74, 173));
        padding.setMinimumSize(new java.awt.Dimension(30, 30));
        padding.setPreferredSize(new java.awt.Dimension(30, 30));
        footer.add(padding, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1060, -1));

        jPanel1.setBackground(new java.awt.Color(1, 74, 173));
        footer.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 130, 40));

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        WinSelectLogin selectlogin = new WinSelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnNewEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEmpleadoActionPerformed
//        WinRegistroEmp re = new WinRegistroEmp();
//        re.setVisible(true);
//        dispose();
    }//GEN-LAST:event_btnNewEmpleadoActionPerformed

    private void btnEliminarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpActionPerformed
        
    }//GEN-LAST:event_btnEliminarEmpActionPerformed

    private void btnModiEmpleaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiEmpleaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModiEmpleaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JPanel body;
    public componentes.RoundedButton btnBuscar;
    public componentes.RoundedButton btnEliminarEmp;
    public componentes.RoundedButton btnModiEmplea;
    public componentes.RoundedButton btnModifOcupa;
    public componentes.RoundedButton btnNewEmpleado;
    public componentes.RoundedButton btnVolver;
    private javax.swing.JPanel down;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel padding;
    public javax.swing.JTable tabDatosEmp;
    public componentes.custom_textfield txtBuscaEmple;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
