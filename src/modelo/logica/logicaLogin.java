package modelo.logica;

import java.util.List;
import modelo.dao.daoLogin;

public class logicaLogin {

    daoLogin daologin = new daoLogin();
//    List<Administradores> listalumnos = daov2.getListaAlumnos();

    public void initAdministradores(){
        daologin.initAdministradores();
    }

//    public List<Alumno> getListaAlumnos() {
//        return daov2.getListaAlumnos();
//    }

}
