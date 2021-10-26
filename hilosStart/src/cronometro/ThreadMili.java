package cronometro;

public class ThreadMili extends Thread {

    int mili = 0;
    
    @Override
    public void run() {
        try{
            while(true){
                sleep(10);
                mili += 10;
                if(mili >= 1000){
                    mili = 0;
                }
            }
    }
        catch (Exception e){
            System.out.println("El cronometro no funciona.");
        }
    }
    
}
