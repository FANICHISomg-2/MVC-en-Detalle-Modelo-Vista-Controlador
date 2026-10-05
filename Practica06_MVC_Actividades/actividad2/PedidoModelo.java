import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MODELO - Guarda la lista de pedidos y contiene la lógica de negocio:
 * agregar, eliminar, actualizar, buscar y contar. No imprime ni lee nada.
 */
public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /** Verifica que el índice (base 0) exista en la lista. */
    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < pedidos.size();
    }

    /** Elimina el pedido en la posición indicada. Devuelve false si el índice no existe. */
    public boolean eliminarPedido(int indice) {
        if (!indiceValido(indice)) {
            return false;
        }
        pedidos.remove(indice);
        return true;
    }

    /** Cambia el nombre de un pedido existente. Devuelve false si el índice no existe. */
    public boolean actualizarNombre(int indice, String nuevoNombre) {
        if (!indiceValido(indice)) {
            return false;
        }
        pedidos.get(indice).setNombrePlato(nuevoNombre);
        return true;
    }

    /** Busca pedidos cuyo nombre contenga el texto (sin distinguir mayúsculas). */
    public List<Pedido> buscarPorNombre(String texto) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /** Busca pedidos de un tipo exacto (sin distinguir mayúsculas). */
    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int contarTotal() {
        return pedidos.size();
    }

    /** Cuenta cuántos pedidos hay de cada tipo (tipo -> cantidad). */
    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new TreeMap<>();
        for (Pedido p : pedidos) {
            String clave = p.getTipo().toLowerCase();
            conteo.put(clave, conteo.getOrDefault(clave, 0) + 1);
        }
        return conteo;
    }
}
