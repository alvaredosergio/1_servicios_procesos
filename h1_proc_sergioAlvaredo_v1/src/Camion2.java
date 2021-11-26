import java.util.List;

public class Camion2 extends Thread {
    List <Paquete> pLigeros;
    List <Paquete> pPesados;
    List <Paquete> pUltra;
    boolean activo;
    int contador;

    public Camion2(List<Paquete> pLigeros, List<Paquete> pPesados, List<Paquete> pUltra) {
        this.pLigeros = pLigeros;
        this.pPesados = pPesados;
        this.pUltra = pUltra;
        this.activo = true;
        this.contador = 0;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }



    static String reset = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String yellow = "\u001B[33m";
    static String cyan = "\u001B[36m";

    @Override
    public void run() {
        while(activo){
            contador++;
            System.out.println(cyan + "EL CAMIÓN ACABA DE PASAR." + reset);
            if(pLigeros.size() == 100){
                pasoCamion(pLigeros);
                System.out.println(green + "Se ha vaciado el contenedor de ligeros." + reset);
                synchronized(pLigeros){
                    pLigeros.notify();
                }
            }
            if(pPesados.size() == 100){
                pasoCamion(pPesados);
                System.out.println(yellow + "Se ha vaciado el contenedor de pesados." + reset);
                synchronized(pPesados){
                    pPesados.notify();
                }
            }
            if(pUltra.size() == 100){
                pasoCamion(pUltra);
                System.out.println(red + "Se ha vaciado el contenedor de ultrapesados." + reset);
                synchronized(pUltra){
                    pUltra.notify();
                }
            }
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void pasoCamion(List <Paquete> paquetes){
        paquetes.clear();
    }
    
}
