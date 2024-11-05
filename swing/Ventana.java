/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;
import javax.swing.*;

/**
 *
 * @author patri
 */
public class Ventana {
   
    
    public Ventana(){
        JFrame marco = new JFrame();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               String[] lista= {""};
               String[] lista2= {""};
               String[] lista3= {""};

        EntradaPatente entp = new EntradaPatente(marco);
        EntradaEjes enej = new EntradaEjes(marco);
        Opciones opp = new Opciones(marco, enej);
        Lista lt = new Lista(marco,lista,lista2,lista3);
        Peaje sistema = new Peaje();
        textoGanancias gg = new textoGanancias(marco,sistema);
        botonAgregar bt = new botonAgregar(marco,entp,enej,opp,lt,sistema,gg);
        botonEliminar et = new botonEliminar(marco,entp,enej,opp,lt,sistema,gg);
        marco.setSize(600,500);
        marco.setLayout(null);
        marco.setVisible(true); 
        
    }

}
