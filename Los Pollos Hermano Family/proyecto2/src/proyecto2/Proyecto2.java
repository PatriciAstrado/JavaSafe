/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TIENE QUE EXISTIR ANTES DE CREAR LA VENTANA
        ControladorLocal local = new ControladorLocal("21", "pato", "vejar", 56, "pv24"); // creo local con datos manager
        //                                                                  CON SESSION INICIADA PARA PODER AÑADIR EMPLEADOS
        local.agregarEmpleado(2, "00", "bla", "ble", 24); // agrego cajero SIEMPRE TIENE QUE HABER UN CAJERO; SI NO NO FUNCIONARA EL AÑADIR PEDIDOS

        // TIENE QUE HABER AL MENOS 1 CAJERO ANTES DE CREAR VENTANA

        // local.agregarEmpleado(1 = mesero | 2 = cajero, rut, nombre, apellido, salario );
        local.agregarEmpleado(1, "0", "mu", "la", 22); // agrego mesero
        
        // local.agregarEmpleado(1, "999", "Scape", "goat", 666);//agrego mesero

        // local.modificarEmpleado("22", false);// despide cajero

  //      local.agregarPlatillo("panqueque", "yumi", 7000);      // creamo un platillo
//        local.agregarPlatillo("zapallo italiano", "iu", 7000); // creamos el platillo
        // local.quitarPlatillo("zapallo italiano");//removemos el platillo del menu
        // local.agregarQuitarPedido(1, "panqueque");//agregamos al pedido el panqueque

        // local.TerminarPedido("20");//terminamos y procesamos el pedido usando el mesero con run 20

    //    local.agregarPlatillo("leche asada", "hapi", 10000);
        // local.agregarQuitarPedido(1, "panqueque");//agregamos al pedido el panqueque
        // local.agregarQuitarPedido(1, "leche asada");//agregamos
        // local.agregarQuitarPedido(1, "panqueque");//agregamos al pedido el panqueque
        // local.agregarQuitarPedido(0,"panqueque");//removemos el ultimo panqueque
        // local.TerminarPedido("20");//terminamos y procesamos el pedido
        // local.agregarPlatillo("asado de vacuno", "ckackanck", 10000);
        local.onOffLogin(); // cerramos sesion admin
        new vMain(local);
    }
}
