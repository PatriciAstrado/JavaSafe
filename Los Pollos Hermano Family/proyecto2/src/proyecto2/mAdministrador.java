/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.ArrayList;


public class mAdministrador extends mEmpleado {

    private String claveAcceso;

    public mAdministrador(String rut, String nombre, String apellido, int telefono, String claveAcceso) {
        super(rut, nombre, apellido, telefono);
        this.claveAcceso = claveAcceso;
    }

    public boolean validarClave(String claveIngresada) {
        return claveAcceso.equals(claveIngresada);
    }

    public void agregarEmpleado(ArrayList<mEmpleado> empleados, mEmpleado nuevoEmpleado) {
        nuevoEmpleado.setActivo(true);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado: " + nuevoEmpleado.getNombre());
    }

    public void modificarEmpleadoEstado(mEmpleado empleado, boolean activo) {
        empleado.setActivo(activo);
        System.out.println("Estado del empleado " + empleado.getNombre() + " modificado a " +
                           (activo ? "Activo" : "Inactivo"));
    }

    public void modificarMenu(mMenu menu, mPlatillo platillo, boolean agregar) {//el boolean dice si agregar o eliminar
        if (agregar) {
            menu.agregarPlatillo(platillo);
           // System.out.println("mPlatillo agregado al menu: " + platillo.getNombre());
        } else {
            mPlatillo encontrado = menu.buscarPlatillo(platillo.getNombre());
            if (encontrado != null) {
                menu.eliminarPlatillo(encontrado);
               // System.out.println("mPlatillo eliminado del menú: " + platillo.getNombre());
            } else {
               // System.out.println("El platillo no existe en el menú.");
            }
        }
    }
    public void removerDeMenu(mMenu menu, String platillo) {//el boolean dice si agregar o eliminar
        
            mPlatillo encontrado = menu.buscarPlatillo(platillo);
            if (encontrado != null) {
                menu.eliminarPlatillo(encontrado);
              //  System.out.println("mPlatillo eliminado del menú: " + platillo);
            } else {
               // System.out.println("El platillo no existe en el menú.");
            }
       
    }
    public mEmpleado buscarEmpleadoPorRut(ArrayList<mEmpleado> empleados, String rut) {
        for (mEmpleado empleado : empleados) {
            if (empleado.getRut().equals(rut)) {
                return empleado;
            }
        }
        return null;
    }
}