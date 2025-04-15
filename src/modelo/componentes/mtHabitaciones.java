//package modelo.componentes;
//
//import controlador.ControladorV2;
//import excepciones.ExLogicaV2;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.table.AbstractTableModel;
//import modelo.vo.Habitacion;
//import repositorio.RepAlumnos;
//
//public class mtHabitaciones extends AbstractTableModel {
//
//    private static List<Habitacion> alumnos = new ArrayList<>();
//    ControladorV2 controladorv2;
//    private final String[] titulos = {
//        "NÚM. CONTROL", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO",
//        "CARRERA", "EDAD", "FECHA NACIMIENTO", "CORREO", "TELÉFONO",
//        "ENTREGAS A TIEMPO", "ENTREGAS EXTEMPORÁNEAS", "MULTAS"
//    };
//
//    public mtHabitaciones() {
//        controladorv2 = new ControladorV2();
//        RepAlumnos.cargarDatosInicialesAlumnos();
//        alumnos = controladorv2.getListaAlumnos();
//    }
//
//    @Override
//    public int getRowCount() {
//        return alumnos.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return titulos.length;
//    }
//
//    @Override
//    public String getColumnName(int columna) {
//        return titulos[columna];
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return true;
//    }
//
//    public void addRow(Alumno nalumno) throws ExLogicaV2 {
//        //alumnos.add(nalumno);
//        controladorv2.addAlumno(nalumno);
//        fireTableRowsInserted(1, 1);
//    }
//    
//    public void updateRow(Alumno nalumno) throws ExLogicaV2 {
//        controladorv2.updateRow(nalumno);
//        fireTableRowsInserted(1, 1);
//    }
//
//    public void deletedRow(int idToDelete) throws ExLogicaV2 {
//        controladorv2.bajaAlumno(idToDelete);
//        fireTableRowsDeleted(1, 1);
//    }
//
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        Alumno alumno = alumnos.get(rowIndex);
//        switch (columnIndex) {
//            case 0 ->
//                alumno.setNumControl((int) aValue);
//            case 1 ->
//                alumno.setNombre((String) aValue);
//            case 2 ->
//                alumno.setAp1((String) aValue);
//            case 3 ->
//                alumno.setAp2((String) aValue);
//            case 4 ->
//                alumno.setCarrera((String) aValue);
//            case 5 ->
//                alumno.setEdad((String) aValue);
//            case 6 ->
//                alumno.setFnac((String) aValue);
//            case 7 ->
//                alumno.setCorreo((String) aValue);
//            case 8 ->
//                alumno.setTelefono((String) aValue);
//            case 9 ->
//                alumno.setEntregasTiempo((int) aValue);
//            case 10 ->
//                alumno.setEntregasExtempo((int) aValue);
//            case 11 ->
//                alumno.setMultas((int) aValue);
//        }
//        fireTableCellUpdated(rowIndex, columnIndex);
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Alumno alumno = alumnos.get(rowIndex);
//        switch (columnIndex) {
//            case 0 -> {
//                return alumno.getNumControl();
//            }
//            case 1 -> {
//                return alumno.getNombre();
//            }
//            case 2 -> {
//                return alumno.getAp1();
//            }
//            case 3 -> {
//                return alumno.getAp2();
//            }
//            case 4 -> {
//                return alumno.getCarrera();
//            }
//            case 5 -> {
//                return alumno.getEdad();
//            }
//            case 6 -> {
//                return alumno.getFnac();
//            }
//            case 7 -> {
//                return alumno.getCorreo();
//            }
//            case 8 -> {
//                return alumno.getTelefono();
//            }
//            case 9 -> {
//                return alumno.getEntregasTiempo();
//            }
//            case 10 -> {
//                return alumno.getEntregasExtempo();
//            }
//            case 11 -> {
//                return alumno.getMultas();
//            }
//            default -> {
//                return null;
//            }
//        }
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return switch (columnIndex) {
//            case 0, 1, 2, 3, 4, 6, 7, 8 ->
//                String.class;
//            case 5 ->
//                Integer.class;
//            case 9, 10, 11 ->
//                Integer.class;
//            default ->
//                Object.class;
//        };
//    }
//
//}
