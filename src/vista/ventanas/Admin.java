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
        up = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        down = new javax.swing.JPanel();
        custom_textfield1 = new componentes.custom_textfield();
        roundedButton1 = new componentes.RoundedButton();
        jPanel6 = new javax.swing.JPanel();
        padding = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setInheritsPopupMenu(true);
        body.setLayout(new java.awt.BorderLayout(20, 20));

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

        body.add(Rigth, java.awt.BorderLayout.CENTER);

        Left.setMinimumSize(new java.awt.Dimension(250, 10));
        Left.setPreferredSize(new java.awt.Dimension(250, 10));
        Left.setLayout(new java.awt.GridLayout(5, 0, 30, 10));
        Left.add(roundedButton2);
        Left.add(roundedButton3);
        Left.add(roundedButton4);
        Left.add(roundedButton5);
        Left.add(roundedButton6);

        body.add(Left, java.awt.BorderLayout.WEST);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        usuarioLabel.setText("Admin");
        header.add(usuarioLabel);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footer.setLayout(new java.awt.BorderLayout());

        up.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 55, 15));

        jLabel2.setText("jLabel2");
        up.add(jLabel2);

        footer.add(up, java.awt.BorderLayout.PAGE_START);

        down.setLayout(new java.awt.BorderLayout(25, 30));

        custom_textfield1.setText("custom_textfield1");
        down.add(custom_textfield1, java.awt.BorderLayout.CENTER);
        down.add(roundedButton1, java.awt.BorderLayout.EAST);

        jPanel6.setMinimumSize(new java.awt.Dimension(30, 10));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 30));
        down.add(jPanel6, java.awt.BorderLayout.WEST);

        footer.add(down, java.awt.BorderLayout.CENTER);

        padding.setMinimumSize(new java.awt.Dimension(30, 30));
        padding.setPreferredSize(new java.awt.Dimension(30, 30));
        footer.add(padding, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel up;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
