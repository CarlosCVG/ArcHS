package vista.ventanas;

import componentes.panel_btn;
import java.awt.Color;
import modelo.vo.Empleado;
import vista.paneles.PanEmpleadoDatos;
import vista.paneles.PanEmpleadoTask;

public class WinEmpleado extends javax.swing.JFrame {

    private PanEmpleadoDatos info;
    private PanEmpleadoTask tareas;
    private Empleado empleado;
    private String nombrePuesto;

    public WinEmpleado(Empleado empleado, String nombrePuesto) {
        this.empleado = empleado;
        this.nombrePuesto = nombrePuesto;
        this.setUndecorated(true);
        initComponents();
        configurarComponentes(panel_btn1);
        configurarComponentes(panel_btn2);
        info = new PanEmpleadoDatos(empleado, nombrePuesto);
        Rigth.add(info);
    }

    private void configurarComponentes(panel_btn pnl_btn) {
        Color clickedColor = new Color(1, 74, 173);
        Color hoverColor = Color.WHITE;
        Color normalColor = new Color(1, 74, 173);
        Color pressedColor = Color.WHITE;

        pnl_btn.setClickedColor(clickedColor);
        pnl_btn.setHoverColor(hoverColor);
        pnl_btn.setNormalColor(normalColor);
        pnl_btn.setPressedColor(pressedColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        panel_btn1 = new componentes.panel_btn();
        panel_btn2 = new componentes.panel_btn();
        Rigth = new javax.swing.JPanel();
        Footer = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(1, 74, 173));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP1 (1).png"))); // NOI18N
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 580, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 0));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_btn1.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn1.setText("");
        panel_btn1.setUrl("vista/images/Inicio (1).png");
        panel_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_btn1MouseClicked(evt);
            }
        });
        Left.add(panel_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        panel_btn1.getAccessibleContext().setAccessibleDescription("");

        panel_btn2.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn2.setText("");
        panel_btn2.setUrl("vista/images/descargar (48) (1).png");
        panel_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_btn2MouseClicked(evt);
            }
        });
        Left.add(panel_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Rigth.setBackground(new java.awt.Color(1, 74, 173));
        Rigth.setLayout(new java.awt.CardLayout());
        getContentPane().add(Rigth, java.awt.BorderLayout.CENTER);

        Footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Footer, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WinSelectLogin selectlogin = new WinSelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void panel_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_btn1MouseClicked
        info = new PanEmpleadoDatos(empleado, nombrePuesto);
        Rigth.removeAll();
        Rigth.add(info);
        Rigth.revalidate();
        Rigth.repaint();


    }//GEN-LAST:event_panel_btn1MouseClicked

    private void panel_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_btn2MouseClicked
        tareas = new PanEmpleadoTask(empleado, nombrePuesto);
        Rigth.removeAll();
        Rigth.add(tareas);
        Rigth.revalidate();
        Rigth.repaint();
    }//GEN-LAST:event_panel_btn2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private componentes.panel_btn panel_btn1;
    private componentes.panel_btn panel_btn2;
    // End of variables declaration//GEN-END:variables
}
