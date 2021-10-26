package cronometro;

public class ThreadSegundos extends Thread {

    int seg = 0;

    @Override
    public void run() {
        try{
            while(true){
                sleep(1000);
                seg++;
                if(seg >= 60){
                    seg = 0;
                }
            }
    }
        catch (Exception e){
            System.out.println("El cronometro no funciona.");
        }
    }
    
}
