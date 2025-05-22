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

public class mtRegistroHab extends AbstractTableModel {

    int tmSelector;
    private static List<Habitacion> habitacionesNF = new ArrayList<>();
    private static List<Habitacion> habitaciones = new ArrayList<>();
    private static List<Reservacion> reservaciones = new ArrayList<>();
    CtrlRegistroHab ctrlrh;
    private final String[] titulos = {
        "ID HABITACIÓN", "PRECIO", "TAMAÑO", "NÚM. CAMAS", "DESCRIPCIÓN"
    };

    public mtRegistroHab(int tmSelector) {
        this.tmSelector = tmSelector;
        ctrlrh = new CtrlRegistroHab();
        RepHabitaciones rephabitaciones = new RepHabitaciones();
        RepReservaciones represervaciones = new RepReservaciones();
        reservaciones = ctrlrh.getListaReservaciones();
        habitacionesNF = ctrlrh.getListaHabitaciones();
        habitaciones = ctrlrh.filtrarListaHabitaciones(reservaciones, habitacionesNF, tmSelector);
        //habitaciones = ctrlrh.getListaHabitaciones();
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    @Override
    public int getRowCount() {
        return habitaciones.size();
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
        habitaciones = ctrlrh.filtrarListaHabitaciones(reservaciones, habitacionesNF, tmSelector);
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
        Habitacion hab = habitaciones.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                hab.setId_habitacion((Integer) aValue);
            case 1 ->
                hab.setPrecio((Double) aValue);
            case 2 ->
                hab.setSize((Double) aValue);
            case 3 ->
                hab.setNum_camas((Integer) aValue);
            case 4 ->
                hab.setDescripcion((String) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Habitacion hab = habitaciones.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                hab.getId_habitacion();
            case 1 ->
                hab.getPrecio();
            case 2 ->
                hab.getSize();
            case 3 ->
                hab.getNum_camas();
            case 4 ->
                hab.getDescripcion();
            default ->
                null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 3 ->
                Integer.class;
            case 1, 2 ->
                Double.class;
            case 4 ->
                String.class;
            default ->
                Object.class;
        };
    }

}
