package modelo.vo;

import java.time.LocalDate;

public class Administrador {
    private String usuario;
    private String pass;
    private int id_admin;
    private String nombre;
    private String ap1;
    private String ap2;
    private String correo;
    private String telefono;
    private String rfc;
    private String nss;
    private String curp;
    private LocalDate fnac;
    private String direccion;

    public Administrador(String usuario, String pass, int id_admin, String nombre, String ap1, String ap2, String correo, String telefono, String rfc, String nss, String curp, LocalDate fnac, String direccion) {
        this.usuario = usuario;
        this.pass = pass;
        this.id_admin = id_admin;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.correo = correo;
        this.telefono = telefono;
        this.rfc = rfc;
        this.nss = nss;
        this.curp = curp;
        this.fnac = fnac;
        this.direccion = direccion;
    }
    
    public Administrador(){
    
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public String getNss() {
        return nss;
    }

    public String getCurp() {
        return curp;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_admin=" + id_admin + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", correo=" + correo + ", telefono=" + telefono + ", rfc=" + rfc + ", nss=" + nss + ", curp=" + curp + ", fnac=" + fnac + ", direccion=" + direccion + '}';
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
    
    
    
}
