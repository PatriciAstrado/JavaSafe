package examen;

public class Exam {
    private Pregunta[] preguntas;
    private int contador;
    private static final int MAX_PREGUNTAS = 10;

    public Exam() {
        preguntas = new Pregunta[MAX_PREGUNTAS];
        contador = 0;
    }

    public void agregaPregunta(Pregunta p) {
        try {
            if (p == null) {
                throw new IllegalArgumentException("La pregunta no puede ser null.");
            }

            if (contador < MAX_PREGUNTAS) {
                preguntas[contador++] = p;
            } else {
                throw new IllegalStateException("No se pueden agregar más preguntas al examen.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar pregunta: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error al agregar pregunta: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado al agregar la pregunta: " + e.getMessage());
        }
    }

    public void darExam() {
        if (contador == 0) {
            System.out.println("El examen no tiene preguntas.");
            return;
        }

        double puntajeTotal = 0;
        double puntajeObtenido = 0;

        for (int i = 0; i < contador; i++) {
            try {
                System.out.println("\nPregunta " + (i + 1) + ":");
                boolean correcta = preguntas[i].buscar();
                puntajeTotal += preguntas[i].getPeso();
                if (correcta) {
                    puntajeObtenido += preguntas[i].getPeso();
                }
            } catch (NullPointerException e) {
                System.out.println("Error: La pregunta " + (i + 1) + " no está inicializada.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado al procesar la pregunta " + (i + 1) + ": " +
                                   e.getMessage());
            }
        }

        try {
            if (puntajeTotal == 0) {
                throw new ArithmeticException("El puntaje total es cero, no se puede calcular el porcentaje.");
            }
            double porcentaje = (puntajeObtenido / puntajeTotal) * 100;
            System.out.printf("\nResultado: %.2f%% (%f/%f)\n", porcentaje, puntajeObtenido, puntajeTotal);
        } catch (ArithmeticException e) {
            System.out.println("Error al calcular el porcentaje: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado al calcular el porcentaje: " + e.getMessage());
        }
    }
}
