import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * VISTA - Solo muestra información y lee lo que escribe el usuario.
 * No contiene reglas de negocio.
 */
public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== PEDIDOS DEL RESTAURANTE =====");
        System.out.println("1.  Agregar pedido");
        System.out.println("2.  Mostrar pedidos");
        System.out.println("3.  Eliminar pedido");
        System.out.println("4.  Actualizar nombre de un pedido");
        System.out.println("5.  Buscar pedido por nombre");
        System.out.println("6.  Buscar pedido por tipo");
        System.out.println("7.  Contar pedidos");
        System.out.println("8.  Marcar pedido como completo");
        System.out.println("9.  Mostrar pedidos por estado");
        System.out.println("10. Ver contador de pedidos pendientes");
        System.out.println("11. Ver historial");
        System.out.println("12. Salir");
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /** Lista los pedidos numerados desde 1, mostrando tipo y estado. */
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
            return;
        }
        System.out.println("Lista de Pedidos:");
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            System.out.println((i + 1) + ". " + p.getNombrePlato() + " (" + p.getTipo() + ") - " + p.getEstado());
        }
    }

    public void mostrarHistorial(List<Pedido> historial) {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println("Historial de pedidos:");
        for (Pedido p : historial) {
            System.out.println("- " + p.getNombrePlato() + " (" + p.getTipo() + ") - " + p.getEstado());
        }
    }

    public void mostrarConteo(int total, Map<String, Integer> porTipo) {
        System.out.println("Total de pedidos: " + total);
        for (Map.Entry<String, Integer> e : porTipo.entrySet()) {
            System.out.println("  - " + e.getKey() + ": " + e.getValue());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
