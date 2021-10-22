// Objeto Generar será nuestro HILO de generar productos
public class Generar extends Thread {
    private Producto prod;

    // Constructor
    public Generar(Producto prod) {
        this.prod = prod;
    }

    //Decorativos
    String reset = "\u001B[0m";
    String green = "\u001B[32m";

    @Override
    public void run() {
        while(true){
            // Sincronizamos 'prod' porque estamos modificando el atributo Cantidad de producto, así ningun otro hilo puede acceder
            synchronized(prod){
                prod.aumentarCantidad();
                System.out.println(green + "Existencias aumentadas a " + prod.getCantidad() + reset);
                // Duerme 1 segundo, que es lo que tarda en Generar un producto
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }  
}
