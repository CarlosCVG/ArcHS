
package vista.paneles;

import modelo.componentes.mtRegistroHab;

public class PanReservado extends javax.swing.JPanel {

    public PanReservado(mtRegistroHab mtrh) {
        initComponents();
        tablaHabDisp.setModel(mtrh);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHabDisp = new javax.swing.JTable();

        setBackground(new java.awt.Color(1, 74, 173));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaHabDisp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaHabDisp);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 590, 290));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHabDisp;
    // End of variables declaration//GEN-END:variables
}
