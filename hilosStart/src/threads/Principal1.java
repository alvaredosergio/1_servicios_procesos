package threads;

public class Principal1 {
    public static void main(String[] args) {
        

        Thread1 hilo1 = new Thread1("Este es el hilo 1.");
        Thread1 hilo2 = new Thread1("Este es el hilo 2.");
        Thread1 hilo3 = new Thread1("Este es el hilo 3.");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
