/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
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
    JLabel txtT = new JLabel(" TIPOS");
    
    public Lista(JFrame marcoIn, String[] listaPatente, String[] listaTipo, String[] listaEjes) {
        marco = marcoIn;

        // Inicializamos los DefaultListModels
        listModelPatentes = new DefaultListModel<>();
        listModelTipos = new DefaultListModel<>();
        listModelEjes = new DefaultListModel<>();

        // Llenamos los modelos de listas con los datos
        for (String patente : listaPatente) {
            listModelPatentes.addElement(patente);
        }
        for (String tipo : listaTipo) {
            listModelTipos.addElement(tipo);
        }
        for (String eje : listaEjes) {
            listModelEjes.addElement(eje);
        }

        // Crear las listas
        jListaPatentes = new JList<>(listModelPatentes);
        jListaTipos = new JList<>(listModelTipos);
        jListaEjes = new JList<>(listModelEjes);

        // Configuramos las dimensiones de las listas
        jListaPatentes.setFixedCellWidth(70);
        jListaPatentes.setFixedCellHeight(15);
        jListaTipos.setFixedCellWidth(50);
        jListaTipos.setFixedCellHeight(15);
        jListaEjes.setFixedCellWidth(25);
        jListaEjes.setFixedCellHeight(15);

        JScrollPane scrollPanePatentes = new JScrollPane(jListaPatentes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanePatentes.setBounds(300, 70, 70, 350);

        JScrollPane scrollPaneTipos = new JScrollPane(jListaTipos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneTipos.setBounds(425, 70, 50, 350);

        JScrollPane scrollPaneEjes = new JScrollPane(jListaEjes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneEjes.setBounds(375, 70, 40, 350);

        // Etiquetas para las listas
        txtP.setBounds(300, -150, 100, 400);
        txtP.setFont(new Font("Dialog", Font.BOLD, 11));

        txtT.setBounds(415, -150, 100, 400);
        txtT.setFont(new Font("Dialog", Font.BOLD, 11));

        txtE.setBounds(375, -150, 100, 400);
        txtE.setFont(new Font("Dialog", Font.BOLD, 11));

        // Agregamos los componentes al marco
        marco.add(scrollPanePatentes);  // JScrollPane de patentes
        marco.add(scrollPaneTipos);     // JScrollPane de tipos
        marco.add(scrollPaneEjes);      // JScrollPane de ejes

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
