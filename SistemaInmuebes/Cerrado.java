/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Cerrado extends Urbano{
    int valor = 2500000;
    int valorAdministracion;
    boolean areas_comunes ;
    public Cerrado(int valorAdmin, boolean aComunes,int pisos_vivienda, int habitaciones, int banos, int identificador, int area, String direccion){
        super( pisos_vivienda,  habitaciones,  banos, identificador, area,  direccion);
        this.valorAdministracion = valorAdmin;
        this.areas_comunes = aComunes;
        
    }
    @Override
    void imprimir(){
        System.out.println("Tipo de edificio : Casa cerrada");
        System.out.println("");
        super.imprimir();
        System.out.println("Coste de administracion del edificio = "+this.valorAdministracion);
        System.out.println("Hay areas comunes? : "+this.areas_comunes);
        System.out.println("Valor total del inmueble = "+valorArea(valor));
    }
    @Override
    int valorArea(int valor_metro) {
        return super.valorArea(valor_metro);
    }
}
