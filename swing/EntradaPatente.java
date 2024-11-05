/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;


import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

/**
 *
 * @author patri
 */
public class EntradaPatente implements FocusListener  {
    JFrame marco;
    JTextField espacio = new JTextField();
    String patente="";
    JLabel txt = new JLabel("Patente:");
    public EntradaPatente(JFrame marcoIn){
        marco = marcoIn;  
        espacio.setBounds(60,130, 150,20);
        espacio.addFocusListener(this);
        txt.setBounds(60,-45,400,400);
        txt.setFont(new Font("Dialog", Font.ITALIC, 11));
        marco.add(espacio);
        marco.add(txt);
    }
    
    public void focusGained(FocusEvent e) {
        //na que hacer
    }
     public void focusLost(FocusEvent e) {
       patente = espacio.getText();
    }
    
    public String getPatente(){
        return patente;
    }
    
    public void reset(){
        espacio.setText("");
    }
    
}
