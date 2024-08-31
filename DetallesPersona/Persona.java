/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primeraprueba;

/**
 *
 * @author patri
 */
//import primeraprueba.fecha;
public class Persona extends fecha {
    String nombre;
    String Apellido;
    int Idocumento;
    public Persona(String nombre_ingresado, String apellido_ingresado, int idocumento_ingresado, int dia_ingresado, int mes_ingresado, int year_ingresado){
    super( dia_ingresado, mes_ingresado, year_ingresado);
    this.nombre = nombre_ingresado;
    this.Apellido = apellido_ingresado;
    this.Idocumento = idocumento_ingresado;
    }
    void imprimir(){
        System.out.println("Nombre completo: "+this.nombre+" "+this.Apellido);
        System.out.println("Documento Identificador: "+this.Idocumento);
        super.imprimir();
            }
}
