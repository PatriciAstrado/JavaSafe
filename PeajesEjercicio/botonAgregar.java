/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author patri
 */
public class botonAgregar implements ActionListener{
    EntradaPatente ptt;
    EntradaEjes ejj;
    Opciones opp;
    Lista lt;
    Peaje sistema;
    JFrame marco;
    JButton botonAgrega=new JButton("Agregar Dato");//creating instance of JButton  
    textoGanancias gg;
    //
        //
      public botonAgregar(JFrame marcoIn, EntradaPatente pttIn, EntradaEjes ejjIn, Opciones oppIn, Lista ltIn, Peaje sistemaIn, textoGanancias ggIn){
          opp = oppIn;
          ejj = ejjIn;
          ptt = pttIn;
          lt = ltIn;
          sistema = sistemaIn;
          marco = marcoIn;
          gg = ggIn;
          botonAgrega.setBounds(60,400,100, 30);//x axis, y axis, width, height  
          botonAgrega.addActionListener(this);
          botonAgrega.setFont(new Font("Dialog", Font.BOLD, 11));
          marco.add(botonAgrega);
      }   
      
       public void actionPerformed(ActionEvent e){
           if(ptt.viable == true && ptt.getPatente() != null){
           sistema.entradaVehiculo(ptt.getPatente(),opp.getEscogida(),ejj.getEjes());
           lt.actualizarListas(sistema.listaPatentes(), sistema.listaTipos(), sistema.listaEjes());
           gg.actualizar();
           ejj.reset();
           
           }else{
               JOptionPane.showMessageDialog(marco, "Por favor use el formato AA-XX-11",
               "Patente Invalida", JOptionPane.ERROR_MESSAGE);
               
           }
           ptt.reset();
    }
       
    
}
