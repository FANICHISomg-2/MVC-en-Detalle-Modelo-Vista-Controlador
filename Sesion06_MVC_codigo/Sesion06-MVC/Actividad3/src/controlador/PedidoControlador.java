package controlador;

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
        vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (Pendiente)");
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos("Lista de pedidos:", modelo.getPedidos());
    }

    public void eliminarPedido() {
        mostrarPedidos();
        if (modelo.getPedidos().isEmpty()) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del pedido a eliminar: ");
        if (modelo.eliminarPedido(numero - 1)) {
            vista.mostrarMensaje("Pedido eliminado y guardado en el historial.");
        } else {
            vista.mostrarMensaje("Numero de pedido no valido.");
        }
    }

    public void completarPedido() {
        mostrarPedidos();
        if (modelo.getPedidos().isEmpty()) {
            return;
        }
        int numero = vista.solicitarNumero("Numero del pedido a completar: ");
        if (modelo.completarPedido(numero - 1)) {
            vista.mostrarMensaje("Pedido marcado como completo.");
        } else {
            vista.mostrarMensaje("Numero no valido o el pedido ya esta completo.");
        }
    }

    public void mostrarPorEstado() {
        String estado = vista.solicitarEstado();
        if (estado.isEmpty()) {
            vista.mostrarMensaje("Estado no valido.");
            return;
        }
        vista.mostrarPedidos("Pedidos " + estado.toLowerCase() + "s:",
                modelo.buscarPorEstado(estado));
    }

    public void contarPendientes() {
        vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
    }

    public void verHistorial() {
        vista.mostrarPedidos("Historial de pedidos:", modelo.getHistorial());
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
                    completarPedido();
                    break;
                case "5":
                    mostrarPorEstado();
                    break;
                case "6":
                    contarPendientes();
                    break;
                case "7":
                    verHistorial();
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
