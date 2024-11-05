/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

/**
 *
 * @author PC
 */
public class Camion extends Vehiculo{
    public int cantEjes;
    public Camion(String patente, int ejes){
        super(patente,5000, "Camion");
        this.cantEjes = ejes;
    }
    @Override
    public int cobro(){
        return this.valorPeaje*cantEjes;
    }
}
