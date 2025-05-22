
package controlador;

import vista.ventanas.WinLogin;

public class CtrlLoginSelect {
    private WinLogin login;
    public void openLogin(int seleccion){
        login = new WinLogin(seleccion);
        login.setBounds(250, 25, login.getWidth(), login.getHeight());
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
