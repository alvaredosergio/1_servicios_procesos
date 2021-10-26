package cronometro;

public class Cronometro extends Thread {

    int min = 0;
    int seg = 0;
    int mil = 0;

    @Override
    public void run() {
        try{
            while(true){
                System.out.println(min +":"+ seg +":"+ mil);
                sleep(10);
                
                mil += 10;
                if(mil == 1000){
                    seg++;
                    mil = 0;
                }
                if(seg == 60){
                min++;
                seg = 0;
                }
            }
    }
        catch (Exception e){
            System.out.println("El cronometro no funciona.");
        }
        
    }
}