/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Familiar extends Departamento{
    int valor = 2000000;  
    
     public Familiar(int valorAdmin,int habitaciones, int banos, int identificador, int area, String direccion){
        super( valorAdmin,habitaciones,  banos,  identificador, area,  direccion);
    }
     @Override
     void imprimir(){
         System.out.println("Tipo de edificio : Departamento Familiar");System.out.println("");
        super.imprimir();
         System.out.println("Valor total del Inmueble = "+valorArea(valor));
    }
     @Override
    int valorArea(int area){
        return super.valorArea(area);
    }
}
