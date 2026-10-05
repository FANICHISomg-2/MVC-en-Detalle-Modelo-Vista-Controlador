/** Clase principal: crea el Modelo, la Vista y el Controlador y los conecta. */
public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
