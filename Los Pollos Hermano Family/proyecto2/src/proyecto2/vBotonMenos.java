package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Clase que encapsula el botón "-" y su lógica asociada.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @author patri
 */
public class vBotonMenos implements ActionListener {
  private JButton botonMenos;
  private mPlatillo nombrePlatillo;
  private ControladorLocal local;
  private vMain origen;

  /**
   * Constructor de la clase vBotonMenos.
   *
   * @param posicion Posición del platillo en la lista.
   * @param local    Referencia al controlador local para gestionar pedidos.
   * @param origen   Referencia a la interfaz principal para actualizar la tabla.
   */
  public vBotonMenos(int posicion, ControladorLocal local, vMain origen) {
    this.botonMenos = new JButton("-");
    this.local = local;
    this.origen = origen;
    this.nombrePlatillo = this.local.getPlato(posicion);
      
    this.botonMenos.addActionListener(this);
  }

  /**
   * Retorna el botón encapsulado.
   *
   * @return JButton correspondiente al botón "-".
   */
  public JButton jbut() {
    return this.botonMenos;
  }

  /**
   * Acción ejecutada al presionar el botón "-".
   * Decrementa la cantidad del platillo seleccionado y actualiza la tabla en la interfaz principal.
   *
   * @param e Evento de acción.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    this.local.agregarQuitarPedido(2, nombrePlatillo);
    this.origen.actualizarTabla();
  }
}
