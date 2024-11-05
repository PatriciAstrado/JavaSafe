/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


/**
 *
 * @author patri
 */
public class EntradaEjes implements KeyListener {
    JFrame marco;
    JTextField ejes = new JTextField();
    public int cejes=1;
    JLabel txt = new JLabel(": Cantidad ejes");
    public EntradaEjes(JFrame marcoIn){
       marco = marcoIn;    
       ejes.setBounds(60,170, 50,20);
       ejes.addKeyListener((KeyListener) this);
       txt.setBounds(120,-20,400,400);
       txt.setFont(new Font("Dialog", Font.BOLD, 11));
       ejes.setEnabled(false);
       txt.setVisible(false);
       marco.add(ejes);
       marco.add(txt);
    }
    
    public void keyPressed(KeyEvent e) {
    
    String value = ejes.getText();
    
    if (Character.isDigit(e.getKeyChar())) {
        ejes.setEditable(true);        
        try {
            
            cejes = Integer.parseInt(value + e.getKeyChar());
        } catch (NumberFormatException ex) {
            cejes = 1;
        }
    } else {
        ejes.setEditable(false);
    }
}



    public void keyReleased (KeyEvent e) {    
        
    }    

    public void keyTyped (KeyEvent e) {    
        
    }    
     
    
    
    public int getEjes(){
    return cejes;}
    
    public void activar(){       ejes.setEnabled(true); txt.setVisible(true);
}
    public void desactivar(){       ejes.setEnabled(false);txt.setVisible(false);
}
    
    public void reset(){
        ejes.setText("");
        cejes =1;
    }
}

