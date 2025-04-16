/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

/**
 *
 * @author edwin
 */

// Interfaz Observer, que define el metodo update() que sera llamado cuando 
// el estado del Observable cambie.
public interface Observer {
    // Este metodo es llamado cuando el Observable notifica que su estado ha cambiado.
    // El Observer implementara esta funcion para responder a la notificacion.
    void update();
}