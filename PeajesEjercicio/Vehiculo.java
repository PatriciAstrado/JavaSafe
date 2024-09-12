/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

/**
 *
 * @author PC
 */
public abstract class Vehiculo {
    public String patente;
    public int valorPeaje;
    public String tipoV;
    public Vehiculo(String patente , int valor, String tipo){
        this.patente = patente;
        this.valorPeaje = valor;
        this.tipoV = tipo;
    }
    
    public abstract int cobro();
}
