/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

/**
 *
 * @author edwin
 */

import javax.swing.*;
import java.awt.*;


public class SelectorMes extends JDialog {

    private JTextField mesTextField;
    private JButton aceptarButton;
    private String mesIngresado;

    public SelectorMes(JPanel parent) {
        super((Frame) null, "Seleccione el mes", true);
        this.setUndecorated(true);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(34, 45, 52));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta
        JLabel etiqueta = new JLabel("Seleccione el mes:");
        etiqueta.setForeground(new Color(255, 204, 0));
        etiqueta.setFont(new Font("Monospace", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(etiqueta, gbc);

        // Campo de texto
        mesTextField = new JTextField();
        mesTextField.setFont(new Font("Monospace", Font.PLAIN, 14));
        mesTextField.setBackground(new Color(245, 245, 245));
        mesTextField.setForeground(Color.BLACK);
        mesTextField.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0), 2));
        mesTextField.setCaretColor(Color.BLACK);
        mesTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        gbc.gridy = 1;
        gbc.gridwidth = 2; 
        add(mesTextField, gbc);

        // Habilitar enter para Aceptar
        mesTextField.addActionListener(e -> aceptar());

        // Botón Aceptar
        aceptarButton = new JButton("Aceptar");
        aceptarButton.setFont(new Font("Monospace", Font.BOLD, 14));
        aceptarButton.setBackground(new Color(255, 204, 0));
        aceptarButton.setForeground(Color.BLACK);
        aceptarButton.setFocusPainted(false);
        aceptarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(aceptarButton, gbc);

        // Acción del botón
        aceptarButton.addActionListener(e -> aceptar());
    }

    public void setMes(int mesIngresado){
        mesTextField.setText(String.valueOf(mesIngresado));
    }
    
    private void aceptar() {
        mesIngresado = mesTextField.getText().trim();
        dispose(); // Cierra el diálogo
    }

    public String getMesIngresado() {
        return mesIngresado;
    }
}
