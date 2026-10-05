package modelo;

import java.util.List;

public class Compra {
    private List<Producto> productos;
    private double subtotal;
    private double descuento;
    private double envio;
    private double total;

    public Compra(List<Producto> productos, double subtotal, double descuento, double envio,
            double total) {
        this.productos = productos;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.envio = envio;
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getEnvio() {
        return envio;
    }

    public double getTotal() {
        return total;
    }
}
