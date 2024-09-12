/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author PC
 */
public class Peaje {
    public String nombre;
    public String departamento;
    public int ganancias = 0;
    public Peaje(String nombre, String departamento){
        this.nombre = nombre;
        this.departamento = departamento;
    }
    private List <String> listaPatente = new ArrayList<String>();
    private List <String> listatipos = new ArrayList<String>();
    
    String patenteDato;
    String tipoDato;
    int valorDato;
    
    public void entradaVehiculo(String patente, int tipo){
            
            if(tipo == 1){
                Auto v1 = new Auto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
            }
            if(tipo == 2){
                Moto v1 = new Moto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
            }
            if(tipo == 3){
                while(true){
                    try{
                    System.out.println("Por favor introdusca la cantidad de ejes del vehiculo");
                    String cejes; 
                    Scanner entrada = new Scanner(System.in);
                    cejes = entrada.nextLine();
                    int ejes = Integer.parseInt(cejes);
                    Camion v1 = new Camion(patente, ejes);
                    patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
                    break;
                    }catch(InputMismatchException ex){
                        System.out.println("error entrada teclado");

                    }
                }
            }
            
            this.listaPatente.add(patenteDato);
            this.listatipos.add(tipoDato);
            this.ganancias += valorDato;
    }
    
    
    public void mostrarDatos(){
        System.out.println("Establecimieto :: "+this.nombre);
        System.out.println("Departamento :: "+this.departamento);
        System.out.println("");
        System.out.println("-Lista de ingreso y ganancias-");
        System.out.println("");
        System.out.println("Ganacias: "+this.ganancias);
        System.out.println("");
        System.out.println("Lista de vehiculos ingresados:");
        System.out.println("");
        System.out.println("patente || vehiculo");
        for(int i = 0;i<listaPatente.size();i++){
            System.out.println(listaPatente.get(i) + " :: "+listatipos.get(i));
        }
    }
}
