package modelo.vo;

import java.time.LocalDate;

public class Empleado {
    private String usuario;
    private String pass;
    private int id_empleado;
    private int id_admin;
    private int nss;
    private String curp;
    private String telefono;
    private String email;
    private String rfc;
    private int id_puesto;
    private String sueldo;
    private LocalDate fecha_nac;
    private String direccion;
    private LocalDate fecha_contrat;
    private String nombre;
    private String ap1;
    private String ap2;

    public Empleado(String usuario, String pass, int id_empleado, int id_admin, int nss, String curp, String telefono, String email, String rfc, int id_puesto, String sueldo, LocalDate fecha_nac, String direccion, LocalDate fecha_contrat, String nombre, String ap1, String ap2) {
        this.id_empleado = id_empleado;
        this.id_admin = id_admin;
        this.nss = nss;
        this.curp = curp;
        this.telefono = telefono;
        this.email = email;
        this.rfc = rfc;
        this.id_puesto = id_puesto;
        this.sueldo = sueldo;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.fecha_contrat = fecha_contrat;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
    }

    public Empleado(){
    
    }
    
    public int getId_empleado() {
        return id_empleado;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getNss() {
        return nss;
    }

    public String getCurp() {
        return curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getRfc() {
        return rfc;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public String getSueldo() {
        return sueldo;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFecha_contrat() {
        return fecha_contrat;
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

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha_contrat(LocalDate fecha_contrat) {
        this.fecha_contrat = fecha_contrat;
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

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", id_admin=" + id_admin + ", nss=" + nss + ", curp=" + curp + ", telefono=" + telefono + ", email=" + email + ", rfc=" + rfc + ", id_puesto=" + id_puesto + ", sueldo=" + sueldo + ", fecha_nac=" + fecha_nac + ", direccion=" + direccion + ", fecha_contrat=" + fecha_contrat + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + '}';
    }
    
    
    
}
