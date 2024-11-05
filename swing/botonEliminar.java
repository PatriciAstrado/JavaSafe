/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author patri
 */
public class botonEliminar implements ActionListener{
    EntradaPatente ptt;
    EntradaEjes ejj;
    Opciones opp;
    Lista lt;
    Peaje sistema;
        textoGanancias gg;

    JFrame marco;
    JButton botonAgrega=new JButton("Eliminar Dato");
    //
        //
      public botonEliminar(JFrame marcoIn, EntradaPatente pttIn, EntradaEjes ejjIn, Opciones oppIn, Lista ltIn, Peaje sistemaIn, textoGanancias ggIn){
          opp = oppIn;
          ejj = ejjIn;
          ptt = pttIn;
          lt = ltIn;
          sistema = sistemaIn;
          gg = ggIn;

          marco = marcoIn;
          botonAgrega.setBounds(180,400,100, 40);//x axis, y axis, width, height  
          botonAgrega.addActionListener(this);
          marco.add(botonAgrega);
      }  
      
       public void actionPerformed(ActionEvent e){
           
           
           sistema.pop();
           gg.actualizar();
           lt.actualizarListas(sistema.listaPatentes(), sistema.listaTipos(), sistema.listaEjes());
        
    }
       
    
}
