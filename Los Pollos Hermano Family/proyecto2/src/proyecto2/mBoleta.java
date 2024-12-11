/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;
import java.util.ArrayList;


public class mBoleta {
    private ArrayList<mPlatillo> platillos;
    private int valorTotal;
    private int valorTotalOriginal;
    public mBoleta() {
        platillos = new ArrayList<>();
        valorTotal = 0;
    }

    public ArrayList<mPlatillo> getPlatillos() {
        return platillos;
    }
    

    public void agregarPlatillo(mPlatillo platillo) {
        platillos.add(platillo);
        valorTotal += platillo.getValor();
        valorTotalOriginal+= platillo.getValor();
    }
    
    public void quitarPlatillo(mPlatillo platillo){
        platillos.remove(platillo);
        valorTotal -= platillo.getValor();
        valorTotalOriginal-= platillo.getValor();
    }
    
    public void imprimir() {
        System.out.println("Boleta:");
        for (mPlatillo platillo : platillos) {
            System.out.println(platillo.getNombre() + " - $" + platillo.getValor());
        }
        System.out.println("Total a pagar: $" + valorTotal);
    }
    public int getValorTotal() {
        return valorTotal;
    }
    public int getValorTotalOriginal(){
        return valorTotalOriginal;
    }
    
    public void descuentoNumerico(int descuento){
        if(platillos != null){
            if((descuento <= this.valorTotal) && descuento >= 0){
                this.valorTotal -= descuento;
            }else{
                System.out.println("ERROR, no se puede descontar mas del precio original");
            }
        }
    }
    public void descuentoPorcentual(int descuento){//0 a 100 en valores
        if(platillos != null){
            if(0< descuento && descuento<=100){
                this.valorTotal -= this.valorTotal*(descuento/100);
            }else{
                System.out.println("ERROR, no se puede descontar mas del 100% o menor al 0%");
            }
        }
    }
    
    public void aumentoNumerico(int aumento){
        if(platillos != null){
            if((aumento >= 0)){
                this.valorTotal += aumento;
            }else{
                System.out.println("ERROR, no se puede añadir menos 0");
            }
        }
    }
    public void aumentoPorcentual(int aumento){//0 a 100 en valores
        if(platillos != null){
            if(0< aumento && aumento<=100){
                this.valorTotal += this.valorTotal*(aumento/100);
            }else{
                System.out.println("ERROR, no se puede descontar mas del 100% o menor al 0%");
            }
        }
    }
}
