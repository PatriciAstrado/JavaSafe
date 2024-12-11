package proyecto2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class vMain {
    private ControladorLocal local;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JLabel lblPrecioFinal;
    private vCombo comboMeseros;
    private JPanel scrollContent;

    // Panel donde se mostrarán los platillos añadidos (en la sección inferior derecha)
    private JPanel panelItemsSeleccionados;
    private JScrollPane scrollItems;

    public vMain(ControladorLocal local) {
        this.local = local;
        cargar();
    }

    public void cargar() {
        // Crear el marco principal (framePrincipal)
        JFrame marco = new JFrame("Los Pollos Hermanos APP");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(1000, 700);
        marco.setLocationRelativeTo(null); // Centrar en la pantalla

        // Layout principal
        mainPanel = new JPanel(new MigLayout("insets 3, gap 0", "[300px!][grow,fill]", "[grow,fill]"));
        marco.add(mainPanel);

        // Panel Contenedor 1 (Izquierda)
        JPanel panelContenedor1 = new JPanel(new MigLayout("insets 0, gap 0", "[grow,fill]", "[grow,fill]"));
        mainPanel.add(panelContenedor1, "cell 0 0,grow");

        // Panel de contenido con scroll (Platos disponibles)
        scrollContent = new JPanel(new MigLayout("wrap 1, insets 0", "[grow,fill]", "[]10[]"));
        scrollPane = new JScrollPane(scrollContent);
        panelContenedor1.add(scrollPane, "grow,push");

        // Agregar ítems dinámicos desde la base de datos
        cargarPlatillosDesdeBD();

        // Panel Contenedor 2 (Derecha)
        JPanel panelContenedor2 = new JPanel(new MigLayout("insets 0, gap 0, fill", "[grow,fill]", "[grow,fill][grow,fill][]"));
        mainPanel.add(panelContenedor2, "cell 1 0,grow");

        // Sección superior (Botones y combo)
        JPanel panelJpanel1 = new JPanel(new MigLayout("insets 0, gap 5", "[][][][]", "[]"));
        panelContenedor2.add(panelJpanel1, "growx, growy, wrap");

        // Botones y combo en panelJpanel1
        JButton log = (new vBotonLogin(local, this)).jbut();
        panelJpanel1.add(log, "growx");
        
        
        

        JButton botonGenerarBoleta = (new vBotonGenBoleta(local, this)).jbut();
        panelJpanel1.add(botonGenerarBoleta, "growx");

        comboMeseros = new vCombo(local);
        JComboBox combo = comboMeseros.getCombo();
        panelJpanel1.add(combo, "growx");

        JButton botonVerBoletas = new JButton("Ver Boletas");
        botonVerBoletas.addActionListener(e -> verBoletas());
        panelJpanel1.add(botonVerBoletas, "growx, wrap");

        // Sección inferior del contenedor2
        JPanel panelListado = new JPanel(new MigLayout("insets 0, gap 0, fill", "[grow,fill][grow,fill]", "[]0[grow,fill]"));
        panelContenedor2.add(panelListado, "grow, wrap");

        // Encabezados
        JPanel panelEncabezados = new JPanel(new MigLayout("insets 0, gap 0", "[grow,fill][grow,fill]", "[40px!]"));
        panelListado.add(panelEncabezados, "span 2, growx, wrap");

        JLabel lblPlatillo = new JLabel("Platillo");
        lblPlatillo.setHorizontalAlignment(SwingConstants.CENTER);
        panelEncabezados.add(lblPlatillo, "growx");

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        panelEncabezados.add(lblPrecio, "growx");

        // Lista de platillos seleccionados
        panelItemsSeleccionados = new JPanel(new MigLayout("insets 0, wrap 2", "[grow,fill][grow,fill]", ""));
        scrollItems = new JScrollPane(panelItemsSeleccionados);
        panelListado.add(scrollItems, "span 2, grow");

        // Label de precio final al fondo
        lblPrecioFinal = new JLabel("Precio Final: $0.00");
        lblPrecioFinal.setFont(new Font("Arial", Font.BOLD, 16));
        lblPrecioFinal.setHorizontalAlignment(SwingConstants.CENTER);
        panelContenedor2.add(lblPrecioFinal, "dock south, growx");

        marco.setVisible(true);
    }

    private void cargarPlatillosDesdeBD() {
        try (Connection connection = mConexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, nombre, descripcion, valor FROM platillos")) {

            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                double valor = resultSet.getDouble("valor");

                agregarPlatillo(scrollContent, nombre, descripcion, valor,id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar platillos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void agregar(JPanel scrollContent, int posicionLista) {
        JPanel panelItem = new JPanel(new MigLayout("wrap 4, insets 10", "[grow][grow][grow][grow]", "[]10[]"));
        panelItem.setBackground(Color.WHITE);
        // panelItem.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel label = (new vNombrePlato(posicionLista, local)).getLabel();
        panelItem.add(label, "span 1, align center");

        JButton botonMas = (new vBotonMas(posicionLista, local, this)).jbut();
        // botonMas.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelItem.add(botonMas, "growx, gap 5");

        JButton botonMenos = (new vBotonMenos(posicionLista, local, this)).jbut();
        // botonMenos.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelItem.add(botonMenos, "growx, gap 5, wrap");

        JTextField textField = (new vDescripcion(posicionLista, local)).getTextField();
        // textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        panelItem.add(textField, "span 4, growx, wrap");

        scrollContent.add(panelItem, "growx, wrap");
        
    }

    private void agregarPlatillo(JPanel scrollContent, String nombre, String descripcion, double valor, int id) {//,int posicionLista
        
 
        JPanel panelItem = new JPanel(new MigLayout("wrap 1, insets 10", "[grow,fill]", "[]10[]"));
        panelItem.setBackground(Color.WHITE);

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        panelItem.add(lblNombre);
        
        JButton botonMas = (new vBotonMas(id, local, this)).jbut();
        // botonMas.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelItem.add(botonMas, "growx, gap 5");

        JButton botonMenos = (new vBotonMenos(id, local, this)).jbut();
        // botonMenos.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelItem.add(botonMenos, "growx, gap 5, wrap");
        

        JLabel lblDescripcion = new JLabel("<html><p style='width:200px;'>" + descripcion + "</p></html>");
        lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
        panelItem.add(lblDescripcion);

        JLabel lblPrecio = new JLabel(String.format("$%.2f", valor));
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        panelItem.add(lblPrecio);

        scrollContent.add(panelItem, "growx, wrap");
        scrollContent.revalidate();
        scrollContent.repaint();
    }

    private void verBoletas() {
    try {
        // Crear una nueva instancia de vDetalleBoleta sin pasar la conexión
        new vDetalleBoleta();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al crear la ventana de detalles de la boleta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void actualizarLista() {
        scrollContent.removeAll();
        cargarPlatillosDesdeBD();
        scrollContent.revalidate();
        scrollContent.repaint();
    }

    public void actualizarCombo() {
        comboMeseros.act(); // Asumiendo que el método act() actualiza el JComboBox dinámicamente.
    }

    public void actualizarTabla() {
        // Método para actualizar la tabla de platillos seleccionados.
        panelItemsSeleccionados.removeAll();
        String[][] data = local.dataPedido(); 
        for (String[] fila : data) {
            JLabel lblNombre = new JLabel(fila[0]);
            JLabel lblPrecio = new JLabel(fila[1]);
            
            panelItemsSeleccionados.add(lblNombre, "growx");
            panelItemsSeleccionados.add(lblPrecio, "growx, wrap");
        }
        panelItemsSeleccionados.revalidate();
        panelItemsSeleccionados.repaint();
        lblPrecioFinal.setText(String.format("Precio Final: $%,.2f", (double) this.local.precioTotal()));
     
    }
}
