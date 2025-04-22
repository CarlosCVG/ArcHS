
package vista.ventanas;

public class Fecha extends javax.swing.JFrame {

    public Fecha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        dateSelector2 = new componentes.DateSelector();
        jLabel2 = new javax.swing.JLabel();
        dateSelector3 = new componentes.DateSelector();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        roundedButton1 = new componentes.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        body.setLayout(new java.awt.GridLayout(1, 3, 20, 50));
        body.add(dateSelector2);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        body.add(jLabel2);
        body.add(dateSelector3);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 40));

        jLabel1.setText("jLabel1");
        header.add(jLabel1);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));
        footer.add(roundedButton1);

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.DateSelector dateSelector2;
    private componentes.DateSelector dateSelector3;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private componentes.RoundedButton roundedButton1;
    // End of variables declaration//GEN-END:variables
}
