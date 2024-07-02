public class Buzo extends Prenda {
    private boolean conCapucha;
    private boolean conCierre;

    public Buzo(String nombre,int codigo, double precio, int cantidadEnStock, Talle talle, boolean conCapucha, boolean conCierre) {
        super(nombre,codigo, precio, cantidadEnStock, talle);
        this.conCapucha = conCapucha;
        this.conCierre = conCierre;
    }

    public boolean isConCapucha() {
        return conCapucha;
    }

    public void setConCapucha(boolean conCapucha) {
        this.conCapucha = conCapucha;
    }

    public boolean isConCierre() {
        return conCierre;
    }

    public void setConCierre(boolean conCierre) {
        this.conCierre = conCierre;
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
        return "Buzo: " + super.toString() + ", Con Capucha: " + conCapucha + ", Con Cierre: " + conCierre;
    }
}
