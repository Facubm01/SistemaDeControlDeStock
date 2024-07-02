public class Accesorio extends Prenda {
    public Accesorio(String nombre,int codigo, double precio, int cantidadEnStock, Talle talle) {
        super(nombre,codigo, precio, cantidadEnStock, talle);
    }

    @Override
    public boolean alertaStockBajo() {
        return cantidadEnStock < 10;
    }

    @Override
    public int calcularTiempoEsperaReestock(int cantidadReestock) {
        int tiempoBase = 7; // Tiempo base de espera
        int tiempoAdicional = cantidadReestock / 10 * 1; // 1 día más por cada 10 prendas
        return tiempoBase + tiempoAdicional;
    }

    @Override
    public String toString() {
        return "Accesorio: " + super.toString();
    }
}
