/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Local extends Inmueble{
    boolean acceso_externo;
    public Local(boolean access, int identificador_input, int area_input, String direccion_input){
        super( identificador_input, area_input,  direccion_input);
        this.acceso_externo = access;
    }
    @Override
    void imprimir(){
        super.imprimir();
        System.out.println("El local tiene acceso a la calle? = "+this.acceso_externo);
    }
    @Override
    int valorArea(int valor){
        return super.valorArea(valor);
    }
}
