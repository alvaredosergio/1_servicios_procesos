import java.util.ArrayList;
import java.util.List;

public class Main1 {
    static String reset = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String yellow = "\u001B[33m";
    static String cyan = "\u001B[36m";
    public static void main(String[] args) {
        List <Paquete> pLigeros = new ArrayList <Paquete>();
        List <Paquete> pPesados = new ArrayList <Paquete>();
        List <Paquete> pUltra = new ArrayList <Paquete>();

        GenerarPaquete genLig = new GenerarPaquete(pLigeros, "Ligeros");
        GenerarPaquete genPes = new GenerarPaquete(pPesados, "Pesados");
        GenerarPaquete genUlt = new GenerarPaquete(pUltra, "Ultra Pesados");


        Camion cam = new Camion(pLigeros,pPesados,pUltra);

        genLig.start();
        genPes.start();
        genUlt.start();
        cam.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        genLig.setActivo(false);
        genPes.setActivo(false);
        genUlt.setActivo(false);
        cam.setActivo(false);

        System.out.println("Proceso terminado.");

        
    }
}
