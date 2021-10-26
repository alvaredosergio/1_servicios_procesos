public class Ejecucion extends Thread {
    private Estacionamiento est;

    public Ejecucion(Estacionamiento est) {
        super();
        this.est = est;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Coche c = new Coche(est);
            c.start();
            try {
                int esperaAparcando = (int)(Math.random()*200+1);
                Thread.sleep(esperaAparcando);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
