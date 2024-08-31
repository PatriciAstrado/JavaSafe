/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Inmueble {
    int identificador;
    int area;
    String direccion;
    public Inmueble(int identificador_input, int area_input, String direccion_input){
        this.identificador = identificador_input;
        this.area = area_input;
        this.direccion = direccion_input;
    }
    int valorArea(int valor_metro){
        int valor = this.area*valor_metro;
        return valor;
    }
    void imprimir(){
        System.out.println("Identificador de inmueble: "+this.identificador);
        System.out.println("Area total: "+this.area);
        System.out.println("Dirreccion: "+this.direccion);
    }
}
