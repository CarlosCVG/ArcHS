package vista.ventanas;

public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Rigth = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Left = new javax.swing.JPanel();
        roundedButton2 = new componentes.RoundedButton();
        roundedButton3 = new componentes.RoundedButton();
        roundedButton4 = new componentes.RoundedButton();
        roundedButton5 = new componentes.RoundedButton();
        roundedButton6 = new componentes.RoundedButton();
        header = new javax.swing.JPanel();
        usuarioLabel = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        down = new javax.swing.JPanel();
        custom_textfield1 = new componentes.custom_textfield();
        roundedButton1 = new componentes.RoundedButton();
        jPanel6 = new javax.swing.JPanel();
        padding = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setInheritsPopupMenu(true);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rigth.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        Rigth.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        body.add(Rigth, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 9, 590, 440));

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(250, 10));
        Left.setPreferredSize(new java.awt.Dimension(250, 10));
        Left.setLayout(new java.awt.GridLayout(5, 0, 30, 10));

        roundedButton2.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton2.setBorder(null);
        roundedButton2.setForeground(new java.awt.Color(1, 74, 173));
        roundedButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Screenshot 2025-04-23 211513 (1).png"))); // NOI18N
        roundedButton2.setText("");
        roundedButton2.setBorderPainted(false);
        roundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton2ActionPerformed(evt);
            }
        });
        Left.add(roundedButton2);

        roundedButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/nuevo_btn (1).png"))); // NOI18N
        roundedButton3.setText("");
        roundedButton3.setBorderPainted(false);
        roundedButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton3ActionPerformed(evt);
            }
        });
        Left.add(roundedButton3);
        Left.add(roundedButton4);
        Left.add(roundedButton5);
        Left.add(roundedButton6);

        body.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 449));

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/ADMIN_TITULO.png"))); // NOI18N
        header.add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footer.setForeground(new java.awt.Color(1, 74, 173));
        footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        down.setBackground(new java.awt.Color(1, 74, 173));
        down.setLayout(new java.awt.BorderLayout(25, 30));
        down.add(custom_textfield1, java.awt.BorderLayout.CENTER);
        down.add(roundedButton1, java.awt.BorderLayout.EAST);

        jPanel6.setBackground(new java.awt.Color(1, 74, 173));
        jPanel6.setForeground(new java.awt.Color(1, 74, 173));
        jPanel6.setMinimumSize(new java.awt.Dimension(30, 10));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 30));
        down.add(jPanel6, java.awt.BorderLayout.WEST);

        footer.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        padding.setBackground(new java.awt.Color(1, 74, 173));
        padding.setMinimumSize(new java.awt.Dimension(30, 30));
        padding.setPreferredSize(new java.awt.Dimension(30, 30));
        footer.add(padding, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1060, -1));

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedButton2ActionPerformed

    private void roundedButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JPanel body;
    private componentes.custom_textfield custom_textfield1;
    private javax.swing.JPanel down;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel padding;
    private componentes.RoundedButton roundedButton1;
    private componentes.RoundedButton roundedButton2;
    private componentes.RoundedButton roundedButton3;
    private componentes.RoundedButton roundedButton4;
    private componentes.RoundedButton roundedButton5;
    private componentes.RoundedButton roundedButton6;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
