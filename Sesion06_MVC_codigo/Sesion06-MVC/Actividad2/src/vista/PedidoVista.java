package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Pedido;
import modelo.PedidoModelo;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("Opciones:");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Buscar por nombre");
        System.out.println("6. Buscar por tipo");
        System.out.println("7. Contar pedidos");
        System.out.println("8. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public int solicitarNumero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String solicitarTipo() {
        String[] tipos = PedidoModelo.TIPOS;
        System.out.println("Tipos de plato:");
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        int opcion = solicitarNumero("Elige el tipo: ");
        if (opcion >= 1 && opcion <= tipos.length) {
            return tipos[opcion - 1];
        }
        return "";
    }

    public void mostrarPedidos(String titulo, List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println(titulo);
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println((i + 1) + ". " + pedido.getNombrePlato() + " (" +
                        pedido.getTipo() + ")");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
