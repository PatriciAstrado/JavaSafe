package proyecto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 * Clase que muestra los detalles de una boleta específica.
 * Utiliza MigLayout para una disposición más flexible y concisa.
 *
 * @autor patri
 */
public class vDetalleBoleta {
  private JFrame frame;
  private JComboBox<String> comboBoletas;
  private JTable tableDetalles;
  private DefaultTableModel tableModel;
  private Connection connection;

  /**
   * Constructor de la clase vDetalleBoleta.
   * Ahora la conexión se obtiene internamente usando la clase Conexion.
   */
  public vDetalleBoleta() throws SQLException {
    // Crear una nueva instancia de mConexion y obtener la conexión
    mConexion conexion = new mConexion();
    this.connection = conexion.getConnection(); // Obtener la conexión
    initialize();
  }

  /**
   * Inicializa y configura la interfaz gráfica.
   */
  private void initialize() {
    // Crear ventana
    frame = new JFrame("Detalles de Boleta");
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new MigLayout("fill", "[grow]", "[grow][]"));

    // Panel superior con el JComboBox y etiqueta
    JPanel panelTop = new JPanel(new MigLayout("insets 10, wrap 2", "[][grow]", "[]"));
    comboBoletas = new JComboBox<>();
    comboBoletas.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cargarDetallesBoleta();
      }
    });
    panelTop.add(new JLabel("Seleccionar Boleta:"), "align right");
    panelTop.add(comboBoletas, "growx");

    // Tabla para mostrar los detalles
    tableModel = new DefaultTableModel(new String[] {"Producto", "Cantidad", "Precio"}, 0);
    tableDetalles = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tableDetalles);
    scrollPane.setPreferredSize(new java.awt.Dimension(580, 250));

    // Añadir componentes a la ventana principal
    frame.add(panelTop, "growx, pushx, wrap");
    frame.add(scrollPane, "grow, push");

    // Cargar boletas en el JComboBox
    cargarBoletas();

    // Mostrar ventana
    frame.setVisible(true);
  }

  /**
   * Carga los IDs de boletas desde la base de datos y los añade al JComboBox.
   */
  private void cargarBoletas() {
    try {
      String query = "SELECT id_boleta FROM boletas";
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();

      ArrayList<String> boletas = new ArrayList<>();
      while (resultSet.next()) {
        boletas.add(resultSet.getString("id_boleta"));
      }

      // Limpiar y añadir elementos al JComboBox
      comboBoletas.removeAllItems();
      for (String id : boletas) {
        comboBoletas.addItem(id);
      }

      // Seleccionar el primer elemento si existe
      if (!boletas.isEmpty()) {
        comboBoletas.setSelectedIndex(0);
        cargarDetallesBoleta();
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(frame, "Error al cargar boletas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Carga y muestra los detalles de la boleta seleccionada en la JTable.
   */
  private void cargarDetallesBoleta() {
    String idBoletaSeleccionada = (String)comboBoletas.getSelectedItem();
    if (idBoletaSeleccionada == null)
      return;

    try {
      String query = "SELECT producto, cantidad, precio FROM detalles_boleta WHERE id_boleta = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, Integer.parseInt(idBoletaSeleccionada));
      ResultSet resultSet = statement.executeQuery();

      // Limpiar tabla
      tableModel.setRowCount(0);

      // Añadir filas a la tabla
      while (resultSet.next()) {
        String producto = resultSet.getString("producto");
        int cantidad = resultSet.getInt("cantidad");
        double precio = resultSet.getDouble("precio");
        tableModel.addRow(new Object[] {producto, cantidad, precio});
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(frame, "Error al cargar detalles de la boleta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
