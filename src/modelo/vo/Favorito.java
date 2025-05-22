/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

/**
 *
 * @author edwin
 */
public class Favorito {
    private int id_favorito;
    private int id_cliente;
    private int id_habitacion;

    public Favorito(int id_favorito, int id_cliente, int id_habitacion) {
        this.id_favorito = id_favorito;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
    }

    public Favorito() {
    }
    
    public int getId_favorito() {
        return id_favorito;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    
}
