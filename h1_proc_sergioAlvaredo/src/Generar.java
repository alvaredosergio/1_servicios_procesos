import java.util.ArrayList;
import java.util.List;

public class Generar extends Thread {
    Paquete paquete;
    boolean activo;
    int pLigero;
    int pPesado;
    int pUltra;
    int totalLigeros;
    int totalPesados;
    int totalUltra;

    public Generar() {
        this.activo = true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getTotalLigeros() {
        return totalLigeros;
    }

    public void setTotalLigeros(int totalLigeros) {
        this.totalLigeros = totalLigeros;
    }

    public int getTotalPesados() {
        return totalPesados;
    }

    public void setTotalPesados(int totalPesados) {
        this.totalPesados = totalPesados;
    }

    public int getTotalUltra() {
        return totalUltra;
    }

    public void setTotalUltra(int totalUltra) {
        this.totalUltra = totalUltra;
    }

    public int getpLigero() {
        return pLigero;
    }

    public void setpLigero(int pLigero) {
        this.pLigero = pLigero;
    }

    public int getpPesado() {
        return pPesado;
    }

    public void setpPesado(int pPesado) {
        this.pPesado = pPesado;
    }

    public int getpUltra() {
        return pUltra;
    }

    public void setpUltra(int pUltra) {
        this.pUltra = pUltra;
    }

    @Override
    public void run() {
        while(activo){
        List <Paquete> paquetes = new ArrayList<Paquete>();
        paquetes.add(new Paquete());
            try {
                for (Paquete p : paquetes) {
                    if(p.getVolumen() < 0.5 && p.getPeso() < 5){
                        pLigero++;
                        totalLigeros++;
                        System.out.println("Paquete Ligeros: " + pLigero);
                    }
                    else if(p.getVolumen() < 0.5 && p.getPeso() > 5){
                        pPesado++;
                        totalPesados++;
                        System.out.println("Paquete Pesados: " + pPesado);
                    }
                    else {
                        pUltra++;
                        totalUltra++;
                        System.out.println("Paquete Ultra Pesados: " + pUltra);
                    }
                    sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}
