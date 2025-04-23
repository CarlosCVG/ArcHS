package controlador;

import vista.ventanas.Login;
import vista.ventanas.SelectLogin;

public class ControladorSelectLogin {
    private Login login;
    public void selectLogin(int seleccion){
        login = new Login(seleccion);
        login.setVisible(true);
    }
}
