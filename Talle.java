//Clase para crear poder crear nuevos talles en el futuro a partir de instancias

public class Talle {
    private String descripcion;

    public Talle(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
