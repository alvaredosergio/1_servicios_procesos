import java.util.List;

public class Colocar extends Thread{
    private List <Integer> recursos;

    public Colocar(List<Integer> recursos) {
        this.recursos = recursos;
    }

    @Override
    public void run() {
        while(true){
            synchronized (recursos){
                recursos.add(1);
                System.out.println("Colocar " + recursos.size());
                recursos.notifyAll();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}
