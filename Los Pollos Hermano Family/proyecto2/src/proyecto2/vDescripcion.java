package proyecto2;

import javax.swing.JTextField;

/**
 * Clase que encapsula un JTextField para mostrar la descripción de un platillo.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @autor patri
 */
public class vDescripcion {
  private ControladorLocal local;
  private JTextField textField;

  /**
   * Constructor de la clase vDescripcion.
   *
   * @param posicion Posición del platillo en la lista.
   * @param local    Referencia al controlador local para obtener la descripción del platillo.
   */
  public vDescripcion(int posicion, ControladorLocal local) {
    this.local = local;
    this.textField = new JTextField(20);
    this.textField.setEditable(false);                                 // Hace que el campo de texto no sea editable
    this.textField.setText(local.getPlato(posicion).getDescripcion()); // Establece el texto de la descripción
  }

  /**
   * Retorna el JTextField encapsulado.
   *
   * @return JTextField correspondiente a la descripción del platillo.
   */
  public JTextField getTextField() {
    return this.textField;
  }

  /**
   * Actualiza el texto del JTextField con la nueva descripción del platillo.
   *
   * @param posicion Posición del platillo en la lista.
   */
  public void actualizarDescripcion(int posicion) {
    this.textField.setText(local.getPlato(posicion).getDescripcion());
  }

  /**
   * Limpia el texto del JTextField.
   */
  public void reset() {
    this.textField.setText("");
  }
}
