/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inmueblesPractica;

/**
 *
 * @author patri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rural casa = new Rural(10,20,2,4,2,2423,590,"cahuna");
        casa.imprimir();
        System.out.println("");
        Comercial comer = new Comercial("CUM", false,2625, 120, "al lado");
        comer.imprimir();
        //tring cComercial,boolean access, int identificador_input, int area_input, String direccion_input)
    }//int dis_muni, int alt,int pisos_vivienda, int habitaciones, int banos, int identificador, int area, String direccion
    
}
