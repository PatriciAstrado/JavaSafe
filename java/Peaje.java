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
    public Peaje (){
        this.nombre = "";
        this.departamento = "";
    }
    private List <String> listaPatente = new ArrayList<String>();
    private List <String> listatipos = new ArrayList<String>();
    private List <String> listaEjes = new ArrayList<String>();
    
    String cejes; 
    String patenteDato;//string patente
    String tipoDato;//tipo de movil
    int valorDato;//valor del movil
    
    public void entradaVehiculoAnaloga(String patente, int tipo){
            
            if(tipo == 1){
                Auto v1 = new Auto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
                    cejes = "";
            }
            if(tipo == 2){
                Moto v1 = new Moto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
                    cejes = "";
            }
            if(tipo == 3){
                while(true){
                    try{
                    System.out.println("Por favor introdusca la cantidad de ejes del vehiculo");
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
            this.listaEjes.add(cejes);
            this.listaPatente.add(patenteDato);
            this.listatipos.add(tipoDato);
            this.ganancias += valorDato;
            
    }
    
    
    public void entradaVehiculo(String patente, int tipo, int ejes){
            
            if(tipo == 0){
                Auto v1 = new Auto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
                    cejes = "";
            }
            if(tipo == 1){
                Moto v1 = new Moto(patente);
                patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.valorPeaje;
                    cejes = "";
            }
            if(tipo == 2){
                    
                    Camion v1 = new Camion(patente, ejes);
                    patenteDato = v1.patente;
                    tipoDato = v1.tipoV;
                    valorDato = v1.cobro();
                    cejes = Integer.toString(ejes);
                    
                    
                
            }
            this.listaEjes.add(cejes);
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
    
    public void pop() {//elimnar los ultimos datos de las listas
    if (!listaPatente.isEmpty() && !listatipos.isEmpty() && !listaEjes.isEmpty()) {
        
        String patenteEliminada = listaPatente.remove(listaPatente.size() - 1);
        String tipoEliminado = listatipos.remove(listatipos.size() - 1);
        String ejesEliminados = listaEjes.remove(listaEjes.size() - 1);

        
        int valorEliminado = 0;
        if (tipoEliminado.equals("Auto")) {
            valorEliminado = 10000;
        } else if (tipoEliminado.equals("Moto")) {
            valorEliminado = 5000;
        } else if (tipoEliminado.equals("Camion")) {
            int ejes = ejesEliminados.isEmpty() ? 0 : Integer.parseInt(ejesEliminados);//esta parte si fue gpt xd
            valorEliminado = 5000*ejes;
        }

        
        this.ganancias -= valorEliminado;

        System.out.println("Se ha eliminado el último vehículo: " + patenteEliminada + " (" + tipoEliminado + ")");
    } else {
        System.out.println("No hay vehículos para eliminar.");
    }
}
    
    
    public int getGanancias(){
        return ganancias;
    }
    
    
    // Cambiado para devolver un array en lugar de una lista
    public String[] listaPatentes() {
        return listaPatente.toArray(new String[0]);
    }

    // Cambiado para devolver un array en lugar de una lista
    public String[] listaTipos() {
        return listatipos.toArray(new String[0]);
    }

    // Cambiado para devolver un array en lugar de una lista
    public String[] listaEjes() {
        return listaEjes.toArray(new String[0]);
    }
}
