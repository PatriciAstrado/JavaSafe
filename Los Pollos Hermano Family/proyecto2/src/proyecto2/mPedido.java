/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.ArrayList;


public class mPedido {
    private ArrayList<mPlatillo> platillos;
    private int valorTotal;
    public mPedido() {
        platillos = new ArrayList<>();
        valorTotal = 0;
    }
    public void agregarPlatillo(mPlatillo platillo) {
        platillos.add(platillo);
        valorTotal += platillo.getValor(); // Sumar el valor del platillo
    }
    public void removerPlatillo(mPlatillo platillo){
        this.platillos.remove(platillo);
        this.valorTotal-=platillo.getValor();
    }
    public ArrayList<mPlatillo> getPlatillos() {
        return platillos;
    }
    public int getValorTotal() {
        return valorTotal;
    }
    public void imprimirPedido() {
        System.out.println("Pedido:");
        for (mPlatillo platillo : platillos) {
            System.out.println(platillo.getNombre() + " - $" + platillo.getValor());
        }
      //  System.out.println("Total del pedido: $" + valorTotal);
    }
    public boolean isEmpty(){
        return this.platillos.isEmpty();
    }
}
