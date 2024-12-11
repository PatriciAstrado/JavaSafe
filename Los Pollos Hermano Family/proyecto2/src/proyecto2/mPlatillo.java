/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;


public class mPlatillo {

    private String nombre;
    private String descripcion;
    private int valor;
    

    public mPlatillo(String nombre, String descripcion, int valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public int getValor() {
        return this.valor;
    }
    public void setValor(int nuevoValor){
        this.valor = nuevoValor;
    }
    public void setDescripcion(String nuevaDescripcion){
        this.descripcion = nuevaDescripcion;
    }
    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }
}
