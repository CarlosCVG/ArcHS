package vista.paneles;

import controlador.CtrlRegistroHab;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import modelo.componentes.mtRegistroHab;
import modelo.vo.Habitacion;
import vista.ventanas.WinRegistroUF;

public class PanRegistro extends javax.swing.JPanel {

    private int habToR;
    private List<Habitacion> habitaciones = new ArrayList<>();
    private mtRegistroHab mtrhLocal;
    CtrlRegistroHab ctrlrh = new CtrlRegistroHab();
    private JFrame ventanaAnterior;

    public PanRegistro(mtRegistroHab mtrh, JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        initComponents();
        tblRegistroFisico.setModel(mtrh);
        ctrlrh.styleTable(tblRegistroFisico);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGnrl = new javax.swing.JPanel();
        pnlTablaHoy = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroFisico = new javax.swing.JTable();
        pnlReservar = new javax.swing.JPanel();
        lblTituloAmarillo = new javax.swing.JLabel();
        btnReservar = new componentes.RoundedButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTituloTabla = new javax.swing.JLabel();
        txtIdHab = new componentes.custom_textfield();

        setLayout(new java.awt.BorderLayout());

        pnlGnrl.setBackground(new java.awt.Color(1, 74, 173));
        pnlGnrl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTablaHoy.setBackground(new java.awt.Color(1, 74, 173));
        pnlTablaHoy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRegistroFisico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistroFisico);

        pnlTablaHoy.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 680, 220));

        pnlGnrl.add(pnlTablaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 740, 250));

        pnlReservar.setBackground(new java.awt.Color(1, 74, 173));
        pnlReservar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloAmarillo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        lblTituloAmarillo.setForeground(new java.awt.Color(255, 255, 0));
        lblTituloAmarillo.setText("Inicia una nueva reservacion (Cualquier Fecha):");
        pnlReservar.add(lblTituloAmarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 40));

        btnReservar.setBackground(new java.awt.Color(1, 74, 173));
        btnReservar.setBorder(null);
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Boton_Reservar_Empleado.png"))); // NOI18N
        btnReservar.setText("");
        btnReservar.setBorderPainted(false);
        btnReservar.setContentAreaFilled(true);
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        pnlReservar.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        pnlReservar.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        pnlReservar.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        pnlReservar.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Icono_usuario_grande.png"))); // NOI18N
        pnlReservar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 120, 110));

        pnlGnrl.add(pnlReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 450, 280));

        lblTituloTabla.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblTituloTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTabla.setText("Habitaciones destacadas para el dia de hoy:");
        pnlGnrl.add(lblTituloTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 40));

        txtIdHab.setForeground(new java.awt.Color(255, 255, 255));
        pnlGnrl.add(txtIdHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 170, -1));

        add(pnlGnrl, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        try {
            mtrhLocal = new mtRegistroHab(1);
            //Aqui esta
            habToR = Integer.parseInt(txtIdHab.getText());
            habitaciones = mtrhLocal.getHabitaciones();
            if (ctrlrh.revisarDisponible(habToR, habitaciones)) {
                ventanaAnterior.setVisible(false);
                WinRegistroUF wruf = new WinRegistroUF(ventanaAnterior, habToR, tblRegistroFisico);
                wruf.setBounds(200, 100, wruf.getWidth(), wruf.getHeight());
                wruf.setVisible(true);
                txtIdHab.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "La habitacion no esta disponible para su reservacion");
                txtIdHab.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero para el Num. Habitacion");
            txtIdHab.setText("");
        }
    }//GEN-LAST:event_btnReservarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnReservar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloAmarillo;
    private javax.swing.JLabel lblTituloTabla;
    private javax.swing.JPanel pnlGnrl;
    private javax.swing.JPanel pnlReservar;
    private javax.swing.JPanel pnlTablaHoy;
    private javax.swing.JTable tblRegistroFisico;
    private componentes.custom_textfield txtIdHab;
    // End of variables declaration//GEN-END:variables
}
