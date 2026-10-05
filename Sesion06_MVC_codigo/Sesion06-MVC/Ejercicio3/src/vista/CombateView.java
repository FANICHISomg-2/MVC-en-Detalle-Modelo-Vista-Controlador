package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Enemigo;
import modelo.Item;
import modelo.Jugador;

public class CombateView {
    private Scanner scanner;

    public CombateView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println();
        System.out.println("---- Combate ----");
        String arma = "Ninguna";
        if (jugador.getArmaEquipada() != null) {
            arma = jugador.getArmaEquipada().getNombre();
        }
        System.out.println(jugador.getNombre() + " (nivel " + jugador.getNivel() + ") - Salud: "
                + jugador.getSalud() + " - Arma: " + arma);
        System.out.println(enemigo.getNombre() + " (" + enemigo.getTipo() + ", nivel "
                + enemigo.getNivel() + ") - Salud: " + enemigo.getSalud());
    }

    public void mostrarMenu() {
        System.out.println("1. Atacar");
        System.out.println("2. Usar pocion");
        System.out.println("3. Equipar arma");
        System.out.println("4. Huir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void mostrarItems(List<Item> items) {
        for (Item item : items) {
            System.out.println("- " + item.getNombre() + " x" + item.getCantidad() + " (" +
                    item.getTipo() + ")");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
