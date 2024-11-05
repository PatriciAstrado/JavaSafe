/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/**
 *
 * @author patri
 */
public class Lista {
    JFrame marco;
    
    JList<String> jListaPatentes; 
    JList<String> jListaTipos;
    JList<String> jListaEjes;
    
    DefaultListModel<String> listModelPatentes;
    DefaultListModel<String> listModelTipos;
    DefaultListModel<String> listModelEjes;

    JLabel txtE = new JLabel("EJES");
    JLabel txtP = new JLabel("PATENTES");
    JLabel txtT = new JLabel("TIPOS");
    
    public Lista(JFrame marcoIn, String [] listaPatente, String [] listaTipo, String [] listaEjes){
      marco = marcoIn;
      
        listModelPatentes = new DefaultListModel<>();
        listModelTipos = new DefaultListModel<>();
        listModelEjes = new DefaultListModel<>();      
        
         for (String patente : listaPatente) {
            listModelPatentes.addElement(patente);
        }
        for (String tipo : listaTipo) {
            listModelTipos.addElement(tipo);
        }
        for (String eje : listaEjes) {
            listModelEjes.addElement(eje);
        }
        
        
      jListaPatentes= new JList<>(listModelPatentes);    
      jListaPatentes.setBounds(300,70, 70,350);  
      jListaPatentes.setFixedCellWidth(70);
      jListaPatentes.setFixedCellHeight(15);
      txtP.setBounds(300,-150,100,400);
      txtP.setFont(new Font("Dialog", Font.BOLD, 11)); 
      
      jListaTipos= new JList<>(listModelTipos);    
      jListaTipos.setBounds(405,70, 50,350); 
      jListaTipos.setFixedCellWidth(50);
      jListaTipos.setFixedCellHeight(15);
      txtT.setBounds(415,-150,100,400);
      txtT.setFont(new Font("Dialog", Font.BOLD, 11)); 
      
      
      jListaEjes= new JList<>(listModelEjes);
      jListaEjes.setBounds(375,70, 25,350);  
      jListaEjes.setFixedCellWidth(25);
      jListaEjes.setFixedCellHeight(15); 
      txtE.setBounds(375,-150,100,400);
      txtE.setFont(new Font("Dialog", Font.BOLD, 11)); 
      
      
      
      marco.add(jListaPatentes);
      marco.add(jListaTipos);
      marco.add(jListaEjes);
      
      marco.add(txtP);
      marco.add(txtT);
      marco.add(txtE);
    }
    
    
    public void actualizarListas(String[] nuevasPatentes, String[] nuevosTipos, String[] nuevosEjes) {
        

        // Limpiar los modelos actuales
        listModelPatentes.clear();
        listModelTipos.clear();
        listModelEjes.clear();

        // Añadir los nuevos datos
        for (String patente : nuevasPatentes) {
            listModelPatentes.addElement(patente);
        }
        for (String tipo : nuevosTipos) {
            listModelTipos.addElement(tipo);
        }
        for (String eje : nuevosEjes) {
            listModelEjes.addElement(eje);
        }
    }
    /*
    public void eliminarUltima(){
        int index1 = listModelPatentes.getSize()-1;
        int index2 = listModelTipos.getSize()-1;
        int index3 = listModelEjes.getSize()-1;
        
        listModelPatentes.remove(index1);
        listModelTipos.remove(index2);
        listModelEjes.remove(index3);
        
        
    }
    */
    
}





/*
String [] patentes;//lista de entrade de las patentes
    String [] tipos; //lista entrada de los tipos de vehiculos
    String [] ejes;// lista de los ejes registrados*/
