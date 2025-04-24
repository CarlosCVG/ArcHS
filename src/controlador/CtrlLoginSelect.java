
package controlador;

import vista.ventanas.Login;

public class CtrlLoginSelect {
    private Login login;
    public void openLogin(int seleccion){
        login = new Login(seleccion);
        login.setBounds(250, 25, login.getWidth(), login.getHeight());
        login.setVisible(true);
    }
}
