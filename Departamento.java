/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Departamento extends Vivienda{
    int valorAdministracion ;
    public Departamento(int valorAdmin,int habitaciones, int banos, int identificador, int area, String direccion){
        super( habitaciones,  banos,  identificador, area,  direccion);
        this.valorAdministracion = valorAdmin;
    }
    @Override
    void imprimir(){
        super.imprimir();
        System.out.println("Coste de Administracion del edificio = "+this.valorAdministracion);        
    }
    @Override
    int valorArea(int area){
        return super.valorArea(area);
    }
}
