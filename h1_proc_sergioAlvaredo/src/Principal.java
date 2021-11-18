public class Principal {
        static String reset = "\u001B[0m";
        static String red = "\u001B[31m";
        static String green = "\u001B[32m";
        static String yellow = "\u001B[33m";
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
        System.out.println("---------------------------------------------------------");
        System.out.println("TOTAL DE PAQUETES PROCESADOS EN 30s: ");
        System.out.println(green + "Paq. Ligeros: \t\t" + gen.totalLigeros + "\tCamiones totales: \t" + (int)gen.totalLigeros/50 + reset);
        System.out.println(yellow + "Paq. Pesados: \t\t" + gen.totalPesados + "\tCamiones totales: \t" + (int)gen.totalPesados/50 + reset);
        System.out.println(red + "Paq. Ultra Pesados: \t" + gen.totalUltra + "\tCamiones totales: \t" + (int)gen.totalUltra/50 + reset);
        
    }
}
