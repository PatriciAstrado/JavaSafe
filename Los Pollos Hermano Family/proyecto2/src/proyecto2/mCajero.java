/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class mCajero extends mEmpleado {
    private int gananciaTotalOriginal;
    private int gananciaTotal;
    private ArrayList<mBoleta> boletas;
    
    public mCajero(String rut, String nombre, String apellido, int telefono) {
        super(rut, nombre, apellido, telefono);
        boletas = new ArrayList<>();
    }

   public void procesarPago(mPedido pedido) {
               if(!pedidoChecker(pedido)){return;}

    mBoleta boleta = new mBoleta();

    // Agregar platillos al objeto mBoleta
    for (mPlatillo platillo : pedido.getPlatillos()) {
        boleta.agregarPlatillo(platillo);
    }
    boletas.add(boleta);

    // Imprimir la boleta en la consola
    System.out.println("Pago procesado. Boleta generada:");
    boleta.imprimir();

    // Guardar la boleta en la base de datos
    guardarBoletaEnBD(boleta);
}
   private void guardarBoletaEnBD(mBoleta boleta) {
    String url = "jdbc:mysql://localhost:3306/los_pollos"; // Cambiar por tu URL de conexión
    String usuario = "root"; // Usuario de la base de datos
    String contraseña = ""; // Contraseña de la base de datos

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
        // Insertar boleta
        String sqlBoleta = "INSERT INTO boletas (valor_total) VALUES (?)";
        try (PreparedStatement stmtBoleta = conn.prepareStatement(sqlBoleta, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmtBoleta.setInt(1, boleta.getValorTotal());
            stmtBoleta.executeUpdate();

            // Obtener el ID generado de la boleta
            int idBoleta;
            try (var rs = stmtBoleta.getGeneratedKeys()) {
                if (rs.next()) {
                    idBoleta = rs.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la boleta generada.");
                }
            }

            // Insertar detalles de la boleta
            String sqlDetalle = "INSERT INTO detalles_boleta (id_boleta, producto, cantidad, precio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtDetalle = conn.prepareStatement(sqlDetalle)) {
                for (mPlatillo platillo : boleta.getPlatillos()) {
                    stmtDetalle.setInt(1, idBoleta);
                    stmtDetalle.setString(2, platillo.getNombre());
                    stmtDetalle.setInt(3, 1); // Suponemos cantidad fija de 1 para cada platillo
                    stmtDetalle.setInt(4, platillo.getValor());
                    stmtDetalle.addBatch(); // Añadir al batch para ejecución en lote
                }
                stmtDetalle.executeBatch(); // Ejecutar lote
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al guardar la boleta en la base de datos: " + e.getMessage());
    }
}
    
    
    
    public int gastosTotales(){
        this.gananciaTotal = 0;
        for(mBoleta boleta : boletas){
            this.gananciaTotal += boleta.getValorTotal();
        }
        this.gananciaTotalOriginal = this.gananciaTotal;
        return this.gananciaTotal;
    }
    public int gastosTotalesOriginales(){
        return this.gananciaTotalOriginal;
    }
     private boolean pedidoChecker(mPedido pedido){
        if(pedido.isEmpty()){
            System.out.println("El pedido estaba vacio. Boleta no generada");
            return false;
        }

        return true;
    }
    
}
