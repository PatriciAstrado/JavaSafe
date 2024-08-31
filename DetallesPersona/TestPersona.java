/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primeraprueba;

/**
 *
 * @author patri
 */
public class TestPersona {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //(String nombre_ingresado, String apellido_ingresado, int idocumento_ingresado, int dia_ingresado, int mes_ingresado, int year_ingresado)
        Persona pato = new Persona("Patricio","Vejar",2124,3,6,2004);
        Persona benja = new Persona("Benjamin","Vejar",9999,18,9,2006);
        pato.imprimir();
        benja.imprimir();
    }
    
}
