
package practicas.java;
import javax.swing.*;

public class Ventana {
   
    
    public Ventana(){//adaptar
        JFrame marco = new JFrame();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Lista lt pide 3 listas de arrays si o si.
               String[] lista= {""};
               String[] lista2= {""};
               String[] lista3= {""};
                
               
               //creamos los objetos individuales del frame para poder luego pasarselos a las partes con 
        EntradaPatente entp = new EntradaPatente(marco);
        EntradaEjes enej = new EntradaEjes(marco);
        Opciones opp = new Opciones(marco, enej);
        Lista lt = new Lista(marco,lista,lista2,lista3);
        Peaje sistema = new Peaje();
        textoGanancias gg = new textoGanancias(marco,sistema);
        botonImprimir imp = new botonImprimir(marco,sistema);
        botonAgregar bt = new botonAgregar(marco,entp,enej,opp,lt,sistema,gg);
        botonEliminar et = new botonEliminar(marco,entp,enej,opp,lt,sistema,gg);
        marco.setResizable(false);
        marco.setSize(600,500);
        marco.setLayout(null);
        marco.setVisible(true); 
        
    }

}
