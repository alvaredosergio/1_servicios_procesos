import java.util.List;

public class Carrera extends Thread {
    private List <Correr> corredores;

    public Carrera(List<Correr> corredores) {
        this.corredores = corredores;
    }

    @Override
    public void run(){
        for(Correr correr: corredores){
            correr.start();
        }
        for (Correr correr : corredores) {
            try {
                correr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CARRERA TERMINADA.");
    }
}
