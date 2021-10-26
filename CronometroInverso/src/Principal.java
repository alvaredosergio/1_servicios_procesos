import java.util.ArrayList;
import java.util.List;

public class Principal {

        public static void main(String[] args) {
            Cronometro crono1 = new Cronometro("Crono 1", 5);
            Cronometro crono2 = new Cronometro("Crono 2", 7);
            Cronometro crono3 = new Cronometro("Crono 3", 2);

            List <Cronometro> cronos = new ArrayList <Cronometro>();
            cronos.add(crono1);
            cronos.add(crono2);
            cronos.add(crono3); 

            for (Cronometro cronometro : cronos) {
                cronometro.start();
            }

            for (Cronometro cronometro : cronos) {
                try {
                    cronometro.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Todos los cronometros han terminado.");
        }   
}
