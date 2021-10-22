public class Principal {
    public static void main(String[] args) {
        // Instanciamos un producto
        Producto prod = new Producto();

        // Instanciamos nuestros hilos
        Comprar com = new Comprar(prod);
        Generar gen = new Generar(prod);

        // Iniciamos los hilos
        com.start();
        gen.start();

        // El tiempo que el Main va a estar ejecutando, en este caso 60 segundos
        while(true){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }

        // Detenemos los hilos
        com.stop();
        gen.stop();

        // Pintamos el resultado
        System.out.println("-------------------------------------");
        System.out.println("Unidades vendidas en 1 minuto: " + Comprar.unidadesVendidas);
        System.out.println("Ganancias obtenidas en 1 minuto: " + Comprar.ganancias + " €");
        System.out.println("-------------------------------------");
    }
}
