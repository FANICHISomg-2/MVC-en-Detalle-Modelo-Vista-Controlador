package modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;
    private int poder;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String usarItem() {
        if (cantidad <= 0) {
            return "No quedan unidades de " + nombre;
        }
        if (tipo.equals("Pocion")) {
            cantidad--;
            return "Usaste una " + nombre + ". Quedan " + cantidad;
        }
        return "Usaste el arma " + nombre;
    }
}
