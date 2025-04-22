package controlador;

import java.util.List;
import modelo.logica.LogicLogin;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;

public class CtrlLogin {

    LogicLogin ll = new LogicLogin();

    public void initAdministradores() {
        ll.initAdministradores();
    }

    public void initEmpleados() {
        ll.initEmpleados();
    }

    public void initHuespedes() {
        ll.initHuespedes();
    }

    public List<Administrador> getListaAdministradores() {
        return ll.getListaAdministradores();
    }

    public List<Empleado> getListaEmpleados() {
        return ll.getListaEmpleados();
    }

    public List<Huesped> getListaHuespedes() {
        return ll.getListaHuespedes();
    }

    public Administrador adminLogged(String usuario, String password) {
        List<Administrador> administradores = getListaAdministradores();
        for (Administrador admin : administradores) {
            if(admin.get){
                
            }
            if (admin.getUsuario().equals(usuario) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public Empleado empleadoLogged(String usuario, String password) {
        getListaEmpleados();
        return 
    }

    public Huesped huespedLogged(String usuario, String password) {
        getListaHuespedes();
        return 
    }
}
