import java.util.List;

public class Extraer extends Thread{
    private List <Integer> recursos;

    public Extraer(List<Integer> recursos) {
        this.recursos = recursos;
    }

    @Override
    public void run() {
        while(true){
            if(recursos.size() > 0){
                recursos.remove(0);
                System.out.println("Extraer " + recursos.size());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                break;
            }else{
                synchronized (recursos){
                    try {
                        recursos.wait();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }
    }    
}
