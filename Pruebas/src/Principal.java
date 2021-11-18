public class Principal {
    public static void main(String[] args) throws Exception {
        Generar gen = new Generar();
        Camion cam = new Camion(gen);

        gen.start();
        cam.start();

        Thread.sleep(30000);

        gen.setActivo(false);
        cam.setActivo(false);
    }
}
