/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Casa extends Vivienda {
    int pisos;
    public Casa(int pisos_vivienda, int habitaciones, int banos, int identificador, int area, String direccion){
       super( habitaciones,  banos,  identificador, area, direccion);
       this.pisos = pisos_vivienda;
    }
    @Override
    void imprimir(){
        super.imprimir();
        System.out.println("cantidad de pisos: "+this.pisos);
    }
    @Override
    int valorArea(int valor_metro) {
        return super.valorArea(valor_metro);
    }
}
