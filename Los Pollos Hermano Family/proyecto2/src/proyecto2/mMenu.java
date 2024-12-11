/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;
import java.util.ArrayList;

public class mMenu {

    private ArrayList<mPlatillo> platillos;
    public mMenu() {
        platillos = new ArrayList<>();
    }
    public void actualizarPlatillo(mPlatillo platillo, String nombre, String descripcion, int valor){
        platillo.setDescripcion(descripcion);
        platillo.setNombre(nombre);
        platillo.setValor(valor);
    }
    public void agregarPlatillo(mPlatillo platillo) {
        platillos.add(platillo);
    }
    public void eliminarPlatillo(mPlatillo platillo) {
    mPlatillo plato = buscarPlatillo(platillo.getNombre());
    boolean eliminado = platillos.remove(plato);
    if (!eliminado) {
        System.out.println("No se encontró el platillo para eliminar.");
    }
}

    public  ArrayList<mPlatillo> getListaPlatillos(){
        return this.platillos;
    }    
    
    public void imprimir() {
        System.out.println("Menú:");
        for (mPlatillo platillo : platillos) {
            System.out.println(platillo.getNombre() + " - $" + platillo.getValor());
        }
    }
    public mPlatillo buscarPlatillo(String nombre) {
        for (mPlatillo platillo : platillos) {
            if (platillo.getNombre().equalsIgnoreCase(nombre)) {
                return platillo;
            }
        }
        return null;
    }
    public mPlatillo buscarPlatillo(int posicion){
        return platillos.get(posicion);
    }

    
    
    public String[][] getArrayData() {
    if (this.platillos.size() == 0) {return new String[0][2];}
   
    String[][] data = new String[this.platillos.size()][2];

    try {
        int i = 0;
        for (mPlatillo plato : this.platillos) {
            data[i][0] = plato.getNombre(); // Nombre del platillo en la primera columna
            data[i][1] = String.valueOf(plato.getValor()); // Valor del platillo en la segunda columna
            i++;
        }
    } catch (Exception e) {
        System.out.println("ERROR AL GENERAR ARRAY DE DATOS DE MENU | FUNCION getArrayData()");
        return new String[0][2];
    }

    return data;
}
    public int gastoTotal(){
        if(this.platillos.size()==0){return 0;}
        int num=0;
        try{
            for(mPlatillo plato : this.platillos){
                num += plato.getValor();
            }            
        }catch(Exception e){
            System.out.println("ERROR AL CALCULAR EL COSTO DEL MENU PEDIDO");
            return 0;
        }
        return num;
    }


}
