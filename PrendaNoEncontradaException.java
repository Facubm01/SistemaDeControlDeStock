//Excepción propia si no encuentra la prensa en algun método

public class PrendaNoEncontradaException extends Exception {
    public PrendaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
