/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.List;
import java.util.ArrayList;

public class ControladorLocal {

  private mAdministrador manager;
  private mMenu menu = new mMenu();
  private ArrayList<mEmpleado> empleados;
  private mCajero refereciaCajero;
  private mMenu menuPedido = new mMenu();
  private String rutMeseroActual;
  private boolean accedido = false;
  private boolean hayCajero = false;

  // si no existe un manager de antes, se llama esto
  public ControladorLocal(String rut, String nombre, String apellido, int telefono, String contraseña) {
    this.manager = new mAdministrador(rut, nombre, apellido, telefono, contraseña);
    this.accedido = true;
    this.empleados = new ArrayList<>();
    System.out.println("No hay empleados contratados");
  }
  public ControladorLocal(String contraseña) { // si ya hay un manager guradado se carga apartir de la constraseña
    if (this.manager.validarClave(contraseña)) {
      System.out.println("ingresado");
      this.accedido = true;
      revisaCajero();
    }
  }
  private void revisaCajero() {
    hayCajero = false;
    for (mEmpleado empleado : this.empleados) {
      if (empleado instanceof mCajero) {
    
        hayCajero = true;
        refereciaCajero = (mCajero)empleado;
        return;
      }
    }
    System.out.println("No hay un cajero contratado.");
  }
  /* funcion que retorna las ganancias totales de todas la boletas en el cajero
 public int checkChecker(){
     return this.refereciaCajero.gastosTotales();
 }*/
  public void agregarEmpleado(int tipo, String rut, String nombre, String apellido, int telefono) {
    if (this.accedido) { // solo se puede usar si se accedio con la contraseña
      switch (tipo) {
      case 1: // mesero
        this.manager.agregarEmpleado(empleados, new mMesero(rut, nombre, apellido, telefono));
        break;
      case 2: // cajero
        this.manager.agregarEmpleado(empleados, new mCajero(rut, nombre, apellido, telefono));
        hayCajero = true;
        break;
      }
    }
  }
  public void modificarEmpleado(String rut, boolean onOff) {
    mEmpleado empleado = this.manager.buscarEmpleadoPorRut(empleados, rut);
    if (empleado != null) {
      this.manager.modificarEmpleadoEstado(empleado, onOff);
      System.out.println("Estado del empleado modificado correctamente.");
    } else {
      System.out.println("Error: No se encontró el empleado con RUT: " + rut);
    }
  }
  public void modificarEmpleado(String rut, boolean onOff, int telefono) {
    mEmpleado empleado = this.manager.buscarEmpleadoPorRut(empleados, rut);
    if (empleado != null) {
      this.manager.modificarEmpleadoEstado(empleado, onOff);
      empleado.setTelefono(telefono);
      System.out.println("Estado del empleado modificado correctamente.");
    } else {
      System.out.println("Error: No se encontró el empleado con RUT: " + rut);
    }
  }

  public void agregarPlatillo(String nombre, String descripcion, int valor) {
    if (this.accedido) {
        // Consulta para verificar si el platillo ya existe
        String checkQuery = "SELECT COUNT(*) FROM platillos WHERE nombre = ?";
        // Consulta para insertar un nuevo platillo
        String insertQuery = "INSERT INTO platillos (nombre, descripcion, valor) VALUES (?, ?, ?)";
        
        try (Connection connection = mConexion.getConnection(); 
             PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            
            // Verificar si el platillo ya existe
            checkStatement.setString(1, nombre);
            var resultSet = checkStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            
            if (count > 0) {
                System.out.println("El platillo ya existe en la base de datos.");
                return; // No continuar si el platillo ya existe
            }
            
            // Si no existe, agregar el nuevo platillo
            insertStatement.setString(1, nombre);
            insertStatement.setString(2, descripcion);
            insertStatement.setInt(3, valor);
            
            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Platillo agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el platillo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el platillo: " + e.getMessage());
        }
    } else {
        System.out.println("No tienes acceso para realizar esta operación.");
    }
}


  public void quitarPlatillo(String nombre) {
    if (this.accedido) {
        String query = "DELETE FROM Platillos WHERE nombre = ?"; // Consulta correcta

        try (Connection connection = mConexion.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombre); // Establecer el nombre del platillo
            int rowsAffected = statement.executeUpdate(); // Ejecutar el DELETE

            if (rowsAffected > 0) {
                System.out.println("Platillo eliminado correctamente.");
            } else {
                System.out.println("El platillo no existe en la base de datos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el platillo: " + e.getMessage());
        }
    } else {
        System.out.println("No tienes acceso para realizar esta operación.");
    }
}


  
 
  public void agregarQuitarPedido(int opcion, mPlatillo plato) {
    if (!hayCajero){return;}
    
    
    if (plato == null) {
      System.out.println("Error: No existe el platillo  ");
      return;
    }

    switch (opcion) {
    case 1:
      this.menuPedido.agregarPlatillo(plato);
      System.out.println("Platillo agregado al pedido.");
      break;
    case 2:
      this.menuPedido.eliminarPlatillo(plato);
      System.out.println("Platillo eliminado del pedido.");
      break;
    default:
      System.out.println("Opción inválida.");
    }
  }
  
  public void TerminarPedido(String rutMesero) {
    revisaCajero();
    if (!hayCajero){
      return;}

    mEmpleado empleado = this.manager.buscarEmpleadoPorRut(this.empleados, rutMesero);
    if (empleado instanceof mMesero mesero) {
      mPedido pedido = mesero.procesarPedidoMenu(this.menuPedido); // Procesa el pedido
      this.refereciaCajero.procesarPago(pedido);                  // Procesa el pago
      this.menuPedido = new mMenu();                               // Limpia el menú de pedidos
      System.out.println("Pedido procesado y pagado correctamente.");
    } else {
      System.out.println("Error: El empleado con RUT: " + rutMesero + " no es un mesero.");
    }
  }

  public void TerminarPedido() { // sin llamada para forma semi automatica
    revisaCajero();
    if (!hayCajero)
      return;
    mEmpleado empleado = this.manager.buscarEmpleadoPorRut(this.empleados, rutMeseroActual);
    if (empleado instanceof mMesero mesero) {
      mPedido pedido = mesero.procesarPedidoMenu(this.menuPedido); // Procesa el pedido
      this.refereciaCajero.procesarPago(pedido);                  // Procesa el pago
      this.menuPedido = new mMenu();                               // Limpia el menú de pedidos
      System.out.println("Pedido procesado y pagado correctamente.");
    } else {
      //System.out.println("Error: El empleado con RUT: " + rutMeseroActual + " no es un mesero.");
    }
  }

  public int conseguirGananciasTotales() {
    if (!hayCajero)
      return -1;

    return this.refereciaCajero.gastosTotalesOriginales();
  }
  
      

  public String nombrePlato(int idPlatillo) {
    String nombre = null;
    String query = "SELECT nombre FROM platillos WHERE id = ?";

    try (Connection connection = mConexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establece el valor del parámetro de la consulta
        statement.setInt(1, idPlatillo);
        
        try (var resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                // Recupera el nombre del platillo
                nombre = resultSet.getString("nombre");
            } else {
                System.out.println("No se encontró ningún platillo con el ID proporcionado.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener el nombre del platillo: " + e.getMessage());
    }

    return nombre;

  }
  public mPlatillo getPlato(int idPlatillo) {
    String query = "SELECT nombre,valor,descripcion FROM platillos WHERE id = ?";
    String nombre=null;
    int valor = 0;
    String descrip = null;
    try (Connection connection = mConexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establece el valor del parámetro de la consulta
        statement.setInt(1, idPlatillo);
        
        try (var resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                // Recupera el nombre del platillo
                nombre = resultSet.getString("nombre");
                valor = resultSet.getInt("valor");
                descrip = resultSet.getString("descripcion");
            } else {
                System.out.println("No se encontró ningún platillo con el ID proporcionado.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener el nombre del platillo: " + e.getMessage());
    }  
    mPlatillo plato = new mPlatillo(nombre,descrip,valor);  
    return plato;
  }/*lic mPlatillo objPlato(int posicionMenu) {
      String query = "SELECT * FROM platillos WHERE id=";
    return menu.buscarPlatillo(posicionMenu);
  }*/
  
  public int[] obtenerPrimerayUltimaId() {
    int[] ids = new int[2]; 
    String query = "SELECT MIN(id) AS primera_id, MAX(id) AS ultima_id FROM platillos";

    try (Connection connection = mConexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
         var resultSet = statement.executeQuery()) {

        if (resultSet.next()) {
            ids[0] = resultSet.getInt("primera_id"); // Primera ID
            ids[1] = resultSet.getInt("ultima_id");  // Última ID
        } else {
            System.out.println("La tabla está vacía.");
            return null; 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener las IDs: " + e.getMessage());
    }

    return ids;
}
  public int cantidadPlatos() {
    int[] id = obtenerPrimerayUltimaId();
    return id[1]-id[0];
  }
  public mMesero[] listaMeseros() {
    ArrayList<mMesero> lista = new ArrayList<>();
    for (mEmpleado empleado : this.empleados) {
      if (empleado instanceof mMesero) {
        lista.add((mMesero)empleado); // Hacemos el casting explícito a mMesero
      }
    }
    return lista.toArray(new mMesero[0]); // Convertimos la lista a un array de mMesero
  }

  public mMesero[] listaMeserosDisponibles() {
    ArrayList<mMesero> lista = new ArrayList<>();
    for (mEmpleado empleado : this.empleados) {
      if (empleado instanceof mMesero && empleado.isActivo()) {
        lista.add((mMesero)empleado); // Hacemos el casting explícito a mMesero
      }
    }
    if (lista.isEmpty()) {

      return null;
    }
    return lista.toArray(new mMesero[0]); // Convertimos la lista a un array de mMesero
  }
  public void actMeseroActual(String rut) {
    if (rut != null) {
      this.rutMeseroActual = rut;
    } else {
      this.rutMeseroActual = "rut no ingresado";
    }
  }

  public void onOffLogin() {
    if (this.accedido == true) { // log off si ya esta conectado
      accedido = false;
    }
  }
  public void onOffLogin(String pswr) {
    if (this.accedido == false && this.manager.validarClave(pswr)) { // log on si no esta conectado y paso la contraseña correcta
      this.accedido = true;
      System.out.println("CONTRASEÑA EXITOSA; LOG ON");
    }
  }
  public boolean logOnOff() {
    return this.accedido;
  }
  public boolean existePlatoEnMenu(String nombre) {
    String query = "SELECT 1 FROM Platillos WHERE nombre = ?";
    
    try (Connection connection = mConexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establece el valor del parámetro de la consulta
        statement.setString(1, nombre);
        
        try (var resultSet = statement.executeQuery()) {
            // Si hay resultados, el platillo existe
            return resultSet.next();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al verificar la existencia del platillo: " + e.getMessage());
    }
    
    // Si ocurre algún error, se asume que no existe el platillo
    return false;
}
  public void actualizarPlatoMenu(String nombrePlatillo, String nuevoNombre, int nuevoValor, String nuevaDescripcion) {
    String query = "UPDATE Platillos SET nombre = ?, valor = ?, descripcion = ? WHERE nombre = ?";
    
    try (Connection connection = mConexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        // Establece los valores de los parámetros
        statement.setString(1, nuevoNombre);
        statement.setInt(2, nuevoValor);
        statement.setString(3, nuevaDescripcion);
        statement.setString(4, nombrePlatillo);
        
        // Ejecuta la actualización
        int rowsAffected = statement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Platillo actualizado correctamente.");
        } else {
            System.out.println("No se encontró el platillo con el nombre especificado.");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al actualizar el platillo: " + e.getMessage());
    }
}
  private mEmpleado buscarEmpleadoPorRut(String rut) {
    return this.manager.buscarEmpleadoPorRut(empleados, rut);
  }
  public boolean existeEmpleado(String rut) {
    if (buscarEmpleadoPorRut(rut) instanceof mEmpleado) {
      return true;
    }
    return false;
  }

  public String[][] dataPedido() {
    return this.menuPedido.getArrayData();
  }
  public int precioTotal() {
    return this.menuPedido.gastoTotal();
  } // funcion devolver el total de gastos de el pedido

  public boolean estadoEmpleado(String rut) {
    return buscarEmpleadoPorRut(rut).isActivo();
  }
  
}
