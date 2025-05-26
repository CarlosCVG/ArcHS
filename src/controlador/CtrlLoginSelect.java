
package controlador;

import vista.ventanas.WinLogin;

public class CtrlLoginSelect {
    private WinLogin login;
    public void openLogin(int seleccion){
        login = new WinLogin(seleccion);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
