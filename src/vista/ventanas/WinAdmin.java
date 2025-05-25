package vista.ventanas;

import componentes.panel_btn;
import java.awt.Color;
import modelo.componentes.mtEmpleadosNueva;
import modelo.componentes.mtHabReservadas;
import modelo.componentes.mtRegistroHab;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import vista.paneles.PanAdminCE;
import vista.paneles.PanAdminEmpleados;
import vista.paneles.PanAdminTask;
import vista.paneles.PanEmpleadoDatos;
import vista.paneles.PanRegistro;
import vista.paneles.PanReservado;

public class WinAdmin extends javax.swing.JFrame {

    private PanAdminEmpleados adminempleados;
    private PanAdminTask panAT;
    private PanAdminCE panCE;
    private Administrador administrador;
//    private PanAdminTareas adminempleados;
//    private PanAdminCE adminempleados;
    private mtEmpleadosNueva mten = new mtEmpleadosNueva();
    
    public WinAdmin(Administrador administrador) {
        this.setUndecorated(true);
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.administrador = administrador;

        configurarComponentes(btnME);
        configurarComponentes(btnAT);
        configurarComponentes(btnCE);
        adminempleados = new PanAdminEmpleados(mten);
        Rigth.add(adminempleados);
    }

    private void configurarComponentes(panel_btn botonToConfig) {
        Color clickedColor = new Color(1, 74, 173);
        Color hoverColor = Color.WHITE;
        Color normalColor = new Color(1, 74, 173);
        Color pressedColor = Color.WHITE;

        botonToConfig.setClickedColor(clickedColor);
        botonToConfig.setHoverColor(hoverColor);
        botonToConfig.setNormalColor(normalColor);
        botonToConfig.setPressedColor(pressedColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        btnME = new componentes.panel_btn();
        btnAT = new componentes.panel_btn();
        btnCE = new componentes.panel_btn();
        Rigth = new javax.swing.JPanel();
        Footer = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(1, 74, 173));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/ADMIN_TITULO.png"))); // NOI18N
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 890, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        Header.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 0));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new java.awt.GridLayout(3, 0, 20, 20));

        btnME.setBackground(new java.awt.Color(1, 74, 173));
        btnME.setText("");
        btnME.setUrl("vista/images/imgAdmin1.png");
        btnME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMEMouseClicked(evt);
            }
        });
        Left.add(btnME);
        btnME.getAccessibleContext().setAccessibleDescription("");

        btnAT.setBackground(new java.awt.Color(1, 74, 173));
        btnAT.setText("");
        btnAT.setUrl("vista/images/imgAdmin2.png");
        btnAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnATMouseClicked(evt);
            }
        });
        Left.add(btnAT);

        btnCE.setBackground(new java.awt.Color(1, 74, 173));
        btnCE.setText("");
        btnCE.setUrl("vista/images/imgAdmin3.png");
        btnCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCEMouseClicked(evt);
            }
        });
        Left.add(btnCE);

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Rigth.setBackground(new java.awt.Color(1, 74, 173));
        Rigth.setLayout(new java.awt.CardLayout());
        getContentPane().add(Rigth, java.awt.BorderLayout.CENTER);

        Footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Footer, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        WinSelectLogin selectlogin = new WinSelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMEMouseClicked
        adminempleados = new PanAdminEmpleados(mten);
        Rigth.removeAll();
        Rigth.add(adminempleados);
        Rigth.revalidate();
        Rigth.repaint();
    }//GEN-LAST:event_btnMEMouseClicked

    private void btnATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnATMouseClicked
        panAT = new PanAdminTask(administrador);
        Rigth.removeAll();
        Rigth.add(panAT);
        Rigth.revalidate();
        Rigth.repaint();
    }//GEN-LAST:event_btnATMouseClicked

    private void btnCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCEMouseClicked
        
        panCE = new PanAdminCE();
        Rigth.removeAll();
        Rigth.add(panCE);
        Rigth.revalidate();
        Rigth.repaint();
    }//GEN-LAST:event_btnCEMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private componentes.panel_btn btnAT;
    private componentes.panel_btn btnCE;
    private javax.swing.JButton btnClose;
    private componentes.panel_btn btnME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
