package modelo;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    private String ultimaAccion;
    private Random random;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
        this.ultimaAccion = "";
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUltimaAccion() {
        return ultimaAccion;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public int atacar() {
        int danioBase = 5 + nivel * 2;
        int accion = random.nextInt(3);
        if (accion == 0) {
            ultimaAccion = "ataca";
            return danioBase;
        }
        if (accion == 1) {
            ultimaAccion = "lanza un ataque fuerte";
            return danioBase * 2;
        }
        ultimaAccion = "falla el ataque";
        return 0;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
    }
}
