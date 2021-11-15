import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List <Paquete> paquetesLigeros = new ArrayList<Paquete>();
        List <Paquete> paquetesPesados = new ArrayList<Paquete>();
        List <Paquete> paquetesUltraPesados = new ArrayList<Paquete>();

        List <Paquete> paquetes = new ArrayList<Paquete>();
        for (int i = 0; i < 100; i++) {
            paquetes.add(new Paquete());
        }

        for (Paquete p : paquetes) {
            if(p.getVolumen() < 0.5 && p.getPeso() < 5){
                paquetesLigeros.add(p);
            }
            else if(p.getVolumen() < 0.5 && p.getPeso() > 5){
                paquetesPesados.add(p);
            }
            else if(p.getVolumen() > 0.5 && p.getPeso() > 5){
                paquetesUltraPesados.add(p);
            }
        }

        for (Paquete p : paquetesLigeros) {
            System.out.println(p);
        }
    }
}
