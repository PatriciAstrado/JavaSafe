/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Opciones implements ActionListener{
    JLabel txt = new JLabel("Tipo de vehiculo");
     String[] lista= {"Autos","Motos","Camiones"};
    JFrame marco;
    JComboBox combo = new JComboBox(lista);
    EntradaEjes ejj;
    int escogida;

     public Opciones(JFrame marcoIn, EntradaEjes ejjIn){
         ejj = ejjIn;
        marco = marcoIn;
        combo.setBounds(60,100,90,20);
        txt.setBounds(60,80,90,20);
        txt.setFont(new Font("Dialog", Font.BOLD, 11));        
        combo.addActionListener(this);
        marco.add(combo);
        marco.add(txt);
     }
     
       public void actionPerformed(ActionEvent e){
            escogida = combo.getSelectedIndex();
            if(escogida == 2){
                ejj.activar();
            }else{
                ejj.desactivar();
                ejj.reset();
             
            }
            //System.out.println(escogida);
        
    }
       
    public int getEscogida(){
        return escogida;
    }
}/*
 private void opciones(JFrame marco){
        JComboBox combo = new JComboBox(lista);
        
        
        String data = "Programming language Selected: "   
   + cb.getItemAt(cb.getSelectedIndex());  
    
    }*/