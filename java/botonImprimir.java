/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;  // Import the IOException class to handle errors


import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author patri
 */
public class botonImprimir implements ActionListener {    
    Peaje sistema;
    JFrame marco;
    JButton botonImp=new JButton("Registrar datos");//creating instance of JButton  
    JFileChooser chooser = new JFileChooser();
    
    String nombre;
    public botonImprimir(JFrame marcoIn, Peaje sistemaIn){
          
          sistema = sistemaIn;
          marco = marcoIn;

          botonImp.setBounds(310,420,120, 20);//x axis, y axis, width, height  
          botonImp.addActionListener(this);
          botonImp.setFont(new Font("Dialog", Font.BOLD, 10));
          marco.add(botonImp);
      }  
      
       public void actionPerformed(ActionEvent e){
           try{
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setDialogTitle("selecione o nombre un archivo .TXT");

                FileNameExtensionFilter restrict = new FileNameExtensionFilter("selecione o nombre un archivo .TXT", ".txt");
                chooser.addChoosableFileFilter(restrict);

                int r = chooser.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION)
                 {
                     if(!chooser.getSelectedFile().getAbsolutePath().contains(".txt")){
                         nombre = chooser.getSelectedFile().getAbsolutePath().concat(".txt");
                     }else{
                        nombre = chooser.getSelectedFile().getAbsolutePath();
                     }
                     
                     wrtLista(sistema.listaPatentes(),sistema.listaEjes(),sistema.listaTipos());
                 }
           }catch(Exception err){
               System.out.println("here");
               System.out.println(err);
           }
           
    }
       
       private void wrtLista(String[] lista,String[] lista2, String[] lista3){
           try{
           FileWriter wr = new FileWriter(nombre,true);
           wr.write("Patentes:\tEjes:\tTipo vehiculo:\n");
            for (int i = 0; i < lista.length; i++) {     
                wr.write(lista[i]+"\t"+lista2[i]+"\t"+lista3[i]+"\n");
                System.out.println(lista[i]+"\t"+lista2[i]+"\t"+lista3[i]);
                
           }
            wr.write("Ganancias totales: "+sistema.getGanancias()+"\n");
            wr.close();
               System.out.println(sistema.getGanancias());
           }catch(IOException err){
               System.out.println(err);
           }
       }
}
