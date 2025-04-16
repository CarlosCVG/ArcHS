package modelo.vo;

public class Habitacion {

    private int id_habitacion;
    private Double precio, tamaño;
    private int num_camas;
    private String descripcion;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, Double precio, Double tamaño, int num_camas, String descripcion) {
        this.id_habitacion = id_habitacion;
        this.precio = precio;
        this.tamaño = tamaño;
        this.num_camas = num_camas;
        this.descripcion = descripcion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTamaño() {
        return tamaño;
    }

    public void setTamaño(Double tamaño) {
        this.tamaño = tamaño;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", precio=" + precio + ", tama\u00f1o=" + tamaño + ", num_camas=" + num_camas + ", descripcion=" + descripcion + '}';
    }

    public String[] toArrayString() {
        String[] strArrHabitacion = new String[5];
        strArrHabitacion[0] = String.valueOf(this.id_habitacion);
        strArrHabitacion[1] = String.valueOf(this.precio);
        strArrHabitacion[2] = String.valueOf(this.tamaño);
        strArrHabitacion[3] = String.valueOf(this.num_camas);
        strArrHabitacion[4] = this.descripcion;
        return strArrHabitacion;
    }

}
