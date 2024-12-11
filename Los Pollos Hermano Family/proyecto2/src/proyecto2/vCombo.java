package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 * Clase que encapsula un JComboBox para seleccionar meseros disponibles.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @autor patri
 */
public class vCombo implements ActionListener {
  private JComboBox<String> combo;
  private ControladorLocal local;
  private mMesero[] meseros;
  private String[] listaNombres;

  /**
   * Constructor de la clase vCombo.
   *
   * @param local Referencia al controlador local para gestionar meseros.
   */
  public vCombo(ControladorLocal local) {
    this.local = local;
    actualizarListaNombresInicial();

    // Inicializa el combo con los datos iniciales
    combo = new JComboBox<>(listaNombres);
    combo.addActionListener(this);
  }

  /**
   * Retorna el JComboBox encapsulado.
   *
   * @return JComboBox correspondiente a la selección de meseros.
   */
  public JComboBox<String> getCombo() {
    return this.combo;
  }

  /**
   * Maneja el evento de selección en el JComboBox.
   * Actualiza el mesero actual en el controlador local.
   *
   * @param e Evento de acción.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    JComboBox<String> cb = (JComboBox<String>)e.getSource();
    int idMesero = cb.getSelectedIndex();

    // Verificar si el índice es válido
    if (meseros != null && idMesero >= 0 && idMesero < meseros.length) {
      String rut = meseros[idMesero].getRut();
      this.local.actMeseroActual(rut);
    } else {
    //  System.out.println("Índice inválido o meseros no disponibles.");
    }
  }

  /**
   * Actualiza la lista de nombres de meseros y el JComboBox.
   */
  public void act() {
    // Actualiza los datos de meseros
    this.meseros = local.listaMeserosDisponibles();

    if (this.meseros != null && meseros.length > 0) {
      // Establece el primer mesero como el actual
      this.local.actMeseroActual(this.meseros[0].getRut());

      // Actualiza la lista de nombres de meseros
      listaNombres = new String[meseros.length];
      for (int i = 0; i < meseros.length; i++) {
        listaNombres[i] = meseros[i].getNombreCompleto();
      }
    } else {
      // Si no hay meseros disponibles
      listaNombres = new String[] {"Sin empleados disponibles"};
    }

    try {
      // Limpia todos los elementos del comboBox
      int itemCount = combo.getItemCount();
     // System.out.println("Cantidad de elementos antes de limpiar: " + itemCount);

      // Elimina cada elemento del comboBox
      while (combo.getItemCount() > 0) {
        combo.removeItemAt(0);
      }
     // System.out.println("Cantidad de elementos después de limpiar: " + combo.getItemCount());
    } catch (Exception e) {
      System.out.println("Error al limpiar los elementos del JComboBox:");
      e.printStackTrace();
    }

    // Agrega los nuevos elementos al comboBox
    for (String nombre : listaNombres) {
      combo.addItem(nombre);
    }

    // Actualiza visualmente el comboBox
    combo.revalidate();
    combo.repaint();
  }

  /**
   * Inicializa la lista de nombres de meseros al crear la instancia.
   */
  private void actualizarListaNombresInicial() {
    this.meseros = local.listaMeserosDisponibles();
    if (this.meseros != null && meseros.length > 0) {
      this.local.actMeseroActual(this.meseros[0].getRut());

      listaNombres = new String[meseros.length];

      for (int i = 0; i < meseros.length; i++) {
        listaNombres[i] = meseros[i].getNombreCompleto();
      }
    } else {
      listaNombres = new String[] {"Sin empleados disponibles"};
    }
  }
}
