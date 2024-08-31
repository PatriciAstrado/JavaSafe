/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Rural extends Casa{
    int distancia_municipal;
    int altutid;
    int valor = 1500000;
    public Rural(int dis_muni, int alt,int pisos_vivienda, int habitaciones, int banos, int identificador, int area, String direccion){
        super( pisos_vivienda, habitaciones, banos, identificador, area,  direccion);
        this.distancia_municipal = dis_muni;
        this.altutid = alt;
    }
    @Override
    void imprimir(){
        System.out.println("Tipo de edificio : Casa Rural");System.out.println("");
        super.imprimir();
        System.out.println("Distancia de la municipalidad local: "+this.distancia_municipal);
        System.out.println("Altutid al mar: "+this.altutid );
        System.out.println("Precio total del inmueble = "+valorArea(valor));
    }
    @Override
    int valorArea(int valor_metro) {
        return super.valorArea(valor_metro);
    }
   
}
