package proyecto2;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author patri
 */
public class vAdminMenu implements ActionListener, ItemListener, FocusListener {
  private ControladorLocal local;
  private vMain origen;
  private boolean menuEmpleado = false; // empleado = true, false = menu
  private String Nombre="";
  private int valor;
  private String rut;
  private int telefono;
  private String descripcion="";
  private boolean contratado;

  private JComboBox<String> comboSeleccion;
  private JTextField txtNombre;
  private JTextField txtPrecio;
  private JTextField txtRut;
  private JTextField txtTelefono;
  private JTextArea txtDescripcion;
  private JCheckBox chkOnOff;

  // Constructor de la clase vAdminMenu
  public vAdminMenu(ControladorLocal local, vMain origen) {
    this.local = local;
    this.origen = origen;

    // Crear el JDialog que servirá como ventana emergente
    JDialog menu = new JDialog();
    menu.setTitle("Manager");         // Título de la ventana
    menu.setSize(500, 400);           // Tamaño de la ventana
    menu.setResizable(false);         // No permitir redimensionar la ventana
    menu.setLocationRelativeTo(null); // Centrar el JDialog en la pantalla
    menu.setModal(true);              // Hacer el diálogo modal (bloquea la ventana principal)

    // Crear un panel principal con MigLayout
    JPanel panel = new JPanel(new MigLayout("wrap 4", "[right][grow][grow][grow]", "[][][][][][][]"));
    // "wrap 4" indica que cada fila contendrá 4 columnas
    // Las columnas están definidas como: [right][grow][grow][grow]

    // ComboBox para selección (Empleado/Menu)
    JLabel lblSeleccion = new JLabel("Seleccionar:");
    panel.add(lblSeleccion, "span 1, align right");

    // Crear un ComboBox para seleccionar "Empleado" o "Menú"
    String[] opciones = {"Empleado", "Menú"};
    comboSeleccion = new JComboBox<>(opciones);
    comboSeleccion.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionPerformedPV(e, 1); // Usar el método con el parámetro op = 1 para ComboBox
      }
    });
    panel.add(comboSeleccion, "span 3, growx");

    // Campo de texto para nombre empleado/platillo
    JLabel lblNombre = new JLabel("Nombre:");
    panel.add(lblNombre, "span 1, align right");

    txtNombre = new JTextField(20); // Campo de texto para ingresar el nombre
    txtNombre.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // No es necesario hacer nada aquí si no lo deseas
      }

      @Override
      public void focusLost(FocusEvent e) {
        Nombre = txtNombre.getText();
      }
    });
    panel.add(txtNombre, "span 3, growx");

    // Campo de texto para precio/salario
    JLabel lblPrecio = new JLabel("Precio/Salario:");
    panel.add(lblPrecio, "span 1, align right");

    txtPrecio = new JTextField(20); // Campo de texto para ingresar el precio o salario
    txtPrecio.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // No es necesario hacer nada aquí si no lo deseas
      }

      @Override
      public void focusLost(FocusEvent e) {
        try {
          valor = Integer.parseInt(txtPrecio.getText());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error de entrada SALARIO/VALOR", JOptionPane.ERROR_MESSAGE);
          txtPrecio.setText("");
        }
      }
    });
    panel.add(txtPrecio, "span 3, growx");

    // Campo de texto para Rut
    JLabel lblRut = new JLabel("Rut:");
    panel.add(lblRut, "span 1, align right");

    txtRut = new JTextField(20); // Campo de texto para ingresar el Rut
    txtRut.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // No es necesario hacer nada aquí si no lo deseas
      }

      @Override
      public void focusLost(FocusEvent e) {
        rut = txtRut.getText();
      }
    });
    panel.add(txtRut, "span 3, growx");

    // Campo de texto para telefono
    JLabel lblTelefono = new JLabel("Telefono:");
    panel.add(lblTelefono, "span 1, align right");

    txtTelefono = new JTextField(20); // Campo de texto para ingresar el teléfono
    txtTelefono.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // No es necesario hacer nada aquí si no lo deseas
      }

      @Override
      public void focusLost(FocusEvent e) {
        try {
          telefono = Integer.parseInt(txtTelefono.getText());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error de entrada TELEFONO", JOptionPane.ERROR_MESSAGE);
          txtTelefono.setText("");
        }
      }
    });
    panel.add(txtTelefono, "span 3, growx");

    // Campo de texto para descripción (solo cuando es menú)
    JLabel lblDescripcion = new JLabel("Descripción:");
    panel.add(lblDescripcion, "span 1, align right");

    txtDescripcion = new JTextArea(3, 20); // Área de texto para ingresar una descripción
    txtDescripcion.setLineWrap(true);
    txtDescripcion.setWrapStyleWord(true);
    txtDescripcion.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // No es necesario hacer nada aquí si no lo deseas
      }

      @Override
      public void focusLost(FocusEvent e) {
        // Aquí guardamos la descripción cuando el campo pierde el foco
        descripcion = txtDescripcion.getText(); // Asegúrate de que 'descripcion' es un atributo válido
      }
    });
    panel.add(new JScrollPane(txtDescripcion), "span 3, growx");

    // Botón de actualizar
    JButton btnActualizar = new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionPerformedPV(e, 2);
      }
    });
    panel.add(btnActualizar, "span 1, split 2, growx");

    // Botón de añadir/contratar
    JButton btnAñadir = new JButton("Añadir");
    btnAñadir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionPerformedPV(e, 3);
      }
    });
    panel.add(btnAñadir, "span 1, growx");

    // Checkbox On/Off
    chkOnOff = new JCheckBox("Off");
    chkOnOff.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionPerformedPV(e, 4);
      }
    });
    panel.add(chkOnOff, "span 1, align right");

    // Añadir el panel al JDialog
    menu.add(panel);
    menu.setVisible(true); // Hacer visible el diálogo
  }

  private void actionPerformedPV(ActionEvent e, int op) {
        switch(op){
           case 1: // ComboBox
                int id = comboSeleccion.getSelectedIndex(); // Para selección de empleado/menu
                if (id == 0) { // Empleado
                    this.menuEmpleado = false;
                } else if (id == 1) { // Menú
                    this.menuEmpleado = true;
                }
                actualizarEstadoRut(); // Actualiza los campos habilitados/deshabilitados
                break;   
            case 2://actualizar
                
                if(this.menuEmpleado && isFilled()){//modo menu
                    if(this.local.existePlatoEnMenu(this.Nombre) == true){
                        if(!contratado){//si le damos a actualizar y el check esta off ; actualiza descripcion y precio
                        this.local.actualizarPlatoMenu(Nombre, Nombre, valor, descripcion);
                        this.origen.actualizarLista();
                        reset();//limpiamos todo al terminar
                        }else if(contratado){//si le damos a actualizar mientras el check esta on: elimina el plato del menu
                            this.local.quitarPlatillo(Nombre);
                            this.origen.actualizarLista();
                        reset();//limpiamos todo al terminar
                        }                       
                        
                    }else{//si no existe el plato levantamos ventana de error
                        JOptionPane.showMessageDialog(null, "El plato que introdujo no existe", 
                                                          "ERROR El plato no existe", JOptionPane.ERROR_MESSAGE);
                    }reset();//limpiamos todo al terminar
                }else if(!this.menuEmpleado && isFilled()){//modo empleado
                    
                        if(this.local.existeEmpleado(this.rut)){
                            if(!this.contratado){
                                //System.out.println("nuevo telefono");
                                    this.local.modificarEmpleado(rut, true, telefono);            
                            }else {
                                if(this.local.existeEmpleado(this.rut)== true){
                                   // System.out.println("despedido");
                                   //cambiamos el estado del empleado dependiendo de su estado anterior
                                    this.local.modificarEmpleado(rut,! this.local.estadoEmpleado(rut));
                                    this.origen.actualizarCombo();
                                } 
                            }
                        }else{
                        JOptionPane.showMessageDialog(null, "El rut que usted puso no pertenece a ningun empleado", 
                                                          "ERROR El empleado no existe", JOptionPane.ERROR_MESSAGE);
                    }reset();//limpiamos todo al terminar
                }
                break;
            case 3://añadir
                if(this.menuEmpleado && isFilled()){
                     if(this.local.existePlatoEnMenu(this.Nombre) == false){//agregqar a menu plato
                        this.local.agregarPlatillo(Nombre, descripcion, valor);
                        this.origen.actualizarLista();
                     }else{
                         JOptionPane.showMessageDialog(null, "Este plato ya existe", 
                                                          "ERROR plato ya existe", JOptionPane.ERROR_MESSAGE);
                     }
                }else if(!this.menuEmpleado && isFilled()){
                    try{
                        if(this.local.existeEmpleado(this.rut)== false){
                            if(this.Nombre.split(" ").length != 1){
                            
                                this.local.agregarEmpleado(1, rut, this.Nombre.split(" ")[0], this.Nombre.split(" ")[1], telefono);
                            }else{
                            
                                this.local.agregarEmpleado(1, rut, this.Nombre.split(" ")[0], "", telefono);
                            }
                            
                            this.origen.actualizarCombo();
                        }else{
                            JOptionPane.showMessageDialog(null, "Usted ingreso el rut de un empleado que ya existe en la base de datos. Si lo quiere re-contratar introdusca su rut y dele a la casilla en el panel dereco superior.", 
                                                          "ERROR Empleado ya existente", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(Exception r){
                        System.out.println(r);//error de mierda
                        System.out.println("error en añadir empledo/vAdminMenu/actionPerformedPV/case3");
                    }
                }
                reset();
                
                break;
            case 4:
                if(chkOnOff.isSelected() == true){
                    contratado = true;
                    System.out.println(contratado);
                }
                if(chkOnOff.isSelected() == false){
                    contratado = false;
                    System.out.println(contratado);
                }
                break;
                    
                
        }
    }

  

  private void actualizarEstadoRut() {
    if (this.menuEmpleado) {
      txtRut.setEnabled(false); // Deshabilitar txtRut cuando es un empleado
      txtTelefono.setEnabled(false);
      txtDescripcion.setEnabled(true);
    } else {
      txtRut.setEnabled(true); // Habilitar txtRut cuando es menú
      txtTelefono.setEnabled(true);
      txtDescripcion.setEnabled(false);
    }
  }
  @Override
  public void itemStateChanged(ItemEvent e) {}
  @Override
  public void actionPerformed(ActionEvent e) {}
  @Override
  public void focusGained(FocusEvent e) {}
  @Override
  public void focusLost(FocusEvent e) {}

  private void reset(){
        txtDescripcion.setText("");//limpia texto de todos los campos
        chkOnOff.setSelected(false);
        txtNombre.setText("");
        txtPrecio.setText("");
        txtRut.setText("");
        txtTelefono.setText("");
        this.telefono = 0;
        this.valor = 0;
        this.descripcion="";
        this.Nombre = "";
        this.rut = "";
        //llamar cuando apretes actualizar o añadir, 
    }
  private boolean isFilled() { // Valida campos obligatorios
        if (Nombre == null || Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el nombre del plato/empleado.", 
                                          "ERROR CAMPO OBLIGATORIO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (valor == 0) {
            JOptionPane.showMessageDialog(null, "El precio/salario no puede ser 0 o estar vacío.", 
                                          "ERROR CAMPO OBLIGATORIO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!this.menuEmpleado) { // Validación solo para empleados
            if (this.telefono == 0 || this.rut == null || this.rut.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, introduzca el RUT y teléfono del empleado.", 
                                              "ERROR CAMPO OBLIGATORIO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
}
}
