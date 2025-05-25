package vista.paneles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import modelo.vo.Empleado;
import modelo.vo.Puesto;

public class PanEmpleadoDatos extends javax.swing.JPanel {

    private String ContentTxtArea, ContentLblName, ContentLblAdvice;
    private Empleado empleado;
    private String nombrePuesto;

    public PanEmpleadoDatos(Empleado empleado, String nombrePuesto) {
        this.empleado = empleado;
        this.nombrePuesto = nombrePuesto;
        initComponents();
        addData(txtDatosGen);
        addInfoAndAdvice(lblEmpName, lblAdvice);
    }

    public void addData(JTextArea tf) {

        //Design
        tf.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        tf.setForeground(Color.decode("#FFFFFF"));
        Border bordeExterno = BorderFactory.createLineBorder(Color.WHITE, 3);
        Border bordeInterno = new EmptyBorder(10, 10, 10, 10);
        tf.setBorder(BorderFactory.createCompoundBorder(bordeExterno, bordeInterno));

        //ContentTxtArea = "Bienvenido/a " + empleado.getNombre() + " " + empleado.getAp1() + " " + empleado.getAp2();
        //ContentTxtArea = ContentTxtArea + "\n\n" + "Revisa tus datos. Si algun dato es incorrecto comunicalo con\nel Administrador del sistema.";
        ContentTxtArea =                            "Curp:              " + empleado.getCurp();
        ContentTxtArea = ContentTxtArea + "\n" +    "Email:             " + empleado.getEmail();
        ContentTxtArea = ContentTxtArea + "\n" +    "Telefono:          " + empleado.getTelefono();
        ContentTxtArea = ContentTxtArea + "\n\n" +  "Tu puesto es:      " + nombrePuesto;

        tf.setText(ContentTxtArea);
    }

    public void addInfoAndAdvice(JLabel lblEmpName, JLabel lblAdvice) {
        ContentLblName = "<html>Bienvenido/a<br>"
                + empleado.getNombre() + " " + empleado.getAp1() + " " + empleado.getAp2() + "</html>";
        lblEmpName.setText(ContentLblName);

        ContentLblAdvice = "<html>Revisa tus datos. Si algún dato es incorrecto comunícalo"
                + "<br>con el Administrador del sistema.</html>";
        lblAdvice.setText(ContentLblAdvice);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatosGen = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblEmpName = new javax.swing.JLabel();
        lblAdvice = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(1, 74, 173));
        jPanel1.setForeground(new java.awt.Color(1, 74, 173));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        txtDatosGen.setEditable(false);
        txtDatosGen.setBackground(new java.awt.Color(1, 74, 173));
        txtDatosGen.setColumns(20);
        txtDatosGen.setRows(5);
        txtDatosGen.setMaximumSize(new java.awt.Dimension(232, 84));
        txtDatosGen.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(txtDatosGen);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Datos_Titulo.png"))); // NOI18N

        lblEmpName.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        lblEmpName.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblAdvice.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblAdvice.setForeground(new java.awt.Color(255, 255, 255));
        lblAdvice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdvice, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(264, 264, 264)
                                    .addComponent(jLabel1))))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdvice;
    private javax.swing.JLabel lblEmpName;
    private javax.swing.JTextArea txtDatosGen;
    // End of variables declaration//GEN-END:variables
}
