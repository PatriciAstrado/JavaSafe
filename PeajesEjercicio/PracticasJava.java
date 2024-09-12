/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicas.java;
import java.util.InputMismatchException;

import java.util.Scanner;


/**
 *
 * @author patri
 */
public class PracticasJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        
        
        Scanner entrada = new Scanner(System.in);
        String ent;
        String tt;
        int tipo=0;
        Peaje most = new Peaje("Gorgonzola","Lomitos");
        System.out.println("Por favor introduzca los datos del vehiculo (auto|moto|camion) : ");
        while(true){
            while(true){
                try{
                    System.out.println("Patente:");
                    ent = entrada.nextLine();
                    System.out.println("Tipo de vehiculo");
                    tt = entrada.nextLine();
                    tt = tt.toLowerCase().trim();
                    switch(tt){
                        case "auto":
                            tipo = 1;
                            break;
                        case "moto":
                            tipo = 2;
                            break;
                        case "camion":
                            tipo = 3;
                            break;
                        default:
                            tipo = 1;
                            break;
                    }
                    break;
                }catch(InputMismatchException ex){
                    System.out.println("error entrada teclado");
                }
            }
            
            most.entradaVehiculo(ent,tipo);
            System.out.println("Si desea terminar introdusca 'salir' ");
            ent = entrada.nextLine();
            ent = ent.toLowerCase().trim();
            
            if(ent.equals("salir")){
                break;
            }
        }
        //System.out.println("Introdusca la patente y el tipo de vehiculo 1=auto, 2=moto, 3=camion  .. Si desea terminar el proceso ingrese 0");
        /*
        System.out.println("Introduzca la patente:");
        ent = entrada.nextLine();
        System.out.println("Ingrese el tipo de vehiculo");
        tt = entrada.nextLine();//añadir while para constante ingreso de datos ahsta 0 tu sabes pato del futuro ;)
*/
        most.mostrarDatos();
    }
    
}
