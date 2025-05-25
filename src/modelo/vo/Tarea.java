package modelo.vo;

public class Tarea {

    private int id_tarea;
    private int id_administrador;
    private int id_empleado;
    private String asunto;
    private String mensaje;
    private String lectura;

    public Tarea(int id_tarea, int id_administrador, int id_empleado, String asunto, String mensaje, String lectura) {
        this.id_tarea = id_tarea;
        this.id_administrador = id_administrador;
        this.id_empleado = id_empleado;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.lectura = lectura;
    }

    public Tarea() {

    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_adminsitrador) {
        this.id_administrador = id_adminsitrador;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    @Override
    public String toString() {
        return asunto;
    }

}
