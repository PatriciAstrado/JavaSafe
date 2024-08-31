/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Oficina extends Local{
    boolean pig; // si es del gobierno o no >:x
    int valor = 3500000;
    public Oficina(boolean gob, boolean access, int identificador_input, int area_input, String direccion_input){
        super( access,  identificador_input,  area_input,  direccion_input);
        this.pig = gob;
        }
    @Override
    void imprimir(){
        System.out.println("Tipo de edificio : Oficina");System.out.println("");
        super.imprimir();
        System.out.println("La oficina es del gobierno ? : "+this.pig);
        System.out.println("Valor total del Inmueble = "+valorArea(valor));
    }
    
     @Override 
     int valorArea(int val){
         return super.valorArea(val);
     }
}
