package modelo;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    public static final String[] TIPOS = {"Entrada", "Plato de fondo", "Postre", "Bebida"};
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
            return true;
        }
        return false;
    }

    public boolean actualizarPedido(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.get(indice).setNombrePlato(nuevoNombre);
            return true;
        }
        return false;
    }

    public List<Pedido> buscarPorNombre(String texto) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public int contarPorTipo(String tipo) {
        return buscarPorTipo(tipo).size();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
