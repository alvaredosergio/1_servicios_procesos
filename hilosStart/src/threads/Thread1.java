package threads;

public class Thread1 extends Thread {

    private String mensaje;
    

    public Thread1(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < 1000000; i++){
                if(i%10000 == 0){
                    System.out.println(mensaje + " - " + i/10000);
                }
            }
            //sleep(1000);
    }
        catch (Exception e){
            System.out.println("No funciona.");
        }
    }
}


