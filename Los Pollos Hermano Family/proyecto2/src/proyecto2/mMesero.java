/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.Scanner;


public class mMesero extends mEmpleado {

    public mMesero(String rut, String nombre, String apellido, int telefono) {
        super(rut, nombre, apellido, telefono);
        
    }

    public mPedido tomarPedido(mMenu menu) {
        Scanner scanner = new Scanner(System.in);
        mPedido pedido = new mPedido();
        menu.imprimir();
        boolean continuar = true;
        while (continuar) {
            //System.out.print("Selecciona el nombre del platillo o escribe 'fin' para terminar el pedido: ");
            String platilloNombre = scanner.nextLine();
            if (platilloNombre.equalsIgnoreCase("fin")) {
                continuar = false;
            } else {
                mPlatillo platillo = menu.buscarPlatillo(platilloNombre);
                if (platillo != null) {
                    pedido.agregarPlatillo(platillo);
                } else {
                  //  System.out.println("mPlatillo no encontrado. Intenta de nuevo.");
                }
            }
        }
        return pedido;
    }
     public mPedido procesarPedidoMenu(mMenu menu){
        mPedido pedido= new mPedido();
        for (mPlatillo platillo : menu.getListaPlatillos()) {
            pedido.agregarPlatillo(platillo);
        }
         return pedido;
     }
     public mMesero self(){
         return this;
     }
     public String getNombreCompleto(){
         return getNombre() + " " + getApellido();
     }

}
