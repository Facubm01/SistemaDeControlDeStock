import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Clase Singleton para el stock
public class ControlStock {
    private List<Prenda> prendas;
    private static ControlStock instancia;

    private ControlStock() {
        this.prendas = new ArrayList<>();
    }

    public static ControlStock getInstancia() {
        if (instancia == null) {
            instancia = new ControlStock();
        }
        return instancia;
    }

    // Método para agregar una prenda al stock
    public void agregarPrenda(Prenda prenda) {
        this.prendas.add(prenda);
    }

    // Método para eliminar una prenda del stock por su código usando streams y removeIf
    public void eliminarPrendaPorCodigo(int codigo) throws PrendaNoEncontradaException {
        boolean eliminada = prendas.removeIf(prenda -> prenda.getCodigo() == codigo);

        if (!eliminada) {
            throw new PrendaNoEncontradaException("Prenda no encontrada con código: " + codigo);
        }
    }

    // Método para consultar el stock de todas las prendas
    public List<Prenda> consultarStock() {
        return new ArrayList<>(prendas);
    }

    // Método para buscar una prenda por su código
    public Prenda buscarPrendaPorCodigo(int codigo) throws PrendaNoEncontradaException {
        return prendas.stream()
                .filter(prenda -> prenda.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new PrendaNoEncontradaException("Prenda no encontrada con código: " + codigo));
    }


    // Método para agregar stock a una prenda por su código
    public void agregarStockPorCodigo(int codigo, int cantidad) throws PrendaNoEncontradaException {
        Prenda prenda = buscarPrendaPorCodigo(codigo);
        prenda.agregarStock(cantidad);
    }


    // Método para quitar stock de una prenda por su código
    public void quitarStockPorCodigo(int codigo, int cantidad) throws PrendaNoEncontradaException, StockInsuficienteException {
        Prenda prenda = buscarPrendaPorCodigo(codigo);
        prenda.quitarStock(cantidad);
    }

    // Método para obtener una lista de prendas de un determinado talle
    public List<Prenda> filtrarPrendasPorTalle(Talle talle) {
        return prendas.stream()
                .filter(prenda -> prenda.getTalle().equals(talle))
                .collect(Collectors.toList());
    }
}
