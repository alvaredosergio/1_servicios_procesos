package join;

public class main1 {
    public static void main(String[] args) {
        h1 hilo1 = new h1(20,"Hilo 1");
        h1 hilo2 = new h1(30,"Hilo 2");

        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println("Terminado");
    }
}
