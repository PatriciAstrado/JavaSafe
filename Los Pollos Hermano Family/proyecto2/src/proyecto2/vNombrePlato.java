package proyecto2;

import javax.swing.JLabel;

/**
 * Clase que encapsula un JLabel para mostrar el nombre y precio de un platillo.
 * Utiliza MigLayout para la disposición en el contenedor padre.
 *
 * @autor patri
 */
public class vNombrePlato {
    private JLabel label;
    private ControladorLocal local;
    private String nombrePlato;

    /**
     * Constructor de la clase vNombrePlato.
     *
     * @param posicion Posición del platillo en la lista.
     * @param local    Referencia al controlador local para obtener información del platillo.
     */
    public vNombrePlato(int posicion, ControladorLocal local) {
        this.local = local;
        this.nombrePlato = this.local.nombrePlato(posicion) + " : " + String.valueOf(this.local.getPlato(posicion).getValor()) + "$";
        this.label = new JLabel(nombrePlato);
        // Opcional: Personalizar el JLabel si es necesario (fuente, color, etc.)
        this.label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
    }

    /**
     * Retorna el JLabel encapsulado.
     *
     * @return JLabel correspondiente al nombre y precio del platillo.
     */
    public JLabel getLabel() {
        return this.label;
    }

    /**
     * Actualiza el texto del JLabel con un nuevo platillo.
     *
     * @param posicion Nueva posición del platillo en la lista.
     */
    public void actualizarNombrePlato(int posicion) {
        this.nombrePlato = this.local.nombrePlato(posicion) + " : " + String.valueOf(this.local.getPlato(posicion).getValor()) + "$";
        this.label.setText(nombrePlato);
    }

    /**
     * Limpia el texto del JLabel.
     */
    public void reset() {
        this.label.setText("");
    }
}
