import java.util.Random;

public class Correr extends Thread {
    private Corredor cor;
    private int meta;
    private Posicion pos;

    public Correr(Corredor cor, int meta, Posicion pos) {
        this.cor = cor;
        this.meta = meta;
        this.pos = pos;
    }

    @Override
    public void run(){
        int tiempo = 0;
        while(tiempo < meta){
            Random r = new Random();
            tiempo += r.nextInt(meta/10);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin " + cor.getNombre() + " " + pos.getPos());
        pos.setPos(pos.getPos() + 1);

        cor.setLugar(pos.getPos());
        pos.setPos(pos.getPos() + 1);
    }

    public Corredor getCorredor(){
        return cor;
    }
    
}
