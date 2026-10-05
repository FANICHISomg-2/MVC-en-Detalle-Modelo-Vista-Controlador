package vista;

import controlador.TiendaControlador;
import modelo.Producto;
import modelo.TiendaModelo;

public class Principal {
    public static void main(String[] args) {
        TiendaModelo modelo = new TiendaModelo();
        modelo.agregarProducto(new Producto("Cuaderno", 8.50));
        modelo.agregarProducto(new Producto("Lapicero", 2.50));
        modelo.agregarProducto(new Producto("Mochila", 85.00));
        modelo.agregarProducto(new Producto("Mouse", 45.00));
        TiendaVista vista = new TiendaVista();
        TiendaControlador controlador = new TiendaControlador(modelo, vista);
        controlador.iniciar();
    }
}
