/**
 * MODELO - Representa un pedido del restaurante.
 * Actividad 3: además del nombre y el tipo, el pedido tiene un estado
 * (PENDIENTE, COMPLETADO o ELIMINADO). Todo pedido nuevo empieza PENDIENTE.
 */
public class Pedido {
    private String nombrePlato;
    private String tipo;
    private Estado estado;

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.estado = Estado.PENDIENTE;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /** Devuelve una copia del pedido con su estado actual (sirve para el historial). */
    public Pedido copiar() {
        Pedido copia = new Pedido(nombrePlato, tipo);
        copia.estado = this.estado;
        return copia;
    }
}
