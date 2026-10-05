import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MODELO - Guarda los pedidos y contiene la lógica de negocio.
 * Actividad 3: agrega estados, contador de pendientes e historial.
 * El historial guarda una copia de cada pedido en el momento en que fue
 * completado o eliminado, así no se pierde el registro aunque luego cambie.
 */
public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Pedido> getHistorial() {
        return historial;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < pedidos.size();
    }

    /**
     * Elimina el pedido de la lista activa, lo marca como ELIMINADO
     * y lo registra en el historial.
     */
    public boolean eliminarPedido(int indice) {
        if (!indiceValido(indice)) {
            return false;
        }
        Pedido pedido = pedidos.remove(indice);
        pedido.setEstado(Estado.ELIMINADO);
        historial.add(pedido.copiar());
        return true;
    }

    public boolean actualizarNombre(int indice, String nuevoNombre) {
        if (!indiceValido(indice)) {
            return false;
        }
        pedidos.get(indice).setNombrePlato(nuevoNombre);
        return true;
    }

    /**
     * Marca un pedido como COMPLETADO (ya fue servido) y lo registra en el historial.
     * Devuelve false si el índice no existe o si el pedido ya estaba completado.
     */
    public boolean marcarCompletado(int indice) {
        if (!indiceValido(indice)) {
            return false;
        }
        Pedido pedido = pedidos.get(indice);
        if (pedido.getEstado() == Estado.COMPLETADO) {
            return false;
        }
        pedido.setEstado(Estado.COMPLETADO);
        historial.add(pedido.copiar());
        return true;
    }

    public List<Pedido> buscarPorNombre(String texto) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /** Devuelve solo los pedidos que están en el estado indicado. */
    public List<Pedido> buscarPorEstado(Estado estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getEstado() == estado) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int contarTotal() {
        return pedidos.size();
    }

    public int contarPendientes() {
        return buscarPorEstado(Estado.PENDIENTE).size();
    }

    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new TreeMap<>();
        for (Pedido p : pedidos) {
            String clave = p.getTipo().toLowerCase();
            conteo.put(clave, conteo.getOrDefault(clave, 0) + 1);
        }
        return conteo;
    }
}
