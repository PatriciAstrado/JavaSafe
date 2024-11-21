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
public class textoGanancias {
    JFrame marco;
    JLabel label;
    Peaje sistema;
    public textoGanancias(JFrame marcoIn, Peaje sistemaIn){
    marco = marcoIn;
    sistema = sistemaIn;
    label = new JLabel("Ganancias : "+Integer.toString(sistema.getGanancias()));
    label.setBounds(60,200, 1000,100);
    
    marco.add(label);    
    }
    
   public void actualizar(){
   label.setText(("Ganancias : "+Integer.toString(sistema.getGanancias())));
   }
}
