package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Clase que encapsula el botón "Terminar pago" y su lógica asociada.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @author patri
 */
public class vBotonGenBoleta implements ActionListener {
  private JButton boton;
  private ControladorLocal local;
  private vMain origen;

  /**
   * Constructor de la clase vBotonGenBoleta.
   *
   * @param local  Referencia al controlador local para gestionar el pedido.
   * @param origen Referencia a la interfaz principal para actualizar la tabla.
   */
  public vBotonGenBoleta(ControladorLocal local, vMain origen) {
    this.local = local;
    this.origen = origen;
    boton = new JButton("Terminar pago");
    boton.addActionListener(this);
  }

  /**
   * Retorna el botón encapsulado.
   *
   * @return JButton correspondiente a "Terminar pago".
   */
  public JButton jbut() {
    return this.boton;
  }

  /**
   * Acción ejecutada al presionar el botón.
   * Finaliza el pedido y actualiza la tabla en la interfaz principal.
   *
   * @param e Evento de acción.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    this.local.TerminarPedido();
    this.origen.actualizarTabla();
    // System.out.println(this.local.checkChecker());
  }
}
