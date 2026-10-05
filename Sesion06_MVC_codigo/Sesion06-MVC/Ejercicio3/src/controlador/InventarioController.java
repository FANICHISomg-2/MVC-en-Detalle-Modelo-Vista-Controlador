package controlador;

import modelo.InventarioModel;
import modelo.Item;
import vista.InventarioView;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem() {
        String nombre = vista.solicitarTexto("Nombre del item: ");
        int cantidad = vista.solicitarNumero("Cantidad: ");
        String tipo = vista.solicitarTipo();
        String descripcion = vista.solicitarTexto("Descripcion: ");
        if (nombre.isEmpty() || cantidad <= 0 || tipo.isEmpty()) {
            vista.mostrarMensaje("Datos del item no validos.");
            return;
        }
        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("Item agregado: " + nombre);
    }

    public void eliminarItem() {
        String nombre = vista.solicitarTexto("Nombre del item a eliminar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null && modelo.eliminarItem(item)) {
            vista.mostrarMensaje("Item eliminado: " + item.getNombre());
        } else {
            vista.mostrarMensaje("No se encontro el item.");
        }
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles() {
        String nombre = vista.solicitarTexto("Nombre del item: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarDetallesItem(item);
        } else {
            vista.mostrarMensaje("No se encontro el item.");
        }
    }

    public void buscarItem() {
        String nombre = vista.solicitarTexto("Nombre del item a buscar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje("Item encontrado: " + item.getNombre() + " x" +
                    item.getCantidad());
        } else {
            vista.mostrarMensaje("No se encontro el item.");
        }
    }

    public void usarItem() {
        String nombre = vista.solicitarTexto("Nombre del item a usar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje(item.usarItem());
        } else {
            vista.mostrarMensaje("No se encontro el item.");
        }
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarItem();
                    break;
                case "2":
                    eliminarItem();
                    break;
                case "3":
                    verInventario();
                    break;
                case "4":
                    mostrarDetalles();
                    break;
                case "5":
                    buscarItem();
                    break;
                case "6":
                    usarItem();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}
