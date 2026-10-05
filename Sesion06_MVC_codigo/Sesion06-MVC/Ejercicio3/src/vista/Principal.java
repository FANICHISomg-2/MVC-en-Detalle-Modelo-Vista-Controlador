package vista;

import controlador.CombateControlador;
import modelo.Enemigo;
import modelo.InventarioModel;
import modelo.Item;
import modelo.Jugador;

public class Principal {
    public static void main(String[] args) {
        InventarioModel inventario = new InventarioModel();

        Item espada = new Item("Espada", 1, "Arma", "Espada de hierro");
        espada.setPoder(12);
        Item daga = new Item("Daga", 1, "Arma", "Daga rapida");
        daga.setPoder(7);
        Item pocion = new Item("Pocion", 2, "Pocion", "Recupera salud");
        pocion.setPoder(30);

        inventario.agregarItem(espada);
        inventario.agregarItem(daga);
        inventario.agregarItem(pocion);

        Jugador jugador = new Jugador("Nicole", 1, inventario);
        Enemigo enemigo = new Enemigo("Goblin", 40, 2, "Bestia");

        CombateView vista = new CombateView();
        CombateControlador controlador = new CombateControlador(jugador, enemigo, vista);
        controlador.iniciar();
    }
}
