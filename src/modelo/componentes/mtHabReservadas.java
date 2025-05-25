package modelo.componentes;

import controlador.CtrlRegistroHab;
import excepciones.ExRegistroHab;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;
import repositorio.RepHabitaciones;
import repositorio.RepReservaciones;

public class mtHabReservadas extends AbstractTableModel {

    private static List<Object[]> reservaciones = new ArrayList<>();
    CtrlRegistroHab ctrlrh;
    private final String[] titulos = {
        "Reservacion", "Habitacion", "A Nombre De:", "F. Entrada", "F. Salida", "Precio", "No. Camas"
    };

    public mtHabReservadas() {
        ctrlrh = new CtrlRegistroHab();
        reservaciones = ctrlrh.filtrarListaReservaciones();
    }

    @Override
    public int getRowCount() {
        return reservaciones.size();
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
        reservaciones = ctrlrh.filtrarListaReservaciones();
        fireTableDataChanged();
    }

//    public void addRow(Alumno nalumno) throws ExRegistroHab {
//        //alumnos.add(nalumno);
//        controladorv2.addAlumno(nalumno);
//        fireTableRowsInserted(1, 1);
//    }
//    
//    public void updateRow(Alumno nalumno) throws ExRegistroHab {
//        controladorv2.updateRow(nalumno);
//        fireTableRowsInserted(1, 1);
//    }
//
//    public void deletedRow(int idToDelete) throws ExRegistroHab {
//        controladorv2.bajaAlumno(idToDelete);
//        fireTableRowsDeleted(1, 1);
//    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object[] fila = reservaciones.get(rowIndex);
        fila[columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] fila = reservaciones.get(rowIndex);
        return fila[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 1, 6 ->
                Integer.class;
            case 5 ->
                Double.class;
            case 3, 4 ->
                java.sql.Date.class;
            case 2 ->
                String.class;
            default ->
                Object.class;
        };
    }

}
