
package vista.ventanas;

public class Empleado extends javax.swing.JFrame {

    public Empleado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        panel_btn1 = new componentes.panel_btn();
        panel_btn2 = new componentes.panel_btn();
        panel_btn3 = new componentes.panel_btn();
        Rigth = new javax.swing.JPanel();
        Footer = new javax.swing.JPanel();
        web_label1 = new componentes.web_label();
        web_label2 = new componentes.web_label();
        web_label3 = new componentes.web_label();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        jLabel1.setText("Empleados");
        Header.add(jLabel1);

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setMinimumSize(new java.awt.Dimension(190, 0));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new java.awt.GridLayout(3, 0, 20, 20));
        Left.add(panel_btn1);
        panel_btn1.getAccessibleContext().setAccessibleDescription("");

        Left.add(panel_btn2);
        Left.add(panel_btn3);

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Rigth.setBackground(new java.awt.Color(51, 51, 51));
        Rigth.setLayout(new java.awt.CardLayout());
        getContentPane().add(Rigth, java.awt.BorderLayout.CENTER);

        Footer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 30, 5));
        Footer.add(web_label1);
        Footer.add(web_label2);
        Footer.add(web_label3);

        getContentPane().add(Footer, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private componentes.panel_btn panel_btn1;
    private componentes.panel_btn panel_btn2;
    private componentes.panel_btn panel_btn3;
    private componentes.web_label web_label1;
    private componentes.web_label web_label2;
    private componentes.web_label web_label3;
    // End of variables declaration//GEN-END:variables
}
