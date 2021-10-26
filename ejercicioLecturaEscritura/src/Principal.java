public class Principal {
    public static void main(String[] args) {
        Estacionamiento est = new Estacionamiento();
        Ejecucion ej = new Ejecucion(est);

        ej.start();

        try {
            Thread.sleep(24000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(est.getAtenciones());
        System.exit(1);
    }
}
