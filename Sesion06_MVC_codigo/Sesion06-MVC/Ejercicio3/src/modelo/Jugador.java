package modelo;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int nivel, InventarioModel inventario) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.inventario = inventario;
        this.salud = 100;
        this.armaEquipada = null;
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

    public InventarioModel getInventario() {
        return inventario;
    }

    public Item getArmaEquipada() {
        return armaEquipada;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public boolean equiparArma(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equals("Arma")) {
            armaEquipada = item;
            return true;
        }
        return false;
    }

    public int atacar() {
        if (armaEquipada == null) {
            return 2 + nivel;
        }
        return armaEquipada.getPoder() + nivel;
    }

    public String usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item == null) {
            return "No tienes ese objeto.";
        }
        if (!item.getTipo().equals("Pocion")) {
            return "Ese objeto no se puede usar asi.";
        }
        if (item.getCantidad() <= 0) {
            return "No quedan unidades de " + item.getNombre() + ".";
        }
        item.usarItem();
        salud += item.getPoder();
        if (salud > 100) {
            salud = 100;
        }
        return nombre + " recupera " + item.getPoder() + " de salud.";
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
    }
}
