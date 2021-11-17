import java.util.ArrayList;
import java.util.List;

public class Generar extends Thread {
    Paquete paquete;

    @Override
    public void run() {
        int pLigero = 0;
        int pPesado = 0;
        int pUltra = 0;

        List <Paquete> paquetes = new ArrayList<Paquete>();
        while(true){
            try {
                paquetes.add(new Paquete());
                sleep(1000);
                for (Paquete p : paquetes) {
                    if(p.getVolumen() < 0.5 && p.getPeso() < 5){
                        pLigero++;
                        System.out.println("Paquete Ligeros: " + pLigero);
                    }
                    else if(p.getVolumen() < 0.5 && p.getPeso() > 5){
                        pPesado++;
                        System.out.println("Paquete Pesados: " + pPesado);
                    }
                    else {
                        pUltra++;
                        System.out.println("Paquete Ultra Pesados: " + pUltra);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}
