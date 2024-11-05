/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zona.de.trabajo;

/**
 *
 * @author PC
 */
public class Persona implements Comparable<Persona>{
    public int rut;
    public int edad;
    public String nombre;
    public Persona(String nombre,int rut, int edad){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
    }
    public int getRut(){
        return this.rut;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int compareTo(Persona o){
        if(this.rut != o.getRut()){
            System.out.println(this.nombre +" y "+o.getNombre()+ " No son iguales");
            return 0;
        }
        if(this.edad != o.getEdad()){
            System.out.println(this.nombre +" y "+o.getNombre()+ " No son iguales");
            return 0;
            
        }
        if(this.nombre != o.getNombre()){
            System.out.println(this.nombre +" y "+o.getNombre()+ " No son iguales");
            return  0;
        }
        System.out.println(this.nombre +" y "+o.getNombre()+ " son iguales");
        return 1;
        
    }    
    
    
}
