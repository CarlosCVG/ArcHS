package controlador;

import vista.ventanas.Login;

public class CtrlLoginSelect {
    private Login login;
    public void openLogin(int seleccion){
        login = new Login(seleccion);
        login.setVisible(true);
    }
}
