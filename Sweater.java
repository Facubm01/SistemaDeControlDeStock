public class Sweater extends Prenda {
    public Sweater(String nombre,int codigo, double precio, int cantidadEnStock, Talle talle) {
        super(nombre,codigo, precio, cantidadEnStock, talle);
    }

    @Override
    public boolean alertaStockBajo() {
        return cantidadEnStock < 10;
    }

    @Override
    public int calcularTiempoEsperaReestock(int cantidadReestock) {
        int tiempoBase = 7; // Tiempo base de espera

        // Añadir tiempo adicional según la cantidad de prendas solicitadas
        int tiempoAdicional = cantidadReestock / 10 * 5; // 5 días más por cada 10 prendas

        return tiempoBase + tiempoAdicional;
    }

    @Override
    public String toString() {
        return "Sweater: " + super.toString();
    }
}
