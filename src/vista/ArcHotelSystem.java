package vista;

import vista.ventanas.SelectLogin;

public class ArcHotelSystem {
    public static void main(String[] args) {
        SelectLogin selectlogin = new SelectLogin();
        selectlogin.setBounds(300, 50, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
    }
}
