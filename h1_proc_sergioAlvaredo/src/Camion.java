public class Camion extends Thread {
    Paquete paquete;
    Generar gen;
    boolean activo;

    public Camion(Generar gen) {
        this.gen = gen;
        this.activo = true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

        static String reset = "\u001B[0m";
        static String red = "\u001B[31m";
        static String green = "\u001B[32m";
        static String yellow = "\u001B[33m";

    @Override
    public void run() {
        while(true){
            if(gen.pLigero >= 50){
                gen.setpLigero(0);
                System.out.println(green + "Camion se ha llevado los paquetes Ligeros." + reset);
            }else if(gen.pPesado >= 50){
                gen.setpPesado(0);
                System.out.println(yellow + "Camion se ha llevado los paquetes Pesados." + reset);
            }else if(gen.pUltra >= 50){
                gen.setpUltra(0);
                System.out.println(red + "Camion se ha llevado los paquetes Ultra Pesados." + reset);
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

    

