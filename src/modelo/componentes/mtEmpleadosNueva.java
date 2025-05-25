package modelo.componentes;

import controlador.CtrlAdmin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mtEmpleadosNueva extends AbstractTableModel {

    private static List<Object[]> empleados = new ArrayList<>();
    CtrlAdmin ctrlad;
    
    private final String[] titulos = {
        "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Email", "Fecha Contratación", "Puesto"
    };

    public mtEmpleadosNueva() {
        ctrlad = new CtrlAdmin();
        empleados = ctrlad.obtenerListaEmpleados();
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int columna) {
        return titulos[columna];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void recargarTabla() {
        empleados = ctrlad.obtenerListaEmpleados();
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] fila = empleados.get(rowIndex);
        return fila[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object[] fila = empleados.get(rowIndex);
        fila[columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            case 5 -> java.sql.Date.class;
            case 1, 2, 3, 4, 6 -> String.class;
            default -> Object.class;
        };
    }
}
