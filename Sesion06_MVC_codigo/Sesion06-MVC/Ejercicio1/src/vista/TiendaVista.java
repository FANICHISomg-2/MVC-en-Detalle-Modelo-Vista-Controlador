package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Compra;
import modelo.Producto;

public class TiendaVista {
    private Scanner scanner;

    public TiendaVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("Opciones:");
        System.out.println("1. Agregar producto a la tienda");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento");
        System.out.println("7. Calcular envio");
        System.out.println("8. Ver historial de compras");
        System.out.println("9. Realizar compra");
        System.out.println("10. Salir");
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

    public double solicitarPrecio(String mensaje) {
        System.out.print(mensaje);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarProductos(String titulo, List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            System.out.println(titulo);
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                System.out.println((i + 1) + ". " + producto.getNombre() + " - S/ " +
                        String.format("%.2f", producto.getPrecio()));
            }
        }
    }

    public void mostrarResumen(double subtotal, double descuento, double envio, double total) {
        System.out.println("Subtotal: S/ " + String.format("%.2f", subtotal));
        System.out.println("Descuento: S/ " + String.format("%.2f", descuento));
        System.out.println("Envio: S/ " + String.format("%.2f", envio));
        System.out.println("Total: S/ " + String.format("%.2f", total));
    }

    public void mostrarHistorial(List<Compra> historial) {
        if (historial.isEmpty()) {
            System.out.println("Todavia no hay compras realizadas.");
        } else {
            System.out.println("Historial de compras:");
            for (int i = 0; i < historial.size(); i++) {
                Compra compra = historial.get(i);
                System.out.println("Compra " + (i + 1) + ": " + compra.getProductos().size()
                        + " productos - Total: S/ " + String.format("%.2f", compra.getTotal()));
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
