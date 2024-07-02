import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de prendas y agregar al control de stock
        Talle talleS = new Talle("S");
        Talle talleM = new Talle("M");
        Talle talleL = new Talle("L");

        Prenda jean = new Jean("Jean Azul", 1, 29.99, 10, talleM);
        Prenda buzo = new Buzo("THE CREATIVE MINDZ HOOD", 2, 39.99, 15, talleL, true, true);
        Prenda remera = new Remera("CMMNTY TEE", 3, 19.99, 8, talleS);
        Prenda sweater = new Sweater("THE RIPPED KNIT", 4, 49.99, 5, talleM);
        Prenda accesorio = new Accesorio("BLACK BEANIE", 5, 9.99, 12, talleS);

        ControlStock controlStock = ControlStock.getInstancia();
        controlStock.agregarPrenda(jean);
        controlStock.agregarPrenda(buzo);
        controlStock.agregarPrenda(remera);
        controlStock.agregarPrenda(sweater);
        controlStock.agregarPrenda(accesorio);

        // Consultar el stock actual
        List<Prenda> stockActual = controlStock.consultarStock();
        System.out.println("Stock actual:");
        for (Prenda prenda : stockActual) {
            System.out.println(prenda);
        }

        // Ejemplo de búsqueda de prenda por código y modificación de stock
        try {
            int codigoBuscar = 3; // Código de la remera
            Prenda remeraEncontrada = controlStock.buscarPrendaPorCodigo(codigoBuscar);
            System.out.println("\nPrenda encontrada por código " + codigoBuscar + ":");
            System.out.println(remeraEncontrada);

            // Calcular e imprimir el tiempo de espera calculado
            int tiempoEspera = remera.calcularTiempoEsperaReestock(20);
            System.out.println("\nTiempo de espera para reponer 20 prendas de la remera: " + tiempoEspera + " días.");

            // Agregar stock a la remera
            controlStock.agregarStockPorCodigo(codigoBuscar, 5);
            System.out.println("\nDespués de agregar stock:");
            System.out.println(controlStock.buscarPrendaPorCodigo(codigoBuscar));

            // Quitar stock de la remera
            controlStock.quitarStockPorCodigo(codigoBuscar, 2);
            System.out.println("\nDespués de quitar stock:");
            System.out.println(controlStock.buscarPrendaPorCodigo(codigoBuscar));
        } catch (PrendaNoEncontradaException | StockInsuficienteException e) {
            System.err.println(e.getMessage());
        }

        // Filtrar prendas por talle
        Talle talleFiltrar = talleS; // Filtrar por talle S
        List<Prenda> prendasFiltradas = controlStock.filtrarPrendasPorTalle(talleFiltrar);
        System.out.println("\nPrendas en talle " + talleFiltrar + ":");
        for (Prenda prenda : prendasFiltradas) {
            System.out.println(prenda);
        }
    }
}

