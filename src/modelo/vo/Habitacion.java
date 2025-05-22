package modelo.vo;

public class Habitacion {

    private int id_habitacion;
    private Double precio, size;
    private int num_camas;
    private String descripcion;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, Double precio, Double size, int num_camas, String descripcion) {
        this.id_habitacion = id_habitacion;
        this.precio = precio;
        this.size = size;
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double tamaño) {
        this.size = tamaño;
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
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", precio=" + precio + ", tama\u00f1o=" + size + ", num_camas=" + num_camas + ", descripcion=" + descripcion + '}';
    }

    public String[] toArrayString() {
        String[] strArrHabitacion = new String[5];
        strArrHabitacion[0] = String.valueOf(this.id_habitacion);
        strArrHabitacion[1] = String.valueOf(this.precio);
        strArrHabitacion[2] = String.valueOf(this.size);
        strArrHabitacion[3] = String.valueOf(this.num_camas);
        strArrHabitacion[4] = this.descripcion;
        return strArrHabitacion;
    }

}
