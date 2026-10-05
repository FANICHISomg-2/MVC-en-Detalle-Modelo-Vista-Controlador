/**
 * MODELO - Representa un pedido del restaurante.
 * Actividad 2: además del nombre, el plato tiene un tipo (entrada, fondo, postre...).
 */
public class Pedido {
    private String nombrePlato;
    private String tipo;

    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
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
}
