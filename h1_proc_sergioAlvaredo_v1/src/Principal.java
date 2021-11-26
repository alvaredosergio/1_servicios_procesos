public class Principal {
        static String reset = "\u001B[0m";
        static String red = "\u001B[31m";
        static String green = "\u001B[32m";
        static String yellow = "\u001B[33m";
        static String cyan = "\u001B[36m";
    public static void main(String[] args) {
        Generar gen = new Generar();
        Camion cam = new Camion(gen);
        gen.start();
        cam.start();

        try {
            Thread.sleep(30000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.setActivo(false);
        cam.setActivo(false); 

        int total = gen.totalLigeros + gen.totalPesados + gen.totalUltra;
        int camLig = (int)gen.totalLigeros/20;
        int camPes = (int)gen.totalPesados/20;
        int camUlt = (int)gen.totalUltra/20;
        int camTot = camPes + camLig + camUlt;

        System.out.println("----------------------------------------------------------");
        System.out.println("TOTAL DE PAQUETES PROCESADOS EN 1 minuto: ");
        System.out.println(green + "Paq. Ligeros: \t\t" + gen.totalLigeros + "\tCamiones expedidos: \t" + camLig + reset);
        System.out.println(yellow + "Paq. Pesados: \t\t" + gen.totalPesados + "\tCamiones expedidos: \t" + camPes + reset);
        System.out.println(red + "Paq. Ultra Pesados: \t" + gen.totalUltra + "\tCamiones expedidos: \t" + camUlt + reset);
        System.out.println("__________________________________________________________");
        System.out.println(cyan + "TOTAL: \t\t\t" + total + "\tCAMIONES TOTALES: \t" + camTot + reset + "\n");
        
    }
}
