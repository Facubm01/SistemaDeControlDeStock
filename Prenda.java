public abstract class Prenda {
    protected int codigo;
    protected String nombre;
    protected double precio;
    protected int cantidadEnStock;
    protected Talle talle;


    //CONSTRUCTOR
    public Prenda(String nombre,int codigo, double precio, int cantidadEnStock, Talle talle) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.talle = talle;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }


    //Métodos
    public void agregarStock(int cantidad) {
        this.cantidadEnStock += cantidad;
    }

    public void quitarStock(int cantidad) throws StockInsuficienteException {
        if (this.cantidadEnStock >= cantidad) {
            this.cantidadEnStock -= cantidad;
        } else {
            throw new StockInsuficienteException("Stock insuficiente para quitar: " + cantidad + " unidades de " + nombre);
        }
    }

    //Implementamos métodos abstractos
    public abstract boolean alertaStockBajo();
    public abstract int calcularTiempoEsperaReestock(int cantidadReestock);

    @Override
    public String toString() {
        String stockBajo = "";
        if (alertaStockBajo()) {
            stockBajo = " - ¡Alerta! Stock Bajo";
        }

        return "Nombre: " + nombre + ", Codigo: " + codigo + ", Precio: " + precio + ", Stock: " + cantidadEnStock +
                ", Talle: " + talle + stockBajo;
    }

}
