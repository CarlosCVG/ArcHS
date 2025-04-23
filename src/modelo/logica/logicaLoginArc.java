//package modelo.logica;
//
//import excepciones.ExLogicaV2;
//import java.util.List;
//import modelo.dao.DaoV2;
//import modelo.dao.DaoV4;
//import modelo.vo.Alumno;
//import modelo.vo.Prestamo;
//
//public class logicaLoginArc {
//
//    DaoV2 daov2 = new DaoV2();
//    List<Alumno> listalumnos = daov2.getListaAlumnos();
//    DaoV4 daov4 = new DaoV4();
//    List<Prestamo> listprestamos = daov4.getListaPrestamos();
//    int mFound;
//
//    public List<Alumno> getListaAlumnos() {
//        return daov2.getListaAlumnos();
//    }
//
//    public boolean addAlumno(Alumno alumno) throws ExLogicaV2 {
//        if (alumno.getTelefono().length() != 10) {
//            throw new ExLogicaV2("Longitud del numero incorrecta");
//        }
//        for (int i = 0; i <= 9; i++) {
//            if (Character.isLetter(alumno.getTelefono().charAt(i))) {
//                throw new ExLogicaV2("El telefono no puede contener letras");
//            }
//        }
//        switch (alumno.getCarrera()) {
//            case "ISC", "IDI", "INF", "ARQ", "IGE", "ADM", "ICS":
//                break;
//            default:
//                throw new ExLogicaV2("Carrera no registrada en la institucion");
//        }
//        return daov2.addAlumno(alumno);
//    }
//
//    public boolean bajaAlumno(int nocontrol) throws ExLogicaV2 {
//        for (int i = 0; i < listalumnos.size(); i++) {
//            if (listalumnos.get(i).getNumControl() == nocontrol) {
//                if (listalumnos.get(i).getMultas() > 0) {
//                    throw new ExLogicaV2("La multa debe pagarse");
//                } else {
//                    for (int j = 0; j < listprestamos.size(); j++) {
//                        if (listprestamos.get(j).getaNumControl() == nocontrol) {
//                            if (listprestamos.get(j).getStatus().equals("Liberado")) {
//                                return daov2.bajaAlumno(listalumnos.get(i));
//                            } else {
//                                throw new ExLogicaV2("Alumno no ha devuelto un libro");
//                            }
//                        }
//                    }
//                    return daov2.bajaAlumno(listalumnos.get(i));
//                }
//            }
//        }
//        throw new ExLogicaV2("Alumno no encontrado");
//    }
//
//    public List<Alumno> modGetAlumno(int spnnrValue) throws ExLogicaV2 {
//        for (int i = 0; i < listalumnos.size(); i++) {
//            if (listalumnos.get(i).getNumControl() == spnnrValue) {
//                mFound = i;
//                return daov2.getListaAlumnos();
//            }
//        }
//        throw new ExLogicaV2("Alumno no encontrado");
//    }
//
//    public boolean updateRow(Alumno nalumno) throws ExLogicaV2 {
//        if (nalumno.getTelefono().length() != 10) {
//            throw new ExLogicaV2("Longitud del numero incorrecta");
//        }
//        for (int i = 0; i <= 9; i++) {
//            if (Character.isLetter(nalumno.getTelefono().charAt(i))) {
//                throw new ExLogicaV2("El telefono no puede contener letras");
//            }
//        }
//        switch (nalumno.getCarrera()) {
//            case "ISC", "IDI", "INF", "ARQ", "IGE", "ADM", "ICS":
//                break;
//            default:
//                throw new ExLogicaV2("Carrera no registrada en la institucion");
//        }
//        if(nalumno.getEntregasTiempo()<0 || nalumno.getEntregasExtempo()<0 || nalumno.getMultas()<0){
//            throw new ExLogicaV2("Las entregas y la multa no puede ser negativa");
//        }
//        return daov2.updateRow(nalumno);
//    }
//
//    public int pointerUpdate(int pointerU) throws ExLogicaV2 {
//        for (int i = 0; i < listalumnos.size(); i++) {
//            if (listalumnos.get(i).getNumControl() == pointerU) {
//                mFound = i;
//                return mFound;
//            }
//        }
//        throw new ExLogicaV2("Alumno no encontrado");
//    }
//    
//    public int getTotalM(){
//        int totalm = 0;
//        for(int i = 0; i < daov2.getListaAlumnos().size() ;i++){
//            totalm = totalm + daov2.getListaAlumnos().get(i).getMultas();
//        }
//        return totalm;
//    }
//}
