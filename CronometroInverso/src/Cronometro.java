public class Cronometro extends Thread {
    String nombre;
    int seg;

    public Cronometro(String nombre, int seg) {
        this.nombre = nombre;
        this.seg = seg;
    }

    @Override
    public void run() {
        for(int i = seg; i > 0; i--){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + ", que tenía "+ seg + " segundos de duración, ha terminado.");
    }
    
}