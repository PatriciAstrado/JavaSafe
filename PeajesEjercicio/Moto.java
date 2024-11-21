/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

/**
 *
 * @author PC
 */
public class Moto extends Vehiculo{
    public Moto(String patente){
        super(patente, 5000, "Moto");
    }
    
    @Override
    public int cobro(){
        return this.valorPeaje;
    }
}
