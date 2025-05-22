package modelo.vo;

import java.time.LocalDate;

public class Reservacion {

    private int id_reservacion, id_habitacion, id_huesped;
    private LocalDate f_entrada, f_salida;
    private String estado;

    public Reservacion() {
    }

    public Reservacion(int id_reservacion, int id_habitacion, int id_huesped, String estado, LocalDate f_entrada, LocalDate f_salida) {
        this.id_reservacion = id_reservacion;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
        this.f_entrada = f_entrada;
        this.f_salida = f_salida;
        this.estado = estado;
    }

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public LocalDate getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(LocalDate f_entrada) {
        this.f_entrada = f_entrada;
    }

    public LocalDate getF_salida() {
        return f_salida;
    }

    public void setF_salida(LocalDate f_salida) {
        this.f_salida = f_salida;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "id_reservacion=" + id_reservacion + ", id_habitacion=" + id_habitacion + ", id_huesped=" + id_huesped + ", f_entrada=" + f_entrada + ", f_salida=" + f_salida + '}';
    }

    public String[] toArrayString() {
        String[] strArrReservacion = new String[5];
        strArrReservacion[0] = String.valueOf(this.id_reservacion);
        strArrReservacion[1] = String.valueOf(this.id_habitacion);
        strArrReservacion[2] = String.valueOf(this.id_huesped);
        strArrReservacion[3] = String.valueOf(this.f_entrada);
        strArrReservacion[4] = String.valueOf(this.f_salida);
        return strArrReservacion;
    }

}
