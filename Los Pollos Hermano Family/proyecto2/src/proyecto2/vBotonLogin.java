package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

/**
 * Clase que encapsula el botón "LOG IN" y su lógica asociada.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @autor patri
 */
public class vBotonLogin implements ActionListener {
  private JButton boton;
  private vMain origen;
  private ControladorLocal local;

  /**
   * Constructor de la clase vBotonLogin.
   *
   * @param local  Referencia al controlador local para gestionar el login.
   * @param origen Referencia a la interfaz principal para actualizar componentes.
   */
  public vBotonLogin(ControladorLocal local, vMain origen) {
    this.local = local;
    this.origen = origen;
    boton = new JButton("LOG IN");
    boton.addActionListener(this);
  }

  /**
   * Retorna el botón encapsulado.
   *
   * @return JButton correspondiente a "LOG IN".
   */
  public JButton jbut() {
    return this.boton;
  }

  /**
   * Acción ejecutada al presionar el botón.
   * Muestra el formulario de login.
   *
   * @param e Evento de acción.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // Mostrar el formulario de login cuando se haga clic en el botón
    mostrarFormularioLogin(this.local);
  }

  /**
   * Método que crea y muestra el formulario de login.
   *
   * @param local Referencia al controlador local para gestionar el login.
   */
  private void mostrarFormularioLogin(ControladorLocal local) {
    // Crear un JDialog para el formulario de login
    JDialog loginDialog = new JDialog();
    loginDialog.setTitle("Login");
    loginDialog.setSize(300, 200);
    loginDialog.setLocationRelativeTo(null); // Centrar el JDialog en la pantalla
    loginDialog.setModal(true);              // Hacer el diálogo modal (bloquea la ventana principal)

    // Crear un panel principal con MigLayout
    JPanel panel = new JPanel(new MigLayout("wrap 2", "[right][grow]", "[][][]"));

    // Crear los componentes del formulario de login
    // JLabel lblUsuario = new JLabel("Usuario:"); // Comentado según el código original
    JLabel lblContraseña = new JLabel("Contraseña:");

    // JTextField txtUsuario = new JTextField(); // Comentado según el código original
    JPasswordField txtContraseña = new JPasswordField();

    JButton btnLogin = new JButton("Login");
    JButton btnCancel = new JButton("Cancelar");

    // Añadir componentes al panel
    // panel.add(lblUsuario, "align right");
    // panel.add(txtUsuario, "growx");
    panel.add(lblContraseña, "align right");
    panel.add(txtContraseña, "growx");

    // Añadir botones con separación
    panel.add(btnLogin, "span 1, split 2, align center, gap top 20");
    panel.add(btnCancel, "align center");

    // Añadir el panel al JDialog
    loginDialog.add(panel);

    // Acción al hacer clic en el botón de login
    btnLogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // String usuario = txtUsuario.getText(); // Comentado según el código original
        String contraseña = new String(txtContraseña.getPassword());
        local.onOffLogin(contraseña);
        loginDialog.dispose();
        if (local.logOnOff()) {
          new vAdminMenu(local, origen);
        }
      }
    });

    // Acción al hacer clic en el botón de cancelar
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Cerrar el diálogo sin hacer nada
        loginDialog.dispose();
      }
    });

    // Mostrar el JDialog
    loginDialog.setVisible(true);
  }
}
