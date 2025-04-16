package modelo.vo;

public class Puesto {
    private int id_puesto;
    private int id_empleado;
    private String nombre_puesto;
    private double sueldo;
    private String turno;

    public Puesto(int id_puesto, int id_empleado, String nombre_puesto, double sueldo, String turno) {
        this.id_puesto = id_puesto;
        this.id_empleado = id_empleado;
        this.nombre_puesto = nombre_puesto;
        this.sueldo = sueldo;
        this.turno = turno;
    }

    public Puesto(){
    
    }
    
    public int getId_puesto() {
        return id_puesto;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getTurno() {
        return turno;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Puesto{" + "id_puesto=" + id_puesto + ", id_empleado=" + id_empleado + ", nombre_puesto=" + nombre_puesto + ", sueldo=" + sueldo + ", turno=" + turno + '}';
    }
    
    
    
}
