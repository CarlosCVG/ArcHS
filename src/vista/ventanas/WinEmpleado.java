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
        setLocationRelativeTo(null);
        configurarComponentes(btnInicio);
        configurarComponentes(btnTask);
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
        btnClose = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        btnInicio = new componentes.panel_btn();
        btnTask = new componentes.panel_btn();
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

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        Header.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 0));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setBackground(new java.awt.Color(1, 74, 173));
        btnInicio.setText("");
        btnInicio.setUrl("vista/images/Inicio (1).png");
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });
        Left.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        btnInicio.getAccessibleContext().setAccessibleDescription("");

        btnTask.setBackground(new java.awt.Color(1, 74, 173));
        btnTask.setText("");
        btnTask.setUrl("vista/images/descargar (48) (1).png");
        btnTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaskMouseClicked(evt);
            }
        });
        Left.add(btnTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

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

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        info = new PanEmpleadoDatos(empleado, nombrePuesto);
        Rigth.removeAll();
        Rigth.add(info);
        Rigth.revalidate();
        Rigth.repaint();


    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaskMouseClicked
        tareas = new PanEmpleadoTask(empleado, nombrePuesto);
        Rigth.removeAll();
        Rigth.add(tareas);
        Rigth.revalidate();
        Rigth.repaint();
    }//GEN-LAST:event_btnTaskMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JButton btnClose;
    private componentes.panel_btn btnInicio;
    private componentes.panel_btn btnTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
