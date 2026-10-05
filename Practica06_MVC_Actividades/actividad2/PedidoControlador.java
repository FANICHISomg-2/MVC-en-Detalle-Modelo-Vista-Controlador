import java.util.List;

/**
 * CONTROLADOR - Recibe las opciones de la Vista, valida los datos,
 * llama al Modelo y le pide a la Vista que muestre el resultado.
 */
public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipo) {
        if (nombrePlato.isEmpty() || tipo.isEmpty()) {
            vista.mostrarMensaje("El nombre y el tipo del plato no pueden estar vacíos.");
            return;
        }
        modelo.agregarPedido(new Pedido(nombrePlato, tipo));
        vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    public void eliminarPedido() {
        if (modelo.getPedidos().isEmpty()) {
            vista.mostrarMensaje("No hay pedidos para eliminar.");
            return;
        }
        mostrarPedidos();
        int indice = leerNumero("Número del pedido a eliminar: ");
        if (modelo.eliminarPedido(indice)) {
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("Número de pedido inválido.");
        }
    }

    public void actualizarPedido() {
        if (modelo.getPedidos().isEmpty()) {
            vista.mostrarMensaje("No hay pedidos para actualizar.");
            return;
        }
        mostrarPedidos();
        int indice = leerNumero("Número del pedido a actualizar: ");
        if (!modelo.indiceValido(indice)) {
            vista.mostrarMensaje("Número de pedido inválido.");
            return;
        }
        String nuevoNombre = vista.solicitarTexto("Nuevo nombre del plato: ");
        if (nuevoNombre.isEmpty()) {
            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
            return;
        }
        modelo.actualizarNombre(indice, nuevoNombre);
        vista.mostrarMensaje("Pedido actualizado.");
    }

    public void buscarPorNombre() {
        String texto = vista.solicitarTexto("Nombre a buscar: ");
        mostrarResultados(modelo.buscarPorNombre(texto));
    }

    public void buscarPorTipo() {
        String tipo = vista.solicitarTexto("Tipo a buscar: ");
        mostrarResultados(modelo.buscarPorTipo(tipo));
    }

    public void contarPedidos() {
        vista.mostrarConteo(modelo.contarTotal(), modelo.contarPorTipo());
    }

    private void mostrarResultados(List<Pedido> resultados) {
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron pedidos.");
        } else {
            vista.mostrarPedidos(resultados);
        }
    }

    /**
     * Pide un número a la vista (el usuario escribe desde 1) y lo devuelve en base 0.
     * Si escribe algo que no es número devuelve -1 (índice inválido).
     */
    private int leerNumero(String mensaje) {
        try {
            return Integer.parseInt(vista.solicitarTexto(mensaje)) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarTexto("Selecciona una opción: ");
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarTexto("Introduce el nombre del plato: ");
                    String tipo = vista.solicitarTexto("Introduce el tipo (entrada, fondo, postre...): ");
                    agregarPedido(nombre, tipo);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPorNombre();
                    break;
                case "6":
                    buscarPorTipo();
                    break;
                case "7":
                    contarPedidos();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}
