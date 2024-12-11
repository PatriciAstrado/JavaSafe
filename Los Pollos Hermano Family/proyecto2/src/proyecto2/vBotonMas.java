package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Clase que encapsula el botón "+" y su lógica asociada.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @autor patri
 */
public class vBotonMas implements ActionListener {
  private JButton botonMas;
  private mPlatillo nombrePlatillo;
  private ControladorLocal local;
  private vMain origen;
  private int pos;
  /**
   * Constructor de la clase vBotonMas.
   *
   * @param posicion Posición del platillo en la lista.
   * @param local    Referencia al controlador local para gestionar pedidos.
   * @param origen   Referencia a la interfaz principal para actualizar la tabla.
   */
  public vBotonMas(int posicion, ControladorLocal local, vMain origen) {
    this.botonMas = new JButton("+");
    this.local = local;
    this.origen = origen;
    this.nombrePlatillo = this.local.getPlato(posicion);
    this.botonMas.addActionListener(this);
    this.pos = posicion;
  }

  /**
   * Retorna el botón encapsulado.
   *
   * @return JButton correspondiente al botón "+".
   */
  public JButton jbut() {
    return this.botonMas;
  }

  /**
   * Acción ejecutada al presionar el botón "+".
   * Incrementa la cantidad del platillo seleccionado y actualiza la tabla en la interfaz principal.
   *
   * @param e Evento de acción.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    this.local.agregarQuitarPedido(1, nombrePlatillo);
    this.origen.actualizarTabla();
    //this.origen.agregarPlatilloSeleccionado(this.local.getPlato(pos));
  }
}
