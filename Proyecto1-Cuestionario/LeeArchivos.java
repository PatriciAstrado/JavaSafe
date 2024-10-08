/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;import java.io.File;
import java.io.IOException;
import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 *
 * @author PC
 */
public class LeeArchivos {
    private String pregunta;
    private int peso;
    private int tipo_pregunta;
    private String[] oRespuestas;
    private String respuesta;
    public String archivo_Preguntas;
    private int cant_Preguntas;
    private boolean completa_leida;
    
    public LeeArchivos(){
            archivo_Preguntas = "Preguntas.txt";
        }
        public LeeArchivos(String archivo)throws IOException {    
            archivo_Preguntas = archivo;
    }
    
    public Exam crearExamen() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader(archivo_Preguntas); 
        BufferedReader flujo = new BufferedReader(fr); 
        String texto;
        String[] lista;
            while((texto = flujo.readLine()) != null){ //primera pasa al archivo para conseguir la cantidad de preguntas maxima
                lista = texto.split("|");
                if(lista[0] != "r" || lista[0] != "o"){
                    cant_Preguntas++;                    }
                }
        flujo.close();
        FileReader fr2 = new FileReader(archivo_Preguntas); 
        BufferedReader flujo2 = new BufferedReader(fr2);  //volvemos a leer el archiuvo de 0
        Exam examen = new Exam(cant_Preguntas);//creamos el examen con la cantidad indicada de preguntas
        while((texto = flujo2.readLine()) != null){
            
                 lista = texto.split("\\|");
                 
                if(!lista[0].equals("r") && !lista[0].equals("o")){
                    pregunta = lista[2];
                    peso = Integer.valueOf(lista[3]);
                    switch(lista[1]){ //dependiendo del tipo de pregunta la creamos
                        case "TF" -> tipo_pregunta = 1; 
                        case "RC" -> tipo_pregunta = 2;
                        case "SM" -> tipo_pregunta = 3;
                        default -> System.out.println("error switch de tipo preguntas");
                    }
                    }
                else if(lista[0].equals("o")){
                    oRespuestas = new String[lista.length - 1];
                    for (int i = 1; i < lista.length; i++) {   
                        oRespuestas[i - 1] = lista[i];  
                    }
                }                
                else if(lista[0].equals("r")){
                    respuesta = lista[1];
                    completa_leida =true;
                    }
            
            if(completa_leida==true){
                switch (tipo_pregunta) {
                case 1 -> examen.agregaPregunta(new TFpregunta(pregunta, Boolean.parseBoolean(respuesta), peso));
                case 2 -> examen.agregaPregunta(new RCpregunta(pregunta, respuesta, peso));
                case 3 -> examen.agregaPregunta(new SMpregunta(pregunta, oRespuestas, respuesta.charAt(0) - 'a', peso));
            }}
                completa_leida=false;
                

                }
        
        flujo2.close();
        
        
        return examen;

        }
    
        
    }

