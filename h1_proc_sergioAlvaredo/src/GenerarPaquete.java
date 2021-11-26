import java.util.List;

public class GenerarPaquete extends Thread {
    List <Paquete> paquetes;
    boolean activo;
    String tipoPaquete;
    int multTiempo;
    int contador;

    public GenerarPaquete(List <Paquete> paquetes,String tipoPaquete) {
        this.activo = true;
        this.paquetes = paquetes;
        this.tipoPaquete = tipoPaquete;
        this.contador = 0;

        switch(tipoPaquete){
            case "Ligeros":
                this.multTiempo = 5;
            break;
            case "Pesados":
                this.multTiempo = 3;
            break;
            case "Ultra Pesados":
                this.multTiempo = 1;
            break;
        }
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        while(activo){
            if(paquetes.size() < 100){
                crearPaquete();
                contador++;
                System.out.println("Paquetes " + tipoPaquete + ": " + paquetes.size());
                try {
                    sleep(100*multTiempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                synchronized(paquetes){
                    try {
                        paquetes.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public synchronized void crearPaquete(){
        paquetes.add(new Paquete(tipoPaquete));
    }
}
