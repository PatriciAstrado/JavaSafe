/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Estudio extends Departamento{
    int valor = 1500000;
    public Estudio(int valorAdmin, int banos, int identificador, int area, String direccion){
        super( valorAdmin,1,  banos,  identificador, area,  direccion);
    }
    @Override
     void imprimir(){
         System.out.println("Tipo de edificio : Estudio Apartamento");System.out.println("");
        super.imprimir();
         System.out.println("Valor total del Inmueble = "+valorArea(valor));
    }
     @Override
    int valorArea(int area){
        return super.valorArea(area);
    }
}
