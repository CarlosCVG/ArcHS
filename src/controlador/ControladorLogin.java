package controlador;

import modelo.logica.logicaLogin;

public class ControladorLogin {
    logicaLogin ll = new logicaLogin();
    public void initAdministradores(){
        ll.initAdministradores();
    }
}
