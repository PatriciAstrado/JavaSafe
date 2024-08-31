/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Vivienda extends Inmueble{
    int numero_habitaciones;
    int numero_banos;
    //(int identificador_input, int area_input, String direccion_input)
    public Vivienda(int habitaciones, int banos, int identificador, int area, String direccion){
        super(identificador, area, direccion);
        this.numero_banos = banos;
        this.numero_habitaciones = habitaciones;
    }
    @Override
    void imprimir(){
       super.imprimir();
        System.out.println("Numero de habitaciones: "+this.numero_habitaciones);
        System.out.println("Numero de baños: "+this.numero_banos);
    }
    @Override
    int valorArea(int valor_metro) {
        return super.valorArea(valor_metro);
    }
    
}
