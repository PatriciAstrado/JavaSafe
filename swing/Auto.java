/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package practicas.java;

/**
 *
 * @author PC
 */
public class Auto extends Vehiculo{
    public Auto(String patente){
    super(patente, 10000,"Auto");
    }
    @Override
    public int cobro(){
        return this.valorPeaje;
    }
    
}
