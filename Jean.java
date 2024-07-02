public class Jean extends Prenda {

    public Jean(String nombre,int codigo, double precio, int cantidadEnStock, Talle talle) {
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
        int tiempoAdicional = cantidadReestock / 10 * 10; // 10 días más por cada 10 prendas

        return tiempoBase + tiempoAdicional;
    }

    @Override
    public String toString() {
        return "Jean: " + super.toString();
    }
}
