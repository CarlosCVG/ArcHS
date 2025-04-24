package vista.ventanas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import modelo.vo.Huesped;
import vista.paneles.Inicio_usuario;

public class Usuario extends javax.swing.JFrame {

    private Huesped huesped;
    private String previousState = "";

    public Usuario(Huesped huesped) {
        initComponents();
        this.huesped = huesped;
        setLocationRelativeTo(null);
        mostrarPanel("inicio");
    }
//xd

    private void mostrarPanel(String state) {
        if (previousState.equals(state)) {
            return;
        }

        Rigth.removeAll();

        switch (state) {
            case "reservacion":
                mostrarReservacion();
                break;
            case "inicio":
                mostrarInicio();
                break;
            default:
                throw new AssertionError("Estado desconocido: " + state);
        }

        Rigth.revalidate();
        Rigth.repaint();
        previousState = state;
    }
    
    private void mostrarReservacion(){
        
    }
    
    private void mostrarInicio(){
        Rigth.add(new Inicio_usuario());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuItem1 = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        btnInicio = new componentes.panel_btn();
        btnReservacion = new componentes.panel_btn();
        panel_btn3 = new componentes.panel_btn();
        Rigth = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Usuario"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 700));

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP2 (1).png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 200, 0, 0);
        Header.add(jLabel1, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 200, 0, 0);
        Header.add(jButton2, gridBagConstraints);

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 1800));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new java.awt.GridBagLayout());

        btnInicio.setBackground(new java.awt.Color(1, 74, 173));
        btnInicio.setText("");
        btnInicio.setUrl("vista/images/Inicio (1).png");
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Left.add(btnInicio, gridBagConstraints);
        btnInicio.getAccessibleContext().setAccessibleDescription("");

        btnReservacion.setBackground(new java.awt.Color(1, 74, 173));
        btnReservacion.setText("");
        btnReservacion.setUrl("vista/images/reservasion.png");
        btnReservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservacionMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Left.add(btnReservacion, gridBagConstraints);

        panel_btn3.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn3.setText("");
        panel_btn3.setUrl("vista/images/logoARChs (1).png");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Left.add(panel_btn3, gridBagConstraints);

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Rigth.setBackground(new java.awt.Color(1, 74, 173));
        Rigth.setMinimumSize(new java.awt.Dimension(760, 580));
        Rigth.setPreferredSize(new java.awt.Dimension(760, 580));
        Rigth.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Rigth, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        JPanel A = new JPanel();
        Rigth.add(A, BorderLayout.CENTER);


    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnReservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionMouseClicked
        JPanel B = new JPanel();
        Rigth.add(B, BorderLayout.CENTER);


    }//GEN-LAST:event_btnReservacionMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private componentes.panel_btn btnInicio;
    private componentes.panel_btn btnReservacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private componentes.panel_btn panel_btn3;
    // End of variables declaration//GEN-END:variables
}
