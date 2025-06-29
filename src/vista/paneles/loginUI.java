/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

/**
 *
 * @author karlo
 */
public class loginUI extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public loginUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        body = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        custom_textfield3 = new componentes.custom_textfield();
        jLabel5 = new javax.swing.JLabel();
        custom_textfield4 = new componentes.custom_textfield();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        roundedButton1 = new componentes.RoundedButton();
        roundedButton2 = new componentes.RoundedButton();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        body.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        body.add(jLabel4, gridBagConstraints);

        custom_textfield3.setText("custom_textfield3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        body.add(custom_textfield3, gridBagConstraints);

        jLabel5.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        body.add(jLabel5, gridBagConstraints);

        custom_textfield4.setText("custom_textfield4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        body.add(custom_textfield4, gridBagConstraints);

        add(body, java.awt.BorderLayout.CENTER);

        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel1.setText("logo");
        header.add(jLabel1);

        add(header, java.awt.BorderLayout.PAGE_START);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 110, 10);
        flowLayout1.setAlignOnBaseline(true);
        footer.setLayout(flowLayout1);
        footer.add(roundedButton1);
        footer.add(roundedButton2);

        add(footer, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.custom_textfield custom_textfield3;
    private componentes.custom_textfield custom_textfield4;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private componentes.RoundedButton roundedButton1;
    private componentes.RoundedButton roundedButton2;
    // End of variables declaration//GEN-END:variables
}
