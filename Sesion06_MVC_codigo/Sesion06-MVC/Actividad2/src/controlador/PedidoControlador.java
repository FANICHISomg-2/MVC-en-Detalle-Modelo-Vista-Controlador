package controlador;

import java.util.List;
import modelo.Pedido;
import modelo.PedidoModelo;
import vista.PedidoVista;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido() {
        String nombrePlato = vista.solicitarTexto("Introduce el nombre del plato: ");
        if (nombrePlato.isEmpty()) {
            vista.mostrarMensaje("El nombre del plato no puede estar vacio.");
            return;
        }
        String tipo = vista.solicitarTipo();
        if (tipo.isEmpty()) {
            vista.mostrarMensaje("Tipo no valido.");
            return;
        }
        modelo.agregarPedido(new Pedido(nombrePlato, tipo));
        vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos("Lista de pedidos:", modelo.getPedidos());
    }

    public void eliminarPedido() {
        mostrarPedidos();
        if (modelo.contarPedidos() == 0) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del pedido a eliminar: ");
        if (modelo.eliminarPedido(numero - 1)) {
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("Numero de pedido no valido.");
        }
    }

    public void actualizarPedido() {
        mostrarPedidos();
        if (modelo.contarPedidos() == 0) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del pedido a actualizar: ");
        String nuevoNombre = vista.solicitarTexto("Nuevo nombre del plato: ");
        if (nuevoNombre.isEmpty()) {
            vista.mostrarMensaje("El nombre del plato no puede estar vacio.");
        } else if (modelo.actualizarPedido(numero - 1, nuevoNombre)) {
            vista.mostrarMensaje("Pedido actualizado.");
        } else {
            vista.mostrarMensaje("Numero de pedido no valido.");
        }
    }

    public void buscarPorNombre() {
        String texto = vista.solicitarTexto("Nombre a buscar: ");
        List<Pedido> resultado = modelo.buscarPorNombre(texto);
        vista.mostrarPedidos("Resultados de la busqueda:", resultado);
    }

    public void buscarPorTipo() {
        String tipo = vista.solicitarTipo();
        if (tipo.isEmpty()) {
            vista.mostrarMensaje("Tipo no valido.");
            return;
        }
        List<Pedido> resultado = modelo.buscarPorTipo(tipo);
        vista.mostrarPedidos("Resultados de la busqueda:", resultado);
    }

    public void contarPedidos() {
        vista.mostrarMensaje("Total de pedidos: " + modelo.contarPedidos());
        for (String tipo : PedidoModelo.TIPOS) {
            vista.mostrarMensaje(tipo + ": " + modelo.contarPorTipo(tipo));
        }
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarPedido();
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
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
            }
        } while (!opcion.equals("8"));
        vista.cerrarScanner();
    }
}
