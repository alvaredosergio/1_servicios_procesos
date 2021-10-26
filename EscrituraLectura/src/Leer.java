// La clase Leer, que será nuestro hilo 'Leer', con nombre para nombrar al hilo, y archivo, que será el archivo a leer.
public class Leer extends Thread {
    private String nombre;
    private Archivo arch;

    // Constructor
    public Leer(String nombre, Archivo arch) {
        super();
        this.nombre = nombre;
        this.arch = arch;
    }

    // Sobreescribimos el metodo 'run' de Thread para ejecutar el hilo.
    @Override
    public void run() {

        // Simples colores decorativos
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";

        // Bucle infinito While(true)
        while(true){
            // Obtenemos el estado del archivo, si está en 1, se puede leer.
            if(arch.getEstado() == 1){
                // Sincronizamos el archivo, y además ponemos el Estado de Archivo a 0, para informar que se está leyendo y NO SE PUEDE LEER.
                synchronized(arch){
                    arch.setEstado(0);
                    // Pintamos Quien está leyendo.
                    System.out.println(green + nombre + " está leyendo.");
                    System.out.print(reset);

                    // Ponemos a dormir el hilo 1 segundo (1000milisegundos) para ver como actuan.
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
                    // Sincronizamos el archivo de nuevo, estableciendo el Estado a 1 de nuevo porque ya se puede leer, y notifyAll() para 
                    // notificar a el resto de hilos de que el Archivo está disponible.
                    synchronized(arch){
                        arch.setEstado(1);
                        arch.notifyAll();
                    }
                break;
            }else{
                // Si el estado es != 0, sincronizamos archivo, y mostramos que los Hilos están esperando.
                synchronized(arch){
                    try {
                        System.out.println(yellow + nombre + " está esperando.");
                        System.out.print(reset);

                        // Archivo está esperando a ser leido.
                        arch.wait();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }

        // El hilo 'x' a terminado de leer.
        System.out.println(red + nombre + " ha terminado de leer.");
        System.out.print(reset);
    }
}

