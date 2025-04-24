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
        List<Administrador> listaAdmins = getListaAdministradores();
        for (Administrador admin : listaAdmins) {
            if (admin.getUsuario().equals(usuario) && admin.getPass().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public Empleado empleadoLogged(String usuario, String password) {
        List<Empleado> listaEmpleados = getListaEmpleados();
        for (Empleado emp : listaEmpleados) {
            if (emp.getUsuario().equals(usuario) && emp.getPass().equals(password)) {
                return emp;
            }
        }
        return null;
    }

    public Huesped huespedLogged(String usuario, String password) {
        List<Huesped> listaHuespedes = getListaHuespedes();
        for (Huesped h : listaHuespedes) {
            if (h.getUsuario().equals(usuario) && h.getPass().equals(password)) {
                return h;
            }
        }
        return null;
    }

}
