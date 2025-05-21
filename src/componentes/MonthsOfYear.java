/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

/**
 *
 * @author edwin
 */

// Ingresas un numero y obtienes un mes
public enum MonthsOfYear {

    ENERO(1), FEBRERO(2), MARZO(3), ABRIL(4),
    MAYO(5), JUNIO(6), JULIO(7), AGOSTO(8),
    SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);

    private final int numero;

    MonthsOfYear(int numero) {
        this.numero = numero;
    }

    public static String obtenerNombreMes(int numero) {
        for (MonthsOfYear mes : MonthsOfYear.values()) {
            if (mes.numero == numero) {
                return mes.name(); 
            }
        }
        return "Mes inválido";

    }

}
