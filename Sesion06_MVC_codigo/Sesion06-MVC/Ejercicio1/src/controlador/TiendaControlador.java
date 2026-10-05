package controlador;

import modelo.Compra;
import modelo.Producto;
import modelo.TiendaModelo;
import vista.TiendaVista;

public class TiendaControlador {
    private TiendaModelo modelo;
    private TiendaVista vista;

    public TiendaControlador(TiendaModelo modelo, TiendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarProducto() {
        String nombre = vista.solicitarTexto("Nombre del producto: ");
        double precio = vista.solicitarPrecio("Precio del producto: ");
        if (nombre.isEmpty() || precio <= 0) {
            vista.mostrarMensaje("Datos del producto no validos.");
            return;
        }
        modelo.agregarProducto(new Producto(nombre, precio));
        vista.mostrarMensaje("Producto agregado: " + nombre);
    }

    public void listarProductos() {
        vista.mostrarProductos("Productos disponibles:", modelo.getCatalogo());
    }

    public void agregarAlCarrito() {
        listarProductos();
        if (modelo.getCatalogo().isEmpty()) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del producto: ");
        if (modelo.agregarAlCarrito(numero - 1)) {
            vista.mostrarMensaje("Producto agregado al carrito.");
        } else {
            vista.mostrarMensaje("Numero de producto no valido.");
        }
    }

    public void verCarrito() {
        vista.mostrarProductos("Productos en el carrito:", modelo.getCarrito());
        if (!modelo.getCarrito().isEmpty()) {
            mostrarResumen();
        }
    }

    public void eliminarDelCarrito() {
        vista.mostrarProductos("Productos en el carrito:", modelo.getCarrito());
        if (modelo.getCarrito().isEmpty()) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del producto a eliminar: ");
        if (modelo.eliminarDelCarrito(numero - 1)) {
            vista.mostrarMensaje("Producto eliminado del carrito.");
        } else {
            vista.mostrarMensaje("Numero de producto no valido.");
        }
    }

    public void aplicarDescuento() {
        String codigo = vista.solicitarTexto("Codigo de descuento: ");
        if (modelo.aplicarDescuento(codigo)) {
            vista.mostrarMensaje("Descuento aplicado.");
        } else {
            vista.mostrarMensaje("Codigo no valido.");
        }
    }

    public void calcularEnvio() {
        vista.mostrarMensaje("Costo de envio: S/ " + String.format("%.2f",
                modelo.calcularEnvio()));
    }

    public void verHistorial() {
        vista.mostrarHistorial(modelo.getHistorial());
    }

    public void realizarCompra() {
        Compra compra = modelo.realizarCompra();
        if (compra == null) {
            vista.mostrarMensaje("El carrito esta vacio.");
        } else {
            vista.mostrarMensaje("Compra realizada con exito.");
            vista.mostrarResumen(compra.getSubtotal(), compra.getDescuento(), compra.getEnvio(),
                    compra.getTotal());
        }
    }

    private void mostrarResumen() {
        vista.mostrarResumen(modelo.calcularSubtotal(), modelo.calcularDescuento(),
                modelo.calcularEnvio(), modelo.calcularTotal());
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    listarProductos();
                    break;
                case "3":
                    agregarAlCarrito();
                    break;
                case "4":
                    verCarrito();
                    break;
                case "5":
                    eliminarDelCarrito();
                    break;
                case "6":
                    aplicarDescuento();
                    break;
                case "7":
                    calcularEnvio();
                    break;
                case "8":
                    verHistorial();
                    break;
                case "9":
                    realizarCompra();
                    break;
                case "10":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
            }
        } while (!opcion.equals("10"));
        vista.cerrarScanner();
    }
}
