package examen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private boolean respuestaCorrecta;

    public TFpregunta(String text, boolean respuestaCorrecta, double peso) {
        super(text, peso);
        // Validación del texto de la pregunta
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto de la pregunta no puede ser null o vacío.");
        }
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            while (true) {
                System.out.println(getText() + " (V/F): ");
                String respuesta = in.nextLine().trim().toLowerCase();
                
                if (respuesta.equals("v") || respuesta.equals("f")) {
                    boolean usuarioResponde = respuesta.equals("v");
                    boolean esCorrecta = (usuarioResponde == respuestaCorrecta);
                    registrar(respuesta , esCorrecta);
                    if (esCorrecta) {
                        System.out.println("¡Correcto!");
                    } else {
                        System.out.println("Incorrecto.");
                    }
                    return esCorrecta;
                } else {
                    System.out.println("Entrada inválida. Por favor ingrese 'V' para Verdadero o 'F' para Falso.");
                    // Opcional: Limitar el número de intentos
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de entrada: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            return false;
        } finally {
            // No cerrar Scanner(System.in) para evitar cerrar el flujo de entrada estándar.
            // if (in != null) {
            //     in.close();
            // }
        }
    }
    
    @Override
    public void registrar(String respuesta, Boolean correcta) {
        File arch = new File("examen.txt");//cargamos el archivo txt examen

        
        try (FileWriter escritor = new FileWriter(arch, true)) {//si al crear el escritor no hay problemas empieza a escaribir en el archivo hasta que termine o suelte error
            escritor.write("Pregunta: " + getText() + "\n");
            escritor.write("Respuesta correcta: " + Boolean.toString(respuestaCorrecta).toUpperCase() + "\n");
            escritor.write("Respuesta introducida: " + respuesta.toUpperCase() + "\n");
            escritor.write("Puntaje: " + peso + "\n");
            if(correcta){
                escritor.write(":: CORRECTA ::\n\n");
            }else{
                escritor.write(":: INCORRECTA ::\n\n");
            }
            
            
        } catch (IOException e) {
            System.out.println("Un error ocurrió al escribir en el archivo.");
            
        }
    }

   
}
