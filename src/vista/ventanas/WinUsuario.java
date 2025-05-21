package vista.ventanas;

import java.awt.Color;
import modelo.vo.Huesped;
import vista.paneles.PanInicioUsuario;
import vista.paneles.PanReservaUsuario;

public class WinUsuario extends javax.swing.JFrame {

    private Huesped huesped;
    private String previousState = "";

    public WinUsuario(Huesped huesped) {
        initComponents();
        this.huesped = huesped;
        setLocationRelativeTo(null);
        mostrarPanel("inicio");
        configurarComponentes();
    }
//xda

    private void configurarComponentes() {
        Color clickedColor = new Color(1, 74, 173);
        Color hoverColor = Color.WHITE;
        Color normalColor = new Color(1, 74, 173);
        Color pressedColor = Color.WHITE;

        btnInicio.setClickedColor(clickedColor);
        btnInicio.setHoverColor(hoverColor);
        btnInicio.setNormalColor(normalColor);
        btnInicio.setPressedColor(pressedColor);

        btnReservacion.setClickedColor(clickedColor);
        btnReservacion.setHoverColor(hoverColor);
        btnReservacion.setNormalColor(normalColor);
        btnReservacion.setPressedColor(pressedColor);

        logo.setClickedColor(normalColor);
        logo.setHoverColor(normalColor);
        logo.setNormalColor(normalColor);
        logo.setPressedColor(normalColor);
    }

    private void mostrarPanel(String state) {
        if (previousState.equals(state)) {
            return;
        }

        Center.removeAll();

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

        Center.revalidate();
        Center.repaint();
        previousState = state;
    }

    private void mostrarReservacion() {
        Center.add(new PanReservaUsuario(huesped));
    }

    private void mostrarInicio() {
        Center.add(new PanInicioUsuario());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuItem1 = new javax.swing.JMenuItem();
        Left = new javax.swing.JPanel();
        btnInicio = new componentes.panel_btn();
        btnReservacion = new componentes.panel_btn();
        logo = new componentes.panel_btn();
        Right = new javax.swing.JPanel();
        Center = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Usuario"); // NOI18N
        setUndecorated(true);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 1800));
        Left.setPreferredSize(new java.awt.Dimension(200, 0));
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
        gridBagConstraints.insets = new java.awt.Insets(100, 10, 10, 10);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Left.add(btnReservacion, gridBagConstraints);

        logo.setBackground(new java.awt.Color(1, 74, 173));
        logo.setText("");
        logo.setUrl("vista/images/logoARChs (1).png");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Left.add(logo, gridBagConstraints);

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Right.setLayout(new java.awt.BorderLayout());

        Center.setBackground(new java.awt.Color(1, 74, 173));
        Center.setMinimumSize(new java.awt.Dimension(760, 580));
        Center.setPreferredSize(new java.awt.Dimension(800, 570));
        Center.setLayout(new java.awt.BorderLayout());
        Right.add(Center, java.awt.BorderLayout.CENTER);

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setPreferredSize(new java.awt.Dimension(800, 130));
        Header.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP2 (1).png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(462, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 150, 0, 0);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 60);
        Header.add(jButton2, gridBagConstraints);

        Right.add(Header, java.awt.BorderLayout.NORTH);

        getContentPane().add(Right, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        mostrarPanel("inicio");
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnReservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionMouseClicked
        mostrarPanel("reservacion");
    }//GEN-LAST:event_btnReservacionMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WinSelectLogin selectlogin = new WinSelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Center;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private componentes.panel_btn btnInicio;
    private componentes.panel_btn btnReservacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private componentes.panel_btn logo;
    // End of variables declaration//GEN-END:variables
}
