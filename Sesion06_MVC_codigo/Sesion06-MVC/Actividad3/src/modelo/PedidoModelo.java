package modelo;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    public static final String[] TIPOS = {"Entrada", "Plato de fondo", "Postre", "Bebida"};
    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.remove(indice);
            pedido.setEstado("Eliminado");
            historial.add(pedido);
            return true;
        }
        return false;
    }

    public boolean completarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            if (pedido.getEstado().equals("Pendiente")) {
                pedido.setEstado("Completo");
                historial.add(pedido);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarPorEstado(String estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals(estado)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public int contarPendientes() {
        return buscarPorEstado("Pendiente").size();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
}
