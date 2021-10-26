public class Coche extends Thread {
    private Estacionamiento est;


    public Coche(Estacionamiento est) {
        this.est = est;
    }

    int espera = (int)(Math.random()*1000+1);

    @Override
    public void run() {
        while(true){
            if(est.getPlazas() > 0){
                est.ocuparPlaza();
                est.aumentarAtencion();
                System.out.println("Coche aparcado. Plazas disponibles: " + est.getPlazas());
                int espera = (int)(Math.random()*1000+1);
                try {
                    sleep(espera);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(est){
                    est.liberarPlaza();
                    notifyAll();
                }
                System.out.println("Coche salió de estacionamiento. Plazas disponibles: " + est.getPlazas());
                break;   
            }else{
                try {
                    synchronized(est){
                    est.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
