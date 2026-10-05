package modelo;

import java.util.ArrayList;
import java.util.List;

public class TiendaModelo {
    private List<Producto> catalogo;
    private List<Producto> carrito;
    private List<Compra> historial;
    private double porcentajeDescuento;

    public TiendaModelo() {
        catalogo = new ArrayList<>();
        carrito = new ArrayList<>();
        historial = new ArrayList<>();
        porcentajeDescuento = 0;
    }

    public void agregarProducto(Producto producto) {
        catalogo.add(producto);
    }

    public boolean agregarAlCarrito(int indice) {
        if (indice >= 0 && indice < catalogo.size()) {
            carrito.add(catalogo.get(indice));
            return true;
        }
        return false;
    }

    public boolean eliminarDelCarrito(int indice) {
        if (indice >= 0 && indice < carrito.size()) {
            carrito.remove(indice);
            return true;
        }
        return false;
    }

    public boolean aplicarDescuento(String codigo) {
        if (codigo.equalsIgnoreCase("UCSM10")) {
            porcentajeDescuento = 10;
            return true;
        }
        if (codigo.equalsIgnoreCase("UCSM20")) {
            porcentajeDescuento = 20;
            return true;
        }
        return false;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : carrito) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public double calcularDescuento() {
        return calcularSubtotal() * porcentajeDescuento / 100;
    }

    public double calcularEnvio() {
        if (carrito.isEmpty()) {
            return 0;
        }
        if (calcularSubtotal() - calcularDescuento() >= 100) {
            return 0;
        }
        return 10;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularEnvio();
    }

    public Compra realizarCompra() {
        if (carrito.isEmpty()) {
            return null;
        }
        Compra compra = new Compra(new ArrayList<>(carrito), calcularSubtotal(),
                calcularDescuento(), calcularEnvio(), calcularTotal());
        historial.add(compra);
        carrito.clear();
        porcentajeDescuento = 0;
        return compra;
    }

    public List<Producto> getCatalogo() {
        return catalogo;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public List<Compra> getHistorial() {
        return historial;
    }
}
