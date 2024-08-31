/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primeraprueba;

/**
 *
 * @author patri
 */
public class fecha {
    protected int dia;
    protected int mes;
    protected int year;
    public fecha(int dia_ingresado, int mes_ingresado, int year_ingresado){
        this.dia = dia_ingresado;
        this.mes = mes_ingresado;
        this.year = year_ingresado;
    }
    void imprimir(){
        System.out.println("year de nacimiento:"+this.dia+"/"+this.mes+"/"+this.year+".");
    }
}
