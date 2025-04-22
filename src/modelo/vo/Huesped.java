package modelo.vo;

public class Huesped {
    private String usuario;
    private String pass;
    private int id_huesped;
    private String nombre, ap1, ap2, num_tarjeta, idioma, correo;

    public Huesped() {
    }

    public Huesped(String usuario, String pass, int id_huesped, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) {
        this.usuario = usuario;
        this.pass = pass;
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.num_tarjeta = num_tarjeta;
        this.idioma = idioma;
        this.correo = correo;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Huesped{" + "id_huesped=" + id_huesped + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", num_tarjeta=" + num_tarjeta + ", idioma=" + idioma + ", correo=" + correo + '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    

    public String[] toArrayString() {
        String[] strArrHuesped = new String[7];
        strArrHuesped[0] = String.valueOf(this.id_huesped);
        strArrHuesped[1] = this.nombre;
        strArrHuesped[2] = this.ap1;
        strArrHuesped[3] = this.ap2;
        strArrHuesped[4] = this.num_tarjeta;
        strArrHuesped[5] = this.idioma;
        strArrHuesped[6] = this.correo;
        return strArrHuesped;
    }
}
