package cronometro;

public class ThreadMinutos extends Thread {

    int min = 0;

    @Override
    public void run() {
        try{
            while(true){
                sleep(60000);
                min++;
            }
    }
        catch (Exception e){
            System.out.println("El cronometro no funciona.");
        }
    }
}
