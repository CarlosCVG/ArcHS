package vista.paneles;

import controlador.CtrlRegistroHab;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.componentes.mtRegistroHab;
import modelo.vo.Habitacion;

public class PanRegistro extends javax.swing.JPanel {

    private int habToR;
    private List<Habitacion> habitaciones = new ArrayList<>();
    private mtRegistroHab mtrhLocal;
    CtrlRegistroHab ctrlrh = new CtrlRegistroHab();

    public PanRegistro(mtRegistroHab mtrh) {
        initComponents();
        tblRegistroFisico.setModel(mtrh);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroFisico = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdHab = new componentes.custom_textfield();
        btnReservar = new componentes.RoundedButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(1, 74, 173));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 74, 173));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 490, 260));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 529, 375));

        jPanel2.setBackground(new java.awt.Color(1, 74, 173));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Num. Habitacion:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, 20));

        txtIdHab.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtIdHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, -1));

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
        jPanel2.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Icono_usuario_grande.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 120, 110));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 0, 270, 400));

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        try {
            mtrhLocal = new mtRegistroHab(1);
            habToR = Integer.parseInt(txtIdHab.getText());
            habitaciones = mtrhLocal.getHabitaciones();
            if (ctrlrh.revisarDisponible(habToR, habitaciones)){
                
            } else {
                JOptionPane.showMessageDialog(null, "La habitacion no esta disponible para su reservacion");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero para el Num. Habitacion");
        }
    }//GEN-LAST:event_btnReservarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnReservar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistroFisico;
    private componentes.custom_textfield txtIdHab;
    // End of variables declaration//GEN-END:variables
}
