package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Item;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("Opciones:");
        System.out.println("1. Agregar item");
        System.out.println("2. Eliminar item");
        System.out.println("3. Ver inventario");
        System.out.println("4. Mostrar detalles de un item");
        System.out.println("5. Buscar item");
        System.out.println("6. Usar item");
        System.out.println("7. Salir");
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
        System.out.println("1. Arma");
        System.out.println("2. Pocion");
        int opcion = solicitarNumero("Elige el tipo: ");
        if (opcion == 1) {
            return "Arma";
        }
        if (opcion == 2) {
            return "Pocion";
        }
        return "";
    }

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario esta vacio.");
        } else {
            System.out.println("Inventario:");
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                System.out.println((i + 1) + ". " + item.getNombre() + " x" + item.getCantidad() +
                        " (" + item.getTipo() + ")");
            }
        }
    }

    public void mostrarDetallesItem(Item item) {
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripcion: " + item.getDescripcion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
