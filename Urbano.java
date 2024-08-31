/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Urbano extends Casa{
    int valor = 3000000;
    public Urbano(int pisos_vivienda, int habitaciones, int banos, int identificador, int area, String direccion){
        super( pisos_vivienda,  habitaciones,  banos, identificador, area,  direccion);
    }
    void imprimir(){
        System.out.println("Tipo de edificio : Casa Urbana");System.out.println("");
        super.imprimir();
        System.out.println("Precio del inmueble = "+valorArea(valor));
    }
    @Override
    int valorArea(int valor_metro) {
        return super.valorArea(valor_metro);
    }
}
