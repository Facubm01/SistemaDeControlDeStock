//Excepción propia si se intenta quitar más stock del que hay en algun método

public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
