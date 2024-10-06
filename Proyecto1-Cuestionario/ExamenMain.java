package examen;

import java.io.File;

public class ExamenMain {
    public static void main(String[] args) {
        File arch = new File("examen.txt");
        arch.delete(); //aseguramos que el archivo este vacio via  borrandolo, si no solo escribe en las siguientes lineas
        
        Exam examen = new Exam();

        // Agregar preguntas de Verdadero/Falso
        examen.agregaPregunta(new TFpregunta("La tierra es plana.", false, 1.0));
        examen.agregaPregunta(new TFpregunta("Java es un lenguaje de programación orientado a objetos.", true, 1.0));
        examen.agregaPregunta(new TFpregunta("El sol gira alrededor de la tierra.", false, 1.0));

        // Agregar preguntas de Selección Múltiple
        String[] opciones1 = {"Mercurio", "Venus", "Tierra", "Marte"};
        examen.agregaPregunta(new SMpregunta("¿Cuál es el planeta más cercano al sol?", opciones1, 0, 2.0));

        String[] opciones2 = {"C++", "Java", "Python", "Ruby"};
        examen.agregaPregunta(new SMpregunta("¿Cuál de estos lenguajes no es interpretado?", opciones2, 0, 2.0));

        String[] opciones3 = {"4", "5", "6", "7"};
        examen.agregaPregunta(new SMpregunta("¿Cuántos continentes hay en la tierra?", opciones3, 2, 2.0));

        // Agregar preguntas de Respuesta Corta
        examen.agregaPregunta(
          new RCpregunta("¿Cuál es el lenguaje de programación utilizado principalmente para Android?", "java", 2.0));
        examen.agregaPregunta(new RCpregunta("¿Qué gas es necesario para la respiración humana?", "oxigeno", 2.0));
        examen.agregaPregunta(new RCpregunta("Cuál es la capital de la Región de la RM?", "santiago", 2.0));

        // Dar el examen
        examen.darExam();
    }
}
