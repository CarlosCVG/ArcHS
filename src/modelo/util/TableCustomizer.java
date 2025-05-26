/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.util;

/**
 *
 * @author edwin
 */

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TableCustomizer {

    private static final Color YELLOW = new Color(255, 204, 0);
    private static final Color BLUE = new Color(1, 74, 173);
    private static final Color LIGHT_BLUE_BG = new Color(230, 240, 255);
    private static final Color SELECTION_BG = new Color(255, 234, 120); // amarillo más suave
    private static final Font MONOSPACE_FONT = new Font("Monospaced", Font.PLAIN, 13);

    public static void customizeTable(JTable table) {
        table.setFont(MONOSPACE_FONT);
        table.setRowHeight(24);
        table.setShowGrid(false); // Sin líneas fuertes entre celdas
        table.setIntercellSpacing(new Dimension(0, 1)); // línea sutil entre filas

        table.setForeground(BLUE.darker());
        table.setBackground(LIGHT_BLUE_BG);
        table.setSelectionForeground(BLUE);
        table.setSelectionBackground(SELECTION_BG);

        // Personalizar encabezado
        JTableHeader header = table.getTableHeader();
        header.setFont(MONOSPACE_FONT.deriveFont(Font.BOLD, 14));
        header.setBackground(BLUE);
        header.setForeground(YELLOW);
        header.setOpaque(true);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, YELLOW));

        // Renderizador elegante para celdas
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                c.setFont(MONOSPACE_FONT);
                setHorizontalAlignment(LEFT);
                setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8)); // Padding interno

                if (isSelected) {
                    c.setBackground(SELECTION_BG);
                    c.setForeground(BLUE.darker());
                } else {
                    c.setBackground(LIGHT_BLUE_BG);
                    c.setForeground(BLUE.darker());
                }

                return c;
            }
        };

        // Aplicar el renderizador a todas las columnas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
}
