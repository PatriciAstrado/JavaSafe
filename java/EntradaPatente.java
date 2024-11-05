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
    private JFrame marco;
    private JTextField espacio = new JTextField();
    private String patente=null;
    private JLabel txt = new JLabel("Patente:");
    public Boolean viable = false;
    public EntradaPatente(JFrame marcoIn){
        marco = marcoIn;  
        espacio.setBounds(60,130, 150,20);
        espacio.addFocusListener(this);
        txt.setBounds(60,-45,400,400);
        txt.setFont(new Font("Dialog", Font.BOLD, 11));
        marco.add(espacio);
        marco.add(txt);
    }
    
    public void focusGained(FocusEvent e) {
        //na que hacer
    }
     public void focusLost(FocusEvent e) {
       patente = espacio.getText();
    // Expresión regular para coincidir con el patrón 'AA-BB-12'
    
    
    if (patente.matches("[A-Za-z]{2}-[A-Za-z]{2}-\\d{2}")) { //"^[A-Z]{2}[A-Z0-9]{2}[0-9]{2}$"
        viable = true;  // Si el formato coincide, es viable
    } else {
        viable = false; // Si no coincide, no es viable
    }

    }
    
    public String getPatente(){
        return patente;
    }
    
    public void reset(){
        espacio.setText("");
        patente = null;
    }
    
}
