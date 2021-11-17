public class Principal {
    public static void main(String[] args) {
        Generar gen = new Generar();
        gen.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.setActivo(false);
    }
}
