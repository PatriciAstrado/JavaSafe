/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Comercial extends Local{
    String centro_comercial;
    int valor = 3000000;
    public Comercial(String cComercial,boolean access, int identificador_input, int area_input, String direccion_input){
        super(access,identificador_input, area_input,  direccion_input);
        this.centro_comercial = cComercial;
    }
    @Override
    void imprimir(){
        System.out.println("Tipo de edificio : Local comercial");
        System.out.println("");
        super.imprimir();
        System.out.println("El centro comercial donde el local esta establecido es: "+this.centro_comercial);
        System.out.println("Valor total del Inmueble = "+valorArea(valor));
    }
    @Override
    int valorArea(int val){
        return super.valorArea(val);
    }
}
