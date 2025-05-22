/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.util;

/**
 *
 * @author edwin
 */

/*
    El patron Observer es un patron de diseno en el que un objeto (el Observable)
    notifica a otros objetos (Observers) cuando ocurre un cambio en su estado. 
    Este patron es util cuando se tiene una relacion de uno a muchos, en la que
    un cambio en el Observable puede afectar a varios Observers. Los Observers
    se registran en el Observable y se mantienen informados de los cambios.
*/

// Interfaz Observable, que define los metodos necesarios para gestionar los observadores.
// Los objetos que implementen esta interfaz podran ser observados por otros objetos.
public interface Observable {

    // Registra un nuevo Observer. 
    // El Observer sera notificado cuando el Observable experimente cambios.
    void addObserver(Observer observer);

    // Elimina un Observer previamente registrado. 
    // El Observer ya no recibira notificaciones de cambios.
    void deleteObserver(Observer observer);

    // Notifica a todos los Observers registrados sobre un cambio en el estado del Observable. 
    //Esto les permite reaccionar a la modificacion de estado.
    void notifyObservers();
}
