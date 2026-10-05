package controlador;

import modelo.Enemigo;
import modelo.Jugador;
import vista.CombateView;

public class CombateControlador {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;

    public CombateControlador(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void atacarEnemigo() {
        int danio = jugador.atacar();
        enemigo.recibirDanio(danio);
        vista.mostrarMensaje(jugador.getNombre() + " ataca a " + enemigo.getNombre() +
                " y le causa " + danio + " de dano.");
    }

    public void usarPocion() {
        vista.mostrarItems(jugador.getInventario().obtenerItems());
        String nombre = vista.solicitarTexto("Nombre de la pocion: ");
        vista.mostrarMensaje(jugador.usarObjeto(nombre));
    }

    public void equiparArma() {
        vista.mostrarItems(jugador.getInventario().obtenerItems());
        String nombre = vista.solicitarTexto("Nombre del arma: ");
        if (jugador.equiparArma(nombre)) {
            vista.mostrarMensaje("Arma equipada: " + nombre);
        } else {
            vista.mostrarMensaje("No se pudo equipar esa arma.");
        }
    }

    public void turnoEnemigo() {
        int danio = enemigo.atacar();
        jugador.recibirDanio(danio);
        vista.mostrarMensaje(enemigo.getNombre() + " " + enemigo.getUltimaAccion() + " y causa " +
                danio + " de dano.");
    }

    public void iniciar() {
        vista.mostrarMensaje("Un " + enemigo.getNombre() + " aparece frente a " +
                jugador.getNombre() + ".");
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstado(jugador, enemigo);
            vista.mostrarMenu();
            String opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    atacarEnemigo();
                    break;
                case "2":
                    usarPocion();
                    break;
                case "3":
                    equiparArma();
                    break;
                case "4":
                    vista.mostrarMensaje(jugador.getNombre() + " huye del combate.");
                    vista.cerrarScanner();
                    return;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
                    continue;
            }
            if (enemigo.estaVivo()) {
                turnoEnemigo();
            }
        }
        if (jugador.estaVivo()) {
            vista.mostrarMensaje("Has derrotado a " + enemigo.getNombre() + ".");
        } else {
            vista.mostrarMensaje("Has sido derrotado por " + enemigo.getNombre() + ".");
        }
        vista.cerrarScanner();
    }
}
