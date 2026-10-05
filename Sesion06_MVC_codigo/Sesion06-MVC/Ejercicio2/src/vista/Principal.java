package vista;

import controlador.InventarioController;
import modelo.InventarioModel;

public class Principal {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        controlador.iniciar();
    }
}
