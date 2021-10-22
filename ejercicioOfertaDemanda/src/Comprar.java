// Objeto Comprar será nuestro HILO comprar
public class Comprar extends Thread {
    // Tendrá un objeto Producto como atributo
    private Producto prod;

    // Constructor
    public Comprar(Producto prod) {
        this.prod = prod;
    }
    
    // Variables para guardar las ganacias, y las unidades vendidas (unidadesVendidas debe ser static para utilizarlo en otra clase)
    static int ganancias = 0;
    static int unidadesVendidas = 0;

    //Decorativos
    String reset = "\u001B[0m";
    String red = "\u001B[31m";

    // Sobreescribir metodo run()
    @Override
    public void run() {
        while(true){
            if(prod.getCantidad() > 0){
                ganancias += prod.getPrecio();
                unidadesVendidas++;              
                prod.disminuirCantidad();
                System.out.println(red+"Existencias disminuidas a " + prod.getCantidad() + reset);
                try {
                    // Espera de entre 1 a 1000 milisegundos(1 segundo)
                    int espera = (int)(Math.random()*1000+1);
                    sleep(espera);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }else{
                // Sincronizamos 'prod' cuando espere, wait()
                synchronized(prod){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    
    
}
