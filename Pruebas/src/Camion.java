public class Camion extends Thread {
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

    @Override
    public void run() {
        while(activo){
            if(gen.peq >= 2){
                gen.setPeq(0);
                notifyAll();
            }
            else if(gen.med >= 2){
                gen.setMed(0);
                notifyAll();
            }
            else if (gen.gran >= 2) {
                gen.setGran(0);
                notifyAll();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
