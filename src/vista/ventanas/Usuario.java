
package vista.ventanas;

import componentes.Panel_Inicio_Usuario;
import componentes.Panel_Reservacion_Carrucel_Usuario;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Usuario extends javax.swing.JFrame {

    public Usuario() {
        initComponents();
    }
//xd
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        panel_btn1 = new componentes.panel_btn();
        panel_btn2 = new componentes.panel_btn();
        panel_btn3 = new componentes.panel_btn();
        Rigth = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP2 (1).png"))); // NOI18N
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 470, 120));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TAP3 (1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        Header.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        Header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        Left.setBackground(new java.awt.Color(1, 74, 173));
        Left.setMinimumSize(new java.awt.Dimension(190, 0));
        Left.setPreferredSize(new java.awt.Dimension(190, 0));
        Left.setRequestFocusEnabled(false);
        Left.setLayout(new java.awt.GridLayout(3, 0, 20, 20));

        panel_btn1.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn1.setText("");
        panel_btn1.setUrl("vista/images/Inicio (1).png");
        panel_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_btn1MouseClicked(evt);
            }
        });
        Left.add(panel_btn1);
        panel_btn1.getAccessibleContext().setAccessibleDescription("");

        panel_btn2.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn2.setText("");
        panel_btn2.setUrl("vista/images/reservasion.png");
        panel_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_btn2MouseClicked(evt);
            }
        });
        Left.add(panel_btn2);

        panel_btn3.setBackground(new java.awt.Color(1, 74, 173));
        panel_btn3.setText("");
        panel_btn3.setUrl("vista/images/logoARChs (1).png");
        Left.add(panel_btn3);

        getContentPane().add(Left, java.awt.BorderLayout.WEST);

        Rigth.setBackground(new java.awt.Color(1, 74, 173));
        Rigth.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Rigth, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_btn1MouseClicked
        JPanel A = new JPanel();
        Rigth.add(A,BorderLayout.CENTER);
        
        Panel_Inicio_Usuario Inicio= new Panel_Inicio_Usuario();
    }//GEN-LAST:event_panel_btn1MouseClicked

    private void panel_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_btn2MouseClicked
      JPanel B = new JPanel();
        Rigth.add(B,BorderLayout.CENTER);
        
        Panel_Reservacion_Carrucel_Usuario Inicio= new Panel_Reservacion_Carrucel_Usuario();
        
    }//GEN-LAST:event_panel_btn2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Rigth;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private componentes.panel_btn panel_btn1;
    private componentes.panel_btn panel_btn2;
    private componentes.panel_btn panel_btn3;
    // End of variables declaration//GEN-END:variables
}
